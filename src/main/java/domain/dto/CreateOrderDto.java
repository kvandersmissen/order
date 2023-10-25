package domain.dto;

import domain.customer.Customer;
import domain.item.Item;
import domain.order.ItemGroup;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateOrderDto {

    private String customerId;

    private List<CreateItemGroupDto> createItemGroupDto;

    public List<CreateItemGroupDto> getCreateItemGroupDto() {
        return createItemGroupDto;
    }


    public String getCustomerId() {
        return customerId;
    }

}
