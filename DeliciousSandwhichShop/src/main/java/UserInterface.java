import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public void display() {
        System.out.println(" Welcome to Gio's DELI-cious Sandwich Shop!");
        Order order = new Order(getCustomerName());

        Sandwich sandwich = createSandwich();
        if (sandwich == null) return;
        order.addSandwich(sandwich);

        Drink drink = createDrink();
        if (drink != null) order.addDrink(drink);

        Chips chips = createChips();
        if (chips != null) order.addChips(chips);

        System.out.println("\n Here is your order:");
        System.out.println(order.generateReceipt());

        order.saveReceipt();
        System.out.println("\n Receipt saved successfully! ");
    }

    private static String getCustomerName() {
        System.out.print("\nEnter your name (or 'X' to quit): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("X")) {
            System.out.println(" Exiting... Have a great day!");
            return null;
        }
        return input;
    }

    private static Sandwich createSandwich() {
        System.out.println("\nLet's customize your sandwich!");

        SandwichSize size = selectSandwichSize();
        if (size == null) return null;

        BreadType bread = selectBreadType();
        if (bread == null) return null;

        boolean toasted = askYesNo("Would you like it toasted?");
        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.println("Add your toppings:");
        while (askYesNo("Do you want to add a topping? (or 'q' to finish)")) {
            ToppingType topping = selectTopping();
            if (topping == null) break;

            Topping newTopping = new Topping(topping);

            if (topping.getQuality() == ToppingQuality.PREMIUM_MEAT) {
                if (askYesNo("Would you like extra " + topping.name().toLowerCase() + "?")) {
                    newTopping.addExtra();
                }
            } else if (topping.getQuality() == ToppingQuality.PREMIUM_CHEESE) {
                if (askYesNo("Would you like extra " + topping.name().toLowerCase() + "?")) {
                    newTopping.addExtra();
                }
            }
            sandwich.addTopping(newTopping.getType());
        }

        return sandwich;

    }
    private static SandwichSize selectSandwichSize() {
        System.out.println("Choose a size (or 'X' to quit):");
        return chooseOption(SandwichSize.values());
    }

    private static BreadType selectBreadType() {
        System.out.println("Choose a bread type (or 'X' to quit):");
        return chooseOption(BreadType.values());
    }

    private static ToppingType selectTopping() {
        System.out.println("Select a topping (or 'X' to quit):");
        return chooseOption(ToppingType.values());
    }

    private static Drink createDrink() {
        if (!askYesNo("Would you like a drink? (or 'X' to skip)")) return null;

        System.out.println("\n Choose a drink size:");
        DrinkSize size = chooseOption(DrinkSize.values());
        if (size == null) return null;

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();
        if (flavor.equalsIgnoreCase("X")) return null;

        return new Drink(size, flavor);
    }

    private static Chips createChips() {
        if (!askYesNo("Would you like chips? (or 'X' to skip)")) return null;

        System.out.print("\n Enter chips flavor: ");
        String flavor = scanner.nextLine();
        if (flavor.equalsIgnoreCase("X")) return null;

        return new Chips(flavor);
    }

    private static <T> T chooseOption(T[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter choice (1-" + options.length + ") or 'X' to quit: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("X")) return null;

        try {
            int choice = Integer.parseInt(input);
            return options[choice - 1];
        } catch (Exception e) {
            System.out.println("Sorry please choose from the options above.");
            return chooseOption(options);
        }
    }

    private static boolean askYesNo(String question) {
        while (true) {
            System.out.print(question + " (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input! Please type yes or no.");
            }
        }

    }

}

