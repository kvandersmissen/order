package domain.customer;

import security.Feature;
import security.UserRole;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class Customer {

    private String id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String address;
    private String phoneNumber;
    private String password;
    private UserRole role;

    public Customer(String firstname, String lastname, String emailAddress, String address, String phoneNumber, String password, UserRole role) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        setEmailAddress(emailAddress);
        setAddress(address);
        this.phoneNumber = phoneNumber;
        setPassword(password);
        this.role = role;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Please provide an address");
        }
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        if (!isValidEmail(emailAddress)) {
            throw new IllegalArgumentException("Please provide a valid email adres");
        }
        this.emailAddress = emailAddress;
    }

    private boolean isValidEmail(String emailAddress) {
        if (emailAddress == null || emailAddress.isEmpty()){
            return false;
        }
        String emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(emailRegexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Please provide a password");
        }
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public UserRole getRole() {return role;}

    public boolean doesPasswordMatch(String password) {
        return this.password.equals(password);
    }

    public boolean canHaveAccessTo(Feature feature) {
        return role.containsFeature(feature);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(emailAddress, customer.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }

}
