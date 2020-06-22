package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class BuyTwoItemsFor1Pound implements IDiscount
{
    @Override
    public BigDecimal calculate( List<Item> items )
    {
        BigDecimal total_discount = BigDecimal.ZERO;
        BigDecimal sub_price = BigDecimal.ZERO;
        int itemCount = 0;

        for ( Item item : items )
        {
            if ( isEligible( item ) )
            {
                itemCount++;
                sub_price = sub_price.add(item.price());
                // if itemCount is even we are on 2nd item - apply discount
                if (itemCount % 2 == 0)
                {
                    total_discount = total_discount.add( sub_price.subtract(BigDecimal.ONE) );
                    sub_price = BigDecimal.ZERO;
                }
            }

        }

        return total_discount;
    }
    private boolean isEligible( Item item )
    {
        return item.discountCode().equals("BuyTwoItemsFor1Pound");
    }
}
