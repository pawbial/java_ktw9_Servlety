package pl.sdacademy.register;

import javax.persistence.*;

public class UserDTO {

    private String firstName;
    private String lastName;
    private Address address;
    private Long id;

    public UserDTO () {

    }

    public UserDTO(String firstName, String lastName, Address address, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

