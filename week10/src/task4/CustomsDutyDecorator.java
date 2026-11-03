package task4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CustomsDutyDecorator extends PricingDecorator {
    public CustomsDutyDecorator(PricingService wrapped) { super(wrapped); }
    @Override
    public double calculateTotal() {
        double subtotal = super.calculateTotal();
        // Round to cents after adding the 8.5% duty.
        return BigDecimal.valueOf(subtotal)
            .multiply(new BigDecimal("1.085"))
            .setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    @Override
    public String getReceiptBreakdown() {
        return super.getReceiptBreakdown() + " + [Customs Duty: 8.5%]";
    }
}
