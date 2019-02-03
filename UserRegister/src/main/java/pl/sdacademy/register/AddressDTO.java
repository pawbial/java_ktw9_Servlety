package pl.sdacademy.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class AddressDTO {

    private String street;
    private String city;
    private String houseNumber;
    private Long id;

    public AddressDTO() {

    }

    public AddressDTO(String street, String city, String houseNumber, Long id) {
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
