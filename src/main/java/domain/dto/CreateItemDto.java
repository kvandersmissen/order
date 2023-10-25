package domain.dto;

public class CreateItemDto {

    private String name;
    private String description;
    private double price;
    private int amount;

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

}
