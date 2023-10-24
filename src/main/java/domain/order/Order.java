package domain.order;

import domain.customer.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Order {

    private String id;
    private Customer customer;
    //private Map<String, ItemGroup> orderById;


    public Order(Customer customer) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }
}
