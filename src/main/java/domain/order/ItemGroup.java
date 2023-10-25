package domain.order;

import java.time.LocalDate;

public class ItemGroup {

    private String id;

    private int amount;

    private LocalDate shippingDate;

    private double price;

    public ItemGroup(String id, int amount, LocalDate shippingDate, double price) {
        setId(id);
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.price = price;
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
}
