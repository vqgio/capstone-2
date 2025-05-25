public class Topping {
    private String name;
    private ToppingType type;
    private int extraCount;


    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
        this.extraCount = 0;
    }
    public void addExtra() {
        if (type == ToppingType.PREMIUM) {
            extraCount++;
        }
    }
    public double getMeatBaseCost(SandwichSize size) {
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
    @Override
    public String toString() {
        return name; // NOT FINISHED DON'T FORGET TO WORK ON IT
    }

    public double calculateCost(SandwichSize size) {
        double baseCost = (type == ToppingType.PREMIUM) ? getMeatBaseCost(size) : 0.0;
        double extraCost = (type == ToppingType.PREMIUM) ? getExtraMeatCost(size) * extraCount : 0.0;
        return baseCost + extraCost;
    }
}
