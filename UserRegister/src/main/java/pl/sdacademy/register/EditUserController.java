package pl.sdacademy.register;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@WebServlet(name = "EditUserController", value = "/userEdit")
public class EditUserController extends HttpServlet {


    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));

        UserDTO user = userService.findByID(id);

        request.setAttribute("user", user);

        request.getRequestDispatcher("WEB-INF/userCreate.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String houseNumber = request.getParameter("houseNumber");


        Long id = Long.valueOf(request.getParameter("id"));

        if (id != null) {

            UserDTO user = userService.findByID(id);

            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setCity(city);
            addressDTO.setHouseNumber(houseNumber);
            addressDTO.setStreet(street);

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setId(id);

            Collection<String> validation = new UserRegisterValidator().validateUser(user);

            if (validation.size() != 0) {

                request.getRequestDispatcher("/error").forward(request, response);
            } else {
                userService.updateUser(user);
                request.getRequestDispatcher("/list").forward(request, response);
            }

        }

    }
}

