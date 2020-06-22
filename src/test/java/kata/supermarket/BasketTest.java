package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                twoSingleItemPricedPerUnit(),
                threeSingleItemPricedPerUnit(),
                threeKiloOfAmericanSweets(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                twoSingleItemsForOnePound(),
                twoItemsofIndianSweets(),
                twoMoreItemsofIndianSweets(),
                twoLargeBagsOfIndianSweets()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments twoSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Arrays.asList(aPintOfMilk() , aPintOfMilk()));
    }

    private static Arguments threeSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "3.10", Arrays.asList(aPackOfDigestives() , aPackOfDigestives(), aPackOfDigestives()));
    }

    private static Arguments threeKiloOfAmericanSweets() {
        return Arguments.of("three Kilo Of American Sweets", "3.75", Arrays.asList(twoFiftyGramsOfAmericanSweets() , twoFiftyGramsOfAmericanSweets(), twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments twoSingleItemsForOnePound() {
        return Arguments.of("multiple items priced per unit", "1.00",
                Arrays.asList(fridgeMagnet(), coaster()));
    }

    private static Arguments twoItemsofIndianSweets() {
        return Arguments.of("Special Indian Sweets", "6.00",
                Arrays.asList(fiveHundredGramsOfIndianSweets(), fiveHundredGramsOfIndianSweets()));
    }

    private static Arguments twoMoreItemsofIndianSweets() {
        return Arguments.of("Special Indian sweets", "4.50",
                Arrays.asList(fiveHundredGramsOfIndianSweets(), twoHundredFiftyGramsOfIndianSweets()));
    }

    private static Arguments twoLargeBagsOfIndianSweets() {
        return Arguments.of("More Indian Sweets", "4.50",
                Arrays.asList(aTwoFiveHundredGramsOfIndianSweets(), twoHundredFiftyGramsOfIndianSweets()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49"), "BuyOneGetOneFree").oneOf();
    }
    private static Item fridgeMagnet() {
        return new Product(new BigDecimal("0.75"), "BuyTwoItemsFor1Pound").oneOf();
    }

    private static Item coaster() {
        return new Product(new BigDecimal("0.75"), "BuyTwoItemsFor1Pound").oneOf();
    }

    private static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55"), "BuyThreeItemsForThePriceOfTwo").oneOf();
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"), "");
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfIndianSweets() {
        return new WeighedProduct(new BigDecimal("6"), "Buy1KiloProductsForHalfPrice");
    }

    private static Item fiveHundredGramsOfIndianSweets() {
        return aKiloOfIndianSweets().weighing(new BigDecimal("0.5"));
    }

    private static Item twoHundredFiftyGramsOfIndianSweets() {
        return aKiloOfIndianSweets().weighing(new BigDecimal("0.25"));
    }

    private static Item aTwoFiveHundredGramsOfIndianSweets() {
        return aKiloOfIndianSweets().weighing(new BigDecimal("1"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"), "");
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}