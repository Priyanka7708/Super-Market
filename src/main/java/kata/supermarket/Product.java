package kata.supermarket;

import java.math.BigDecimal;

public class Product {

    private final BigDecimal pricePerUnit;
    private final String discountCode;

    public Product(final BigDecimal pricePerUnit, final String discountCode)
    {
        this.pricePerUnit = pricePerUnit;
        this.discountCode = discountCode;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    public String discountCode() {
        return discountCode;
    }
}
