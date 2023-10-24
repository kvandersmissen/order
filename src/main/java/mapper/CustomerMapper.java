package mapper;

import domain.customer.Customer;
import domain.dto.CreateCustomerDto;
import domain.dto.CustomerDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerMapper {

    public List<CustomerDto> mapToDto(List<Customer> customers) {
        return customers.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Customer mapToEntity(CreateCustomerDto createCustomerDto) {
        return new Customer(createCustomerDto.getFirstname(),
                createCustomerDto.getLastname(),
                createCustomerDto.getEmailAddress(),
                createCustomerDto.getAddress(),
                createCustomerDto.getPhoneNumber(),
                createCustomerDto.getPassword(),
                createCustomerDto.getRole());
    }

    public CustomerDto entityToDto(Customer customer) {
        return new CustomerDto()
                .setId(customer.getId())
                .setFirstname(customer.getFirstname())
                .setLastname(customer.getLastname())
                .setAddress(customer.getAddress())
                .setPhoneNumber(customer.getPhoneNumber())
                .setEmailAddress(customer.getEmailAddress())
                ;
    }
}
