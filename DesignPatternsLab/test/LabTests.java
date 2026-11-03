import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Locale;
import task1.*;
import task2.*;
import task3.*;
import task4.*;
import task5.*;

/** Dependency-free behavioral verification. Throws on the first failure. */
public final class LabTests {
    private static int checks;
    private static void check(boolean condition, String message) {
        checks++;
        if (!condition) throw new AssertionError(message);
    }
    private static void close(double actual, double expected) {
        check(Math.abs(actual - expected) < 0.000001, actual + " != " + expected);
    }
    private static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(bytes));
            action.run();
        } finally { System.setOut(original); }
        return new String(bytes.toByteArray(), StandardCharsets.UTF_8).replace("\r\n", "\n");
    }
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        String json = new JsonFormatter().format("a\"b", new String[]{"k"}, new String[][]{{"x\ny\\z"}});
        check(json.contains("a\\\"b") && json.contains("x\\ny\\\\z"), "JSON escaping");
        String csv = new CsvFormatter().format("T", new String[]{"key"}, new String[][]{{"a,\"b"}});
        check(csv.contains("\"a,\"\"b\""), "CSV quoting");
        final String[] payload = new String[1];
        Exporter sink = (destination, data) -> payload[0] = data;
        new Base64EncryptDecorator(new HeaderFooterDecorator(sink, "fixed")).export("x", "hello");
        check(payload[0].startsWith("=== METADATA HEADER: fixed ===\n[BASE64_CIPHERTEXT:"), "Decorator order follows runner");
        new Base64EncryptDecorator(sink).export("x", "hello");
        check(payload[0].equals("[BASE64_CIPHERTEXT:" + Base64.getEncoder().encodeToString("hello".getBytes(StandardCharsets.UTF_8)) + "]"), "Base64 payload");
        try { new Base64EncryptDecorator(null); throw new AssertionError("Null accepted"); }
        catch (IllegalArgumentException expected) { checks++; }

        StockProvider adapter = new StockFeedAdapter(new LegacyStockFeed() {
            public String fetchRawTickerPacket(String ticker) { return " ASK=12 ; BID=10 ; STATUS=OPEN "; }
        });
        close(adapter.getMarketPrice("A"), 11);
        check(adapter.getStatus("A").equals("OPEN"), "Packet status");
        final int[] calls = {0};
        StockProvider counting = new StockProvider() {
            public double getMarketPrice(String ticker) { calls[0]++; return 42; }
            public String getStatus(String ticker) { return "OPEN"; }
        };
        CachedStockProxy cached = new CachedStockProxy(counting, 10000);
        capture(() -> { close(cached.getMarketPrice("aapl"),42); close(cached.getMarketPrice("AAPL"),42); });
        check(calls[0] == 1, "Hot cache must prevent upstream calls");
        CachedStockProxy expired = new CachedStockProxy(counting, 0);
        capture(() -> { expired.getMarketPrice("AAPL"); expired.getMarketPrice("AAPL"); });
        check(calls[0] == 3, "Zero TTL must refetch");

        DispatchStrategy business = new BusinessHoursStrategy();
        check(!business.shouldDispatch(1,8) && business.shouldDispatch(1,9), "Opening boundary");
        check(business.shouldDispatch(1,17) && !business.shouldDispatch(1,18), "Closing boundary");
        check(business.shouldDispatch(5,2), "Emergency bypass");
        check(new ImmediateStrategy().shouldDispatch(1,2), "Immediate policy");
        final int[] deliveries = {0};
        MessageChannel channel = (recipient, data) -> deliveries[0]++;
        capture(() -> new DailySummaryAlert(channel,business).processAlert("x","digest",23));
        check(deliveries[0] == 0, "Suppression must not call channel");
        new CriticalSystemAlert(channel,business).processAlert("x","outage",2);
        check(deliveries[0] == 1, "Emergency delivery");

        PricingService base = new CurrencyOrderAdapter(new LegacyForeignOrder("O",100),new LegacyCurrencyConverter(),"USD");
        close(base.calculateTotal(),125);
        PricingService checkout = new CustomsDutyDecorator(new ExpressCourierDecorator(new GiftWrapDecorator(base)));
        close(checkout.calculateTotal(),157.33);
        close(new GiftWrapDecorator(new CustomsDutyDecorator(base)).calculateTotal(),140.63);
        check(checkout.getReceiptBreakdown().contains("Customs Duty: 8.5%"), "Receipt composition");

        final int[] reads = {0};
        StorageDriver storage = new StorageDriver() {
            public byte[] loadRawBlob(String path) { reads[0]++; return new byte[]{1,2}; }
            public String getStorageType() { return "TEST"; }
        };
        for (String role : new String[]{"GUEST","UNKNOWN","",null}) {
            capture(() -> check(new StorageDriverProxy(storage,new UserSession("u",role)).loadRawBlob("x").length == 0,"Unauthorized role blocked"));
        }
        check(reads[0] == 0, "Blocked users must never reach storage");
        for (String role : new String[]{"ADMIN","MEMBER","ENGINEER"}) {
            capture(() -> check(new StorageDriverProxy(storage,new UserSession("u",role)).loadRawBlob("x").length == 2,"Authorized delegation"));
        }
        check(reads[0] == 3, "Allowed calls reach backend");
        String output = capture(() -> new AudioAsset(storage,"audio").render());
        check(output.contains("synchronized 2 bytes via TEST"), "Audio bridge");
        output = capture(() -> new VideoAsset(storage,"video").render());
        check(output.contains("buffered 2 bytes via TEST"), "Video bridge");
        System.out.println("PASS: " + checks + " behavioral checks");
    }
}
