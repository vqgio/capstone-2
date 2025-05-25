import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private BreadType breadType;
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(SandwichSize size, BreadType breadType, boolean isToasted, List<Topping> toppings) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public double calculatePrice() {
        double BasePrice = size.getBasePrice();
        double toppingCost = toppings.stream().mapToDouble(t -> t.calculateCost(size)).sum();
        return BasePrice + toppingCost;
    }

}
