public class Topping {
   private ToppingType name;
   private int extraCount;

    public Topping(ToppingType name) {
        this.name = name;
        this.extraCount = 0;
    }
    public void addExtra() {
        if(name.getQuality() != ToppingQuality.REGULAR) {
            extraCount++;
        }
    }
    public double calculateCost(SandwichSize size) {
        double baseCost = switch (name.getQuality()) {
            case PREMIUM_MEAT -> getMeatBaseCost(size) * extraCount;
            case PREMIUM_CHEESE -> getCheeseBaseCost(size) + extraCount;
            default -> 0.0;
        };
        double extraCost = switch (name.getQuality()) {
            case PREMIUM_MEAT -> getExtraMeatCost(size) * extraCount;
            case PREMIUM_CHEESE -> getExtraCheeseCost(size) * extraCount;
            default -> 0.0;
        };
        return baseCost + extraCost;
    }
    private double getMeatBaseCost(SandwichSize size) {
        return switch (size) {
            case SMALL -> 1.00;
            case MEDIUM -> 2.00;
            case LARGE -> 3.00;
        };
    }
    private double getExtraMeatCost(SandwichSize size) {
        return switch (size) {
            case SMALL -> 0.50;
            case MEDIUM -> 1.00;
            case LARGE -> 1.50;
        };
    }
    private double getCheeseBaseCost(SandwichSize size) {
        return switch (size) {
            case SMALL -> 0.75;
            case MEDIUM -> 1.50;
            case LARGE -> 2.25;
        };
    }
    private double getExtraCheeseCost(SandwichSize size) {
        return switch (size) {
            case SMALL -> 0.30;
            case MEDIUM -> 0.60;
            case LARGE -> 0.90;
        };
    }
    @Override
    public String toString() {
        return name + (extraCount > 0 ? " (" + extraCount + " extra)" : "");
    }
}
