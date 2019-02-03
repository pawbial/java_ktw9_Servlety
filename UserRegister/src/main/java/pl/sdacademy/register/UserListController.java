package pl.sdacademy.register;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@WebServlet (name = "UsersListServlet", value = "/list")
public class UserListController extends HttpServlet {


    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<UserDTO> users = userService.showUsers();
        request.setAttribute("users",users);

        request.getRequestDispatcher("WEB-INF/users.jsp").forward(request,response);



    }
}
