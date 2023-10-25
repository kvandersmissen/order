package domain.order;

import java.time.LocalDate;

public class ItemGroup {

    private String id;

    private int amount;

    private LocalDate shippingDate;

    private double price;

    public ItemGroup(String id, int amount) {
        this.id = id;
        this.amount = amount;
        this.shippingDate = LocalDate.now().plusDays(1);;
        //this.price = price;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
