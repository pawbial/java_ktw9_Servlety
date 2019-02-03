package pl.sdacademy.register;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "WelcomeController", value = "/welcome")
public class WelcomeController extends HttpServlet {

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        HttpSession session = request.getSession(false);

        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request,response);
    }
}
