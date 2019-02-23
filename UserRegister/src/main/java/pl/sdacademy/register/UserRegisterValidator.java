package pl.sdacademy.register;

import org.apache.commons.lang3.StringUtils;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Collection;

public class UserRegisterValidator {

    public Collection <String> validateUser (UserDTO user) {

        Collection <String> validationMessages = new ArrayList<>();

        if (StringUtils.isBlank(user.getFirstName())) {
          validationMessages.add("First name cannot be empty");
        }
        if (StringUtils.isBlank(user.getLastName())) {
            validationMessages.add("Last name cannot be empty");
        }
        if (StringUtils.isBlank(user.getAddressDTO().getCity())) {
            validationMessages.add("City cannot be empty");
        }
        if (StringUtils.isBlank(user.getAddressDTO().getStreet())) {
            validationMessages.add("Street cannot be empty");
        }
        if (StringUtils.isBlank(user.getAddressDTO().getHouseNumber())) {
            validationMessages.add("House number cannot be empty");
        }
        if (StringUtils.isBlank(user.getPassword())){
            validationMessages.add("Password cannot be empty");
        }
        if (StringUtils.isBlank(user.getUserName())){
            validationMessages.add("user name cannot be empty");
        }
        return validationMessages;
    }
}
