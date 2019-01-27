package pl.sdacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;


@WebServlet(name = "MainServlet", value = "/main")

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("index.html");
            return;
        }
        String welcomeUser = (String) session.getAttribute("welcomeUser");

        response.getWriter().println("" +
                "<html>" +
                "<body>" + welcomeUser +
                "<a href=\"/login\"><br>Back</a>" +
                "</body>" +
                "</html>");
    }
}

