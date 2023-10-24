package domain.dto;

import domain.customer.Customer;

public class OrderDto {

    private String id;
    private Customer customer;

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderDto setId(String id) {
        this.id = id;
        return this;
    }

    public OrderDto setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
