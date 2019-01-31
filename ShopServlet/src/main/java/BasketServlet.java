import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet (name = "BasketServlett", value = "/basket")
public class BasketServlet extends HttpServlet {

    private Map<String, Integer> basket = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Object object = session.getAttribute("basket");

        basket = (Map<String, Integer>)object;



        response.getWriter().println("<h1>DUPA</h1>");
        response.getWriter().println(basket);
    }
}
