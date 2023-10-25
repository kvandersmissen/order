package domain.order;

import domain.customer.Customer;

import java.util.UUID;

public class Order {

    private String id;
    private Customer customer;
    //private Map<String, ItemGroup> orderById;

    private ItemGroup itemGroup;

    public Order(Customer customer, ItemGroup itemGroup) {
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

    public ItemGroup getItemGroup() {
        return itemGroup;
    }
}
