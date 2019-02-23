package pl.sdacademy.register;

import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String userName = request.getParameter("userNameLogin");
        String password = request.getParameter("passwordLogin");

        UserDTO validatedUser = userService.findByUserName(userName);

        if (validatedUser == null) {
            String userNotFoundError = "User not found, please type again correct user name or create account";
            request.setAttribute("userseNotFoundError", userNotFoundError);
            response.sendRedirect("/login");
        }

        if (validatedUser != null) {
            String match = validatedUser.getPassword();
            String login = "login";
            String md5Hex = DigestUtils.md5Hex(password);
            if (!md5Hex.equals(match)) {
                String passwordMatchError = "Wrong password, type again!";
                request.setAttribute("passwordMatchError", passwordMatchError);
                request.getRequestDispatcher("/login").forward(request, response);
            } else if (md5Hex.equals(match)) {
                request.setAttribute("userName", userName);
                session.setAttribute("login", login);
                request.getRequestDispatcher("/main/welcome").forward(request, response);
            }
        }

    }
}



