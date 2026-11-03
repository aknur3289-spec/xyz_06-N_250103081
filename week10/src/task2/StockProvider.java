package task2;

import java.util.HashMap;
import java.util.Map;

public interface StockProvider {
    double getMarketPrice(String ticker);
    String getStatus(String ticker);
}
