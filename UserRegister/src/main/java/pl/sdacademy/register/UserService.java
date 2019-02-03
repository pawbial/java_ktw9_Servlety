package pl.sdacademy.register;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jws.soap.SOAPBinding;

@Singleton
public class UserService {

    @Inject
    private UserDAO userDAO;


    void saveUser (UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        AddressDTO addressDTO = userDTO.getAddress();
        if (addressDTO != null) {
            Address address = new Address();
            address.setCity(addressDTO.getCity());
            address.setStreet(addressDTO.getStreet());
            address.setHouseNumber(addressDTO.getHouseNumber());
        }
        userDAO.saveUser(user);
    }
}
