package repository;

import domain.customer.Customer;
import domain.item.Item;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class CustomerRepository {

    private final Map<String, Customer> customerById;

    public CustomerRepository() {
        this.customerById = new HashMap<>();
    }

    public Customer createCustomer(Customer customer){

        if (customerById.containsValue(customer)){
            throw new IllegalArgumentException("Customer already exist.");
        }

        customerById.put(customer.getId(),customer);
        return customer;
    }

    public Collection<Customer> getAllCustomers(){
        return customerById.values();
    }

    public Optional<Customer> getCustomerByEmail(String email){
        return customerById.values().stream().filter(customer -> customer.getEmailAddress().equals(email)).findFirst();
    }

    public Optional<Customer> getCustomerById(String id){
        return Optional.ofNullable(customerById.get(id));
    }


}
