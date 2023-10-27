/**
 *
 * @author ADMIN
 */
public class Customer {
    private String name;
    private String product;
    private int quantity;
    private int price;
    private int amount;

    public Customer() {
    }

    public Customer(String product, int quantity, int price, int amount) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
