import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {
    @Test
    void testSandwichInitialization() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping(ToppingType.BACON));
        toppings.add(new Topping(ToppingType.CHEDDAR_CHEESE));

        Sandwich sandwich = new Sandwich(SandwichSize.MEDIUM, BreadType.WHEAT, toppings, true);

        assertEquals(SandwichSize.MEDIUM, sandwich.getSize());
        assertEquals(BreadType.WHEAT, sandwich.getBreadType());
        assertTrue(sandwich.isToasted());
        assertEquals(2, sandwich.getToppings().size()); // Ensure toppings are correctly added
    }

    @Test
    void testAddingToppings() {
        Sandwich sandwich = new Sandwich(SandwichSize.LARGE, BreadType.RYE, new ArrayList<>(),false);
        sandwich.addTopping(ToppingType.BACON);
        sandwich.addExtraTopping(ToppingType.BACON);

        assertEquals(1, sandwich.getToppings().size());
        assertEquals(1, sandwich.getToppings().get(0).getExtraCount());
    }

    @Test
    void testCalculatePrice() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping(ToppingType.CHEDDAR_CHEESE));
        toppings.add(new Topping(ToppingType.STEAK));

        Sandwich sandwich = new Sandwich(SandwichSize.SMALL, BreadType.WHITE, toppings, false);
        sandwich.addExtraTopping(ToppingType.CHEDDAR_CHEESE);

        double expectedPrice = SandwichSize.SMALL.getBasePrice() + 0.75 + 0.30 + 1.00;
        assertEquals(expectedPrice, sandwich.calculateCost(), 0.01);
    }

}