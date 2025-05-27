import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private BreadType breadType;
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(SandwichSize size, BreadType breadType, List<Topping> toppings, boolean isToasted) {
        if (size == null || breadType == null) {
            throw new IllegalArgumentException("Cant have a real sandwich without bread! Start by picking a size and a bread type.");
        }
        this.size = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.isToasted = isToasted;
    }
    public void addTopping(ToppingType toppingType) {
        toppings.add(new Topping(toppingType));
    }
    public void addExtraTopping(ToppingType toppingType) {
        for (Topping topping : toppings) {
            if(topping.getType() == toppingType) {
                topping.addExtra();
                return;
            }
        }
    }

    public SandwichSize getSize() {
        return size;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public List<Topping> getToppings() {
        return new ArrayList<>(toppings);
    }

    public boolean isToasted() {
        return isToasted;
    }
}
