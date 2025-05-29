import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {
    @Test
    void testSandwichInitialization() {
        Topping bacon = new Topping(ToppingType.BACON);
        Topping cheddarCheese = new Topping(ToppingType.CHEDDAR_CHEESE);

        Sandwich sandwich = new Sandwich(SandwichSize.MEDIUM, BreadType.WHEAT, true);

        sandwich.addTopping(ToppingType.BACON);
        sandwich.addTopping(ToppingType.CHEDDAR_CHEESE);

        assertEquals(SandwichSize.MEDIUM, sandwich.getSize());
        assertEquals(BreadType.WHEAT, sandwich.getBreadType());
        assertTrue(sandwich.isToasted());
        assertEquals(2, sandwich.getToppings().size());
    }

    @Test
    void testAddingToppings() {
        Sandwich sandwich = new Sandwich(SandwichSize.LARGE, BreadType.RYE,false);
        sandwich.addTopping(ToppingType.BACON);
        sandwich.addExtraTopping(ToppingType.BACON);

        assertEquals(1, sandwich.getToppings().size());
        assertEquals(1, sandwich.getToppings().get(0).getExtraCount());
    }

    @Test
    void testCalculatePrice() {
        Sandwich sandwich = new Sandwich(SandwichSize.LARGE, BreadType.WHEAT, true);
        sandwich.addTopping(ToppingType.STEAK); // Premium Meat
        sandwich.addTopping(ToppingType.PROVOLONE_CHEESE); // Premium Cheese

        // Add extra portions
        sandwich.getToppings().get(0).addExtra(); // Extra steak
        sandwich.getToppings().get(1).addExtra(); // Extra provolone cheese

        // Print the sandwich details
        System.out.println(sandwich);

        // Validate calculated price
        double expectedTotal = 8.50 // Base price for LARGE
                + 3.00 // Steak cost for LARGE
                + 2.25 // Provolone cheese cost for LARGE
                + 1.50 // Extra steak for LARGE
                + 0.90; // Extra provolone cheese for LARGE
    }


}