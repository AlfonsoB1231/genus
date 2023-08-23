public class Drinkitem {
    private String itemCode;
    private int quantity;
    private double price;

    public Drinkitem(String x, int y, double price) {
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
