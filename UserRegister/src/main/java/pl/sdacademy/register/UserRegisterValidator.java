package pl.sdacademy.register;

import org.apache.commons.lang3.StringUtils;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Collection;

public class UserRegisterValidator {

    public Collection <String> validateUser (User user) {

        Collection <String> validationMessages = new ArrayList<>();

        if (StringUtils.isBlank(user.getFirstName())) {
          validationMessages.add("First name cannot be empty");
        }
        if (StringUtils.isBlank(user.getLastName())) {
            validationMessages.add("Last name cannot be empty");
        }
        if (StringUtils.isBlank(user.getAddress().getCity())) {
            validationMessages.add("City cannot be empty");
        }
        if (StringUtils.isBlank(user.getAddress().getStreet())) {
            validationMessages.add("Street cannot be empty");
        }
        if (StringUtils.isBlank(user.getAddress().getHouseNumber())) {
            validationMessages.add("House number cannot be empty");
        }
        return validationMessages;
    }
}
