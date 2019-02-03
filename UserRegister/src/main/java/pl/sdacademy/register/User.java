package pl.sdacademy.register;

import pl.sdacademy.register.Address;

import javax.persistence.*;

@Entity
public class User {
    
    private String firstName;
    private String lastName;
    private Address address;
    private Long id;

    public User () {

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column ()
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @OneToOne (cascade = CascadeType.ALL)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", id=" + id +
                '}';
    }
}
