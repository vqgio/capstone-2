public class Topping {
    private ToppingType type;
    private int extraCount;

    public Topping(ToppingType type) {
        this.type = type;
        this.extraCount = 0;
    }

    public void addExtra() {
        if (type.getQuality() != ToppingQuality.REGULAR) {
            extraCount++;
        }
    }

    public double calculateCost(SandwichSize size) {
        double baseCost = switch (type.getQuality()) {
            case PREMIUM_MEAT -> switch (size) {
                case SMALL -> 1.00;
                case MEDIUM -> 2.00;
                case LARGE -> 3.00;
            };
            case PREMIUM_CHEESE -> switch (size) {
                case SMALL -> 0.75;
                case MEDIUM -> 1.50;
                case LARGE -> 2.25;
            };
            default -> 0.00;
        };
        double extraCost = switch (type.getQuality()) {
            case PREMIUM_MEAT -> switch (size) {
                case SMALL -> 0.50;
                case MEDIUM -> 1.00;
                case LARGE -> 1.50;
            };
            case PREMIUM_CHEESE -> switch (size) {
                case SMALL -> 0.30;
                case MEDIUM -> 0.60;
                case LARGE -> 0.90;
            };
            default -> 0.00;
        } * extraCount;
        return baseCost + extraCost;
    }
    @Override
    public String toString() {
        return type + (extraCount > 0 ? " (" + extraCount + " extra)" : "");
    }

    public ToppingType getType() {
        return type;
    }

    public int getExtraCount() {
        return extraCount;
    }

    public ToppingQuality getQuality() {
        return type.getQuality();
    }
}
