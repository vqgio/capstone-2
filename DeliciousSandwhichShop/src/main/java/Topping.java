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
