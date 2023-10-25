package domain.dto;

public class CustomerDto {

    private String id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String address;
    private String phoneNumber;

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

    public CustomerDto(String id, String firstname, String lastname, String emailAddress, String address, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
