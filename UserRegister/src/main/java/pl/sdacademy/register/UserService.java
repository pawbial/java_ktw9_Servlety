package pl.sdacademy.register;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jws.soap.SOAPBinding;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class UserService {

    @Inject
    private UserDAO userDAO;


    void saveUser (UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        AddressDTO addressDTO = userDTO.getAddressDTO();
        if (addressDTO != null) {
            Address address = new Address();
            address.setCity(addressDTO.getCity());
            address.setStreet(addressDTO.getStreet());
            address.setHouseNumber(addressDTO.getHouseNumber());
            user.setAddress(address);
        }
        userDAO.saveUser(user);
    }

    Collection <UserDTO> showUsers () {
        List<UserDTO> users = userDAO.getUsers().stream().map(UserDTO::new).collect(Collectors.toList());
        return users;
    }
}
