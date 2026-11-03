package task4;


public class CustomsDutyDecorator extends PricingDecorator {
    public CustomsDutyDecorator(PricingService wrapped) { super(wrapped); }
    @Override
    public double calculateTotal() {
        double subtotal = super.calculateTotal();
        // Decimal HALF_UP avoids binary floating-point rounding 157.325 down.
        return java.math.BigDecimal.valueOf(subtotal)
            .multiply(new java.math.BigDecimal("1.085"))
            .setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
    }
    @Override
    public String getReceiptBreakdown() {
        return super.getReceiptBreakdown() + " + [Customs Duty: 8.5%]";
    }
}
