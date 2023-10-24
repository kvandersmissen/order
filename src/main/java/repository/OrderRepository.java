package repository;

import domain.customer.Customer;
import domain.item.Item;
import domain.order.Order;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class OrderRepository {

    private final Map<String, Order> orderById;

    public OrderRepository() {
        this.orderById = new HashMap<>();
    }

    public Order createOrder(Order order){

        orderById.put(order.getId(),order);
        return order;
    }
}
