package service;

import domain.customer.Customer;
import domain.dto.CreateItemGroupDto;
import domain.dto.CreateOrderDto;
import domain.dto.OrderDto;
import domain.item.Item;
import domain.order.ItemGroup;
import domain.order.Order;
import exceptions.NotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import mapper.ItemGroupMapper;
import mapper.OrderMapper;
import org.jboss.logging.Logger;
import repository.CustomerRepository;
import repository.ItemRepository;
import repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class OrderService {
    private final Logger logger = Logger.getLogger(OrderService.class);
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ItemRepository itemRepository;
    private OrderMapper orderMapper;

    private ItemGroupMapper itemGroupMapper;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ItemRepository itemRepository, OrderMapper orderMapper, ItemGroupMapper itemGroupMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.orderMapper = orderMapper;
        this.itemGroupMapper = itemGroupMapper;
    }

    public OrderDto createOrder(CreateOrderDto createOrderDto) {
        Customer customer = customerRepository.getCustomerById(createOrderDto.getCustomerId()).orElseThrow(() -> new NotFoundException("No customer could be found for this id."));

        List<ItemGroup> itemGroups = createOrderDto.getCreateItemGroupDto()
                .stream()
                .map(CreateItemGroupDto -> creatItemGroupRecord(CreateItemGroupDto))
                .toList();

        Order order = new Order(customer, itemGroups);

        return orderMapper.entityToDto(orderRepository.createOrder(order));

    }

    private ItemGroup creatItemGroupRecord(CreateItemGroupDto createItemGroupDto) {

        Item itemToFind = itemRepository.getItemById(createItemGroupDto.getId()).orElseThrow(() -> new NotFoundException("No item found for " + createItemGroupDto.getId()));
        return new ItemGroup(createItemGroupDto.getId(), createItemGroupDto.getAmount(), itemToFind.calculateShippingDate(), itemToFind.getPrice());
    }

}
