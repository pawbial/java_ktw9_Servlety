package pl.sdacademy.register;

import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        String md5Hex = DigestUtils.md5Hex(password);

        UserDTO validatedUser = userService.findByLastName(lastName);

        String match = validatedUser.getPassword();

        if (md5Hex.equals(match)) {

            response.sendRedirect("/list");
        } else {
            request.getRequestDispatcher("/error").forward(request,response);
        }

    }
}
