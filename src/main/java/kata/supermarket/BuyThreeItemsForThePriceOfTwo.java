package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyThreeItemsForThePriceOfTwo implements IDiscount
{
    @Override
    public BigDecimal calculate( List<Item> items )
    {
        List<BigDecimal> priceList = new ArrayList<>();
        BigDecimal total_discount = BigDecimal.ZERO;
        for ( Item item : items )
        {
            if ( isEligible( item ) )
                priceList.add( item.price() );
        }
        Collections.sort( priceList );

        int itemsSets = priceList.size() / 3;

        for ( int i = 0; i < itemsSets; i++ )
        {
            total_discount = total_discount.add( priceList.get( i ) );
        }

        return total_discount;
    }

    private boolean isEligible( Item item )
    {
        return item.discountCode().equals( "BuyThreeItemsForThePriceOfTwo" );
    }
}
