package domain.dto;

public class CreateCustomerDto {

    private String id;
    private String firstname;
    private String lastname;
    private String emailAdress;
    private String address;
    private String phonenumber;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public CreateCustomerDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CreateCustomerDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CreateCustomerDto setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
        return this;
    }

    public CreateCustomerDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public CreateCustomerDto setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }
}
