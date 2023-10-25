package domain.order;

import domain.customer.Customer;

import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private Customer customer;

    private List<ItemGroup> itemGroup;

    public Order(Customer customer, List<ItemGroup> itemGroup) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.itemGroup = itemGroup;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }
}
