import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNumber;
    private String customerName;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    private static final String FILE_PATH = "receipts.csv";

    public Order(String orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.sandwiches = new ArrayList<>();
        this.chips =  new ArrayList<>();
        this.drinks =  new ArrayList<>();
    }
    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Sandwich> getSandwiches() {
        return new ArrayList<>(sandwiches);
    }

    public List<Drink> getDrinks() {
        return new ArrayList<>(drinks);
    }

    public List<Chips> getChips() {
        return new ArrayList<>(chips);
    }
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }
    public void addChips(Chips chip) {
        chips.add(chip);
    }
    public double calculatePrice() {
        double total = 0;
        total += sandwiches.stream().mapToDouble(Sandwich::calculateCost).sum();
        total += drinks.stream().mapToDouble(Drink::getPrice).sum();
        total += chips.stream().mapToDouble(Chips::getPrice).sum();
        return total;
    }
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Order Number: " + orderNumber + "\n").append("Customer Name: " + customerName + "\n");
        receipt.append("Sandwiches: \n");
        sandwiches.forEach(s -> receipt.append("- ").append(s).append("\n"));
        receipt.append("Drinks: \n");
        drinks.forEach(d -> receipt.append("- ").append(d).append("\n"));
        receipt.append("Chips: \n");
        chips.forEach(c -> receipt.append("- ").append(c).append("\n"));
        receipt.append("\nTotal Price: $").append(calculatePrice());
        return receipt.toString();
    }
    public static void saveOrder(Order order) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))) {
            writer.write(order.getOrderNumber() + "," + order.getCustomerName() + "," + order.calculatePrice());
            writer.newLine();
            writer.flush();
            System.out.println("Order Saved Successfully!");
        } catch (IOException e) {
            System.err.println("ERROR, Saving order failed! Please try again.");
        }
    }

}
