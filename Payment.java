import java.util.Scanner;

public class Payment {
    private Fooditem[] fi = new Fooditem[100];
    private int fiCount = 0;
    private static double foodTax = 0.2;

    private Drinkitem[] di = new Drinkitem[100];
    private int diCount = 0;
    private static double drinkTax = 0.1;

    public void addFooditem(Fooditem food) {
        if (fiCount < fi.length) {
            fi[fiCount++] = food;
        } else {
            System.out.println("Maximum limit of food items reached.");
        }
    }

    public void addDrinkitem(Drinkitem drink) {
        if (diCount < di.length) {
            di[diCount++] = drink;
        } else {
            System.out.println("Maximum limit of drink items reached.");
        }
    }

    public Payment() {
        fiCount = 0;
        diCount = 0;
    }

    public Drinkitem getDi(int x) {
        return di[x];
    }

    public double calculateBill() {
        double totalFoodPrice = 0.0;
        for (int i = 0; i < fiCount; i++) {
            totalFoodPrice += fi[i].getPrice();
        }

        double totalDrinkPrice = 0.0;
        for (int i = 0; i < diCount; i++) {
            totalDrinkPrice += di[i].getPrice();
        }

        double foodTaxAmount = totalFoodPrice * foodTax;
        double drinkTaxAmount = totalDrinkPrice * drinkTax;

        return totalFoodPrice + totalDrinkPrice + foodTaxAmount + drinkTaxAmount;
    }

    public static void main(String[] args) {
        Payment[] tables = new Payment[3]; // Create an array to hold Payment objects

        // Create a Payment object
        Payment payment = new Payment();
        payment.inputItems();

        tables[1] = new Payment();
        tables[2] = new Payment();

        Fooditem a = new Fooditem("fl02", 2, 15.0);
        Fooditem b = new Fooditem("flOO", 1, 10.0);
        Drinkitem c = new Drinkitem("dl02", 3, 22.0);

        tables[1].addFooditem(a);
        tables[1].addFooditem(b);
        tables[2].addDrinkitem(c);
        tables[2].addDrinkitem(new Drinkitem("dl03", 1, 20));

        System.out.println(tables[1].fiCount);
        System.out.println(Payment.foodTax);
        System.out.println(tables[2].getDi(1).getItemCode());

        double billAmount = payment.calculateBill();
        System.out.println("Total bill amount: " + billAmount);
    }

    public void inputItems() {
        Scanner scanner = new Scanner(System.in);

        // Input for Fooditem
        Fooditem[] foodItems = {
                new Fooditem("FRIEDRICE001", 1, 15.0),
                new Fooditem("FRIEDCHICKEN001", 1, 16.0),
                new Fooditem("STEAK001", 1, 55.0),
                new Fooditem("FRIEDNOODLES001", 1, 10.0)
        };

        for (Fooditem food : foodItems) {
            System.out.print("Enter quantity for " + food.getItemCode() + ": ");
            int quantity = scanner.nextInt();
            food.setQuantity(quantity);
            fi[fiCount++] = food;
        }

        // Input for Drinkitem
        Drinkitem[] drinkItems = {
                new Drinkitem("COFFEE001", 1, 22.0),
                new Drinkitem("ICEDTEA001", 1, 8.0),
                new Drinkitem("ORANGEJUICE001", 1, 28.0),
                new Drinkitem("MINERALWATER001", 1, 6.0)
        };

        for (Drinkitem drink : drinkItems) {
            System.out.print("Enter quantity for " + drink.getItemCode() + ": ");
            int quantity = scanner.nextInt();
            drink.setQuantity(quantity);
            di[diCount++] = drink;
        }

        // Close the scanner
        scanner.close();
    }

}
