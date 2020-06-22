package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {

    private final BigDecimal pricePerKilo;
    private final String discountCode;

    public WeighedProduct(final BigDecimal pricePerKilo, final String discountCode) {
        this.pricePerKilo = pricePerKilo;
        this.discountCode = discountCode;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    public String discountCode() {
        return discountCode;
    }
}
