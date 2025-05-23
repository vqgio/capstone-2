import java.util.List;

public class Sandwich {
    private String size;
    private String breadType;
    private List<Topping> premiumToppings;
    private List<Topping> regularToppings;
    private boolean isToasted;

    public Sandwich(String size, String breadType, List<Topping> premiumToppings, List<Topping> regularToppings, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.premiumToppings = premiumToppings;
        this.regularToppings = regularToppings;
        this.isToasted = isToasted;
    }
}
