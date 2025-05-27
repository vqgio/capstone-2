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
        this.toppings = (toppings != null) ? new ArrayList<>(toppings) : new ArrayList<>();
        this.isToasted = isToasted;
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
        Topping newTopping = new Topping(toppingType);
        newTopping.addExtra();
        toppings.add(newTopping);
    }
    public double calculateCost() {
        double basePrice = size.getBasePrice();
        double toppingCost = toppings.stream().mapToDouble(t -> t.calculateCost(size)).sum();
        return basePrice + toppingCost;
    }
    public void displayOrderDetails() {
        System.out.println("Sandwich Size: " + size);
        System.out.println("Bread Type: " + breadType);
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));
        System.out.println("Toppings; ");

        for (Topping topping : toppings) {
            System.out.println("  " + topping);
        }
        System.out.println("Total: $" + calculateCost());
    }

}
