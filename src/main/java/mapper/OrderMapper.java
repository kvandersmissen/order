package mapper;

import domain.dto.OrderDto;
import domain.order.ItemGroup;
import domain.order.Order;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class OrderMapper {
    private final Logger logger = Logger.getLogger(OrderMapper.class);

    public OrderDto entityToDto(Order order) {

        return new OrderDto(
                order.getId(),
                order.getCustomer(),
                order.getItemGroup(),
                order.getItemGroup().parallelStream().mapToDouble(ItemGroup::getPrice).sum());

    }

}
