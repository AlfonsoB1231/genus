public class Item {
    private String code;
    private String name;
    private double price;

    // Constructor
    public Item(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // Find the price of an item by code
    public static double findPrice(Item[] itemList, String code) {
        for (Item item : itemList) {
            if (item.getCode().equals(code)) {
                return item.getPrice();
            }
        }
        return 0.0; // Return 0 if item is not found
    }

    // Accessor methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
