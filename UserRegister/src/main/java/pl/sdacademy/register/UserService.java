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
        user.setPassword(userDTO.getPassword());
        user.setUserName(userDTO.getUserName());

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

    void updateUser (UserDTO userDTO) {
        User user = userDAO.getUser(userDTO.getId());
        Address address = new Address();
        address.setCity(userDTO.getAddressDTO().getCity());
        address.setHouseNumber(userDTO.getAddressDTO().getHouseNumber());
        address.setStreet(userDTO.getAddressDTO().getStreet());

        user.setAddress(address);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setId(userDTO.getId());
        user.setPassword(userDTO.getPassword());

        userDAO.mergeUser(user);
    }

    Collection <UserDTO> showUsers () {
        List<UserDTO> users = userDAO.getUsers().stream().map(UserDTO::new).collect(Collectors.toList());
        return users;
    }

    UserDTO findByID (Long id) {
        User user = userDAO.getUser(id);
        if (user != null) {
            return new UserDTO(user);
        }
        return null;
    }

    UserDTO findByLastName (String lastName) {
        User user = userDAO.getUserByLastName(lastName);
        if (user != null) {
            return new UserDTO(user);
        }
        return null;
    }

    UserDTO findByUserName (String userName) {
        User user = userDAO.getUserByUserName(userName);

        if (user != null) {
            return new UserDTO(user);
        }

        return null;
    }


}
