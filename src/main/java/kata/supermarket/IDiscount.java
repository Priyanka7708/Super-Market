package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public interface IDiscount
{
    BigDecimal calculate( List<Item> items );
}
