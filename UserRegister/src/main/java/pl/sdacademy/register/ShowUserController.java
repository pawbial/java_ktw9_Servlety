package pl.sdacademy.register;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (name = "ShowUserController", value = "/userProfile")
public class ShowUserController extends HttpServlet {


    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));

        UserDTO user = userService.findByID(id);

        request.setAttribute("user",user);

        request.getRequestDispatcher("WEB-INF/showUser.jsp").forward(request,response);
    }
}
