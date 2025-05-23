public enum SandwichSize {
    SMALL(4, 5.50), MEDIUM(8, 7.70), LARGE(12, 8.50);

    //build a constructor so we can put values in sizes
    private final int inches;
    private final double basePrice;

    SandwichSize(int inches, double basePrice) {
        this.inches = inches;
        this.basePrice = basePrice;
    }
    public double getBasePrice() {
        return basePrice;
    }
}
