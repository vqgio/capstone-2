public class Chips {
    private final double price = 1.50;
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return flavor + " Chips ($" + String.format("%.2f", price) + ")";
    }
}
