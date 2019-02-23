package pl.sdacademy.register;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Digits;
import java.io.IOException;
import java.util.Collection;

@WebServlet (name = "RegisterController", value ="/user")
public class RegisterController extends HttpServlet {


    @Inject
    private UserService userService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/userCreate.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String houseNumber = request.getParameter("houseNumber");
        String password = request.getParameter("password");
        String passwordRetype = request.getParameter("passwordRetype");
        String userName = request.getParameter("userName");

        UserDTO userNameValidation = userService.findByUserName(userName);

        if (userNameValidation != null) {
            String userNameError = "User name already taken, please pick another user name";
            request.setAttribute("userNameError", userNameError);
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
            return;
        }

        if (!StringUtils.equals(password,passwordRetype)) {
            String passwordError = "Password didn't match";
            request.setAttribute("passwordError",passwordError);
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
            return;
    }
        String md5Hex = DigestUtils.md5Hex(password);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(city);
        addressDTO.setStreet(street);
        addressDTO.setHouseNumber(houseNumber);

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setAddressDTO(addressDTO);
        userDTO.setPassword(md5Hex);
        userDTO.setUserName(userName);

        Collection<String> validation = new UserRegisterValidator().validateUser(userDTO);

        if (validation.size() != 0) {
            request.getRequestDispatcher("/error").forward(request,response);
        } else {
            userService.saveUser(userDTO);
        }

       request.getRequestDispatcher("/main/welcome").forward(request,response);

    }
}
