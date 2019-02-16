package pl.sdacademy.register;

import javax.persistence.*;

public class UserDTO {

    private String firstName;
    private String lastName;
    private AddressDTO addressDTO;
    private Long id;
    private String password;

    public UserDTO () {

    }

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.addressDTO = new AddressDTO(user.getAddress());
        this.id = user.getId();
        this.password = user.getPassword();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "First name: "+ firstName + ", last name: " + lastName + ", address:  " + addressDTO;
    }
}



