package domain.item;

import java.util.UUID;

public class Item {

    private String id;
    private String name;
    private String description;
    private double price;
    private int amount;

    public Item(String name, String description, double price, int amount) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item changeName(String name) {
        if (name != null) {
            this.name = name;
        }
        return this;
    }

    public Item changeDescription(String description) {
        if (description != null) {
            this.description = description;
        }
        return this;
    }

    public Item changePrice(Double price) {
        if (price != 0) {
            this.price = price;
        }
        return this;
    }

    public Item changeAmount(int amount) {
        if (amount != 0) {
            this.amount = amount;
        }
        return this;
    }

}
