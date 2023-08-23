public class Fooditem {
    private String itemCode;
    private int quantity;
    private double price;

    public Fooditem(String x, int y, double price) {
        itemCode = x;
        quantity = y;
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price * quantity;
    }
}
