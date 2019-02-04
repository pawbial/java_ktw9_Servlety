package pl.sdacademy.register;

import javax.persistence.*;

public class UserDTO {

    private String firstName;
    private String lastName;
    private AddressDTO addressDTO;
    private Long id;

    public UserDTO () {

    }

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.addressDTO = new AddressDTO(user.getAddress());
        this.id = user.getId();
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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "First name: "+ firstName + ", last name: " + lastName + ", address:  " + addressDTO;
    }
}



