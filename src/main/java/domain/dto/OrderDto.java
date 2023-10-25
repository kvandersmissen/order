package domain.dto;

import domain.customer.Customer;
import domain.order.ItemGroup;

public class OrderDto {

    private String id;
    private Customer customer;

    private ItemGroup itemGroup;

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public OrderDto setId(String id) {
        this.id = id;
        return this;
    }

    public OrderDto setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderDto setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }
}
