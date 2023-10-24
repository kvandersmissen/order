package domain.dto;

import security.UserRole;

public class CreateCustomerDto {

    private String firstname;
    private String lastname;
    private String emailAddress;
    private String address;
    private String phoneNumber;

    private String password;

    private UserRole role;

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

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public CreateCustomerDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CreateCustomerDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CreateCustomerDto setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CreateCustomerDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public CreateCustomerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CreateCustomerDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public CreateCustomerDto setRole(UserRole role) {
        this.role = role;
        return this;
    }
}
