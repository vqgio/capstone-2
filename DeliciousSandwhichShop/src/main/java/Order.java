import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;


    public Order(String customerName) {
        this.customerName = customerName;
        this.sandwiches = new ArrayList<>();
        this.chips =  new ArrayList<>();
        this.drinks =  new ArrayList<>();
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
        receipt.append("====RECEIPT====\n");
        receipt.append("Gio's DELI-cious Sandwiches\n");
        receipt.append("\n").append("Customer Name: " + customerName + "\n");
        sandwiches.forEach(s -> receipt.append(" ").append(s).append("\n"));
        receipt.append("Drinks: \n");
        drinks.forEach(d -> receipt.append("- ").append(d).append("\n"));
        receipt.append("Chips: \n");
        chips.forEach(c -> receipt.append("- ").append(c).append("\n"));
        receipt.append("\nTotal Price: $").append(String.format("%.2f", calculatePrice())).append("\n");
        receipt.append("\n================");
        return receipt.toString();
    }
    public void saveReceipt() {
        String filePath = "C:\\Users\\rsant\\pluralsight\\capstone-2\\DeliciousSandwhichShop\\src\\main\\resources\\receipts";
        String fileName = generateReceiptFileName();
        File receiptsFolder = new File(filePath);
        if(!receiptsFolder.exists()) {
            receiptsFolder.mkdir();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(receiptsFolder, fileName)))) {
            writer.write(generateReceipt());
            writer.flush();
            System.out.println("Receipt saved Successfully" + fileName);
        } catch (IOException e) {
            System.err.println("Failed to save receipt" + e.getMessage());
        }
    }
    public static List<Order> loadOrders() {
        List<Order> orders = new ArrayList<>();
        return orders;
    }
    public static String generateReceiptFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        return now.format(formatter) + ".txt";
    }

}
