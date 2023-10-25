package domain.dto;

import domain.customer.Customer;
import domain.order.ItemGroup;

import java.util.Set;

public class CreateOrderDto {

    private String customerId;

    private ItemGroup itemGroup;

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public String getCustomerId() {
        return customerId;
    }

    public CreateOrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public CreateOrderDto setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }


}
