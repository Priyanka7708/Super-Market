package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Buy1KiloProductsForHalfPrice implements IDiscount
{
    @Override
    public BigDecimal calculate( List<Item> items )
    {
        BigDecimal totalSaving = BigDecimal.ZERO;
        for ( Item item : items )
        {
            if ( isEligible( item ) )
            {
                BigDecimal wholeKg = ((ItemByWeight)item).weightInKilos().setScale(0, RoundingMode.DOWN);
                BigDecimal pricePerKg =  ((ItemByWeight)item).pricePerKilo();
                totalSaving = totalSaving.add( pricePerKg.multiply(wholeKg).divide( BigDecimal.valueOf( 2 ) ) );
            }
        }

        return totalSaving;
    }

    private boolean isEligible( Item item )
    {
        return item.discountCode().equals( "Buy1KiloProductsForHalfPrice") ;
    }
}
