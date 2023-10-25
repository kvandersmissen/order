package service;

import domain.customer.Customer;
import domain.dto.CreateOrderDto;
import domain.dto.OrderDto;
import domain.item.Item;
import domain.order.ItemGroup;
import domain.order.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import mapper.OrderMapper;
import repository.CustomerRepository;
import repository.ItemRepository;
import repository.OrderRepository;

@ApplicationScoped
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ItemRepository itemRepository;
    private OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, repository.ItemRepository itemRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDto createOrder(CreateOrderDto createOrderDto){
        Customer customer = customerRepository.getCustomerById(createOrderDto.getCustomerId()).orElseThrow(() -> new NotFoundException("No customer could be found for this id."));

//        ItemGroup itemGroup = createOrderDto.getItemGroup();
//        Item item = itemRepository.getItemById(itemGroup.getId()).orElseThrow(() -> new NotFoundException("No item could be found for this id."));

        ItemGroup itemGroup = new ItemGroup("111",1);

        Order order = new Order(customer, itemGroup);
        return orderMapper.entityToDto(orderRepository.createOrder(order));

    }

}
