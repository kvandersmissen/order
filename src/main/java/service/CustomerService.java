package service;

import domain.customer.Customer;
import domain.dto.CreateCustomerDto;
import domain.dto.CustomerDto;
import domain.item.Item;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import mapper.CustomerMapper;
import repository.CustomerRepository;

import java.util.List;

@ApplicationScoped
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customerToAdd = customerMapper.mapToEntity(createCustomerDto);
        return customerMapper.entityToDto(customerRepository.createCustomer(customerToAdd));
    }

    public List<CustomerDto> getCustomers() {
        return customerMapper.mapToDto(customerRepository.getAllCustomers().stream().toList());
    }

    public CustomerDto getCustomerByid(String id){
        Customer customerToFind = customerRepository.getCustomerById(id).orElseThrow(() -> new NotFoundException("No item found for " + id));
        return customerMapper.entityToDto(customerToFind);
    }
}
