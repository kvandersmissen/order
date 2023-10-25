package mapper;

import domain.dto.CreateItemDto;
import domain.dto.ItemDto;
import domain.dto.OrderDto;
import domain.item.Item;
import domain.order.Order;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderMapper {

    public OrderDto entityToDto(Order order) {
        return new OrderDto()
                .setId(order.getId())
                .setCustomer(order.getCustomer())
                .setItemGroup(order.getItemGroup());
    }

}
