package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class BuyTwoItemsFor1Pound implements IDiscount
{
    @Override
    public BigDecimal calculate( List<Item> items )
    {
        BigDecimal totalDiscount = BigDecimal.ZERO;
        BigDecimal subPrice = BigDecimal.ZERO;
        int itemCount = 0;

        for ( Item item : items )
        {
            if ( isEligible( item ) )
            {
                itemCount++;
                subPrice = subPrice.add(item.price());
                // if itemCount is even we are on 2nd item - apply discount
                if (itemCount % 2 == 0)
                {
                    totalDiscount = totalDiscount.add( subPrice.subtract(BigDecimal.ONE) );
                    subPrice = BigDecimal.ZERO;
                }
            }

        }

        return totalDiscount;
    }
    private boolean isEligible( Item item )
    {
        return item.discountCode().equals("BuyTwoItemsFor1Pound");
    }
}
