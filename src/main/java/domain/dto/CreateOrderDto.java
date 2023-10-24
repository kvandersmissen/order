package domain.dto;

import domain.customer.Customer;

public class CreateOrderDto {

    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public CreateOrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }


}
