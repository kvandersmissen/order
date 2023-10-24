package service;

import domain.customer.Customer;
import domain.dto.CreateOrderDto;
import domain.dto.OrderDto;
import domain.order.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import mapper.OrderMapper;
import repository.CustomerRepository;
import repository.OrderRepository;

@ApplicationScoped
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDto createOrder(CreateOrderDto createOrderDto){
        Customer customer = customerRepository.getCustomerById(createOrderDto.getCustomerId()).orElseThrow(() -> new NotFoundException("No customer could be found for this id."));
        Order order = new Order(customer);
        return orderMapper.entityToDto(orderRepository.createOrder(order));

    }

}
