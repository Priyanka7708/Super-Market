package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyOneGetOneFree implements IDiscount
{
    @Override
    public BigDecimal calculate( List<Item> items )
    {
        List<BigDecimal> priceList = new ArrayList<>();
        for ( Item item : items )
        {
            if ( isEligible( item ) )
                priceList.add( item.price() );
        }
        Collections.sort( priceList );

        int size = priceList.size();
        BigDecimal total_discount = BigDecimal.ZERO;
        for ( int i = 0; i < size / 2; i++ )
        {
            total_discount = total_discount.add( priceList.get( i ) );
        }

        return total_discount;
    }

    private boolean isEligible( Item item )
    {
        return item.discountCode().equals("BuyOneGetOneFree");
    }
}
