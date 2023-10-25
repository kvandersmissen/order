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

}
