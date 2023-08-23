public class Payment {

    public double findPrice(String itemCode) {
        for (int i = 0; i < fiCount; i++) {
            if (fi[i].getItemCode().equals(itemCode)) {
                return fi[i].getPrice();
            }
        }

        for (int i = 0; i < diCount; i++) {
            if (di[i].getItemCode().equals(itemCode)) {
                return di[i].getPrice();
            }
        }

        return 0.0;
    }

    public double calculateBill(Item[] items) {
        double totalFoodPrice = 0.0;
        double totalDrinkPrice = 0.0;

        for (Item item : items) {
            if (item instanceof Fooditem) {
                totalFoodPrice += findPrice(item.getItemCode()) * item.getQuantity();
            } else if (item instanceof Drinkitem) {
                totalDrinkPrice += findPrice(item.getItemCode()) * item.getQuantity();
            }
        }

        double foodTaxAmount = totalFoodPrice * foodTax;
        double drinkTaxAmount = totalDrinkPrice * drinkTax;

        return totalFoodPrice + totalDrinkPrice + foodTaxAmount + drinkTaxAmount;
    }

}

// for D

public class Payment {

    public double calculateBill(Item[] items) {
        double totalFoodPrice = calculateTotalFoodPrice(items);
        double totalDrinkPrice = calculateTotalDrinkPrice(items);

        double foodTaxAmount = totalFoodPrice * foodTax;
        double drinkTaxAmount = totalDrinkPrice * drinkTax;

        return totalFoodPrice + totalDrinkPrice + foodTaxAmount + drinkTaxAmount;
    }

    private double calculateTotalFoodPrice(Item[] items) {
        double totalFoodPrice = 0.0;
        for (Item item : items) {
            if (item instanceof Fooditem) {
                totalFoodPrice += findPrice(item.getItemCode()) * item.getQuantity();
            }
        }
        return totalFoodPrice;
    }

    private double calculateTotalDrinkPrice(Item[] items) {
        double totalDrinkPrice = 0.0;
        for (Item item : items) {
            if (item instanceof Drinkitem) {
                totalDrinkPrice += findPrice(item.getItemCode()) * item.getQuantity();
            }
        }
        return totalDrinkPrice;
    }

}
