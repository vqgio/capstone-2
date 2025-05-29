import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private BreadType breadType;
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(SandwichSize size, BreadType breadType, boolean isToasted) {
        if (size == null || breadType == null) {
            throw new IllegalArgumentException("Cant have a real sandwich without bread! Start by picking a size and a bread type.");
        }
        this.size = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>(); //updated to make test pass
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
        double toppingCost = 0.0;

        for (Topping topping : toppings) {
            double extraCost = 0.0;

            if (topping.getQuality() == ToppingQuality.PREMIUM_MEAT) {
                extraCost += switch (size) {
                    case SMALL -> 1.00;
                    case MEDIUM -> 2.00;
                    case LARGE -> 3.00;
                };
                extraCost += topping.getExtraCount() * switch (size) {
                    case SMALL -> 0.50;
                    case MEDIUM -> 1.00;
                    case LARGE -> 1.50;
                };
            } else if (topping.getQuality() == ToppingQuality.PREMIUM_CHEESE) {
                extraCost += switch (size) {
                    case SMALL -> 0.75;
                    case MEDIUM -> 1.50;
                    case LARGE -> 2.25;
                };
                extraCost += topping.getExtraCount() * switch (size) {
                    case SMALL -> 0.30;
                    case MEDIUM -> 0.60;
                    case LARGE -> 0.90;
                };
            }

            toppingCost += extraCost;
        }

        return basePrice + toppingCost;
    }
    //for display sandwich details in receipt
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===== Sandwich Details =====\n");
        sb.append("Size: ").append(size).append("\n");
        sb.append("Bread Type: ").append(breadType).append("\n");
        sb.append("Toasted: ").append(isToasted ? "Yes" : "No").append("\n");
        sb.append("Toppings:\n");

        if (toppings.isEmpty()) {
            sb.append("  - No toppings added\n");
        } else {
            toppings.forEach(t -> sb.append("  - ").append(t).append("\n"));
        }

        sb.append("Total Price: $").append(String.format("%.2f", calculateCost())).append("\n");
        sb.append("============================\n");

        return sb.toString();
    }
}
