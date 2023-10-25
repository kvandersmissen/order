package domain.dto;

import domain.customer.Customer;
import domain.order.ItemGroup;

import java.util.List;

public class OrderDto {

    private String id;
    private Customer customer;

    private List<ItemGroup> itemGroup;

    public String getId() {
        return id;
    }

    private double totalPrice;

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }

    public OrderDto(String id, Customer customer, List<ItemGroup> itemGroup, double totalPrice) {
        this.id = id;
        this.customer = customer;
        this.itemGroup = itemGroup;
        this.totalPrice = totalPrice;
    }

}
