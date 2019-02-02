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



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Object object = session.getAttribute("basket");

        Map<String, Integer> basket = (Map<String, Integer>)object;

        response.getWriter().println("<html lang=\"en\">\n" +
                "<body>\n" +
                "\n" +
                "    <p>Basket content</p>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>Article name</th>\n" +
                "            <th>Quantity</th>\n" +
                "        </tr>\n" +
                "        <br>\n" +
                "        <a href=\"/shop\">Add another article</a>\n" +
                "        <br>\n" +
                "        <a href=\"/login\">Login</a>\n" +
                "    </table>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }


    private String printBasket (Map<String, Integer> basket) {
        String string = null;
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
           string = "<h2>" + entry.getKey() + "" + entry.getValue() +"</h2>";
            System.out.println();
        }
        return string;
    }
}


