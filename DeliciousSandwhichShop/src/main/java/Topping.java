import java.util.ArrayList;
import java.util.List;

public class Topping {
    private String toppingName;
    private boolean isPremium;
    private int extraCount;

    public Topping(String toppingName, boolean isPremium) {
        this.toppingName = toppingName;
        this.isPremium = isPremium;
        this.extraCount = 0;
    }
}
