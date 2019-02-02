import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@WebServlet(name = "ArticleControllerServlet", value = "/")

public class ArticleControllerServlet extends HttpServlet {


    private Map<Integer, String> products = new HashMap<>();



    public ArticleControllerServlet() {
        products.put(1, "Piwo");
        products.put(2, "Kielba");
        products.put(3, "Karczek");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection <Article> articles = new ArticleService().getAvialableArticles();

        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Basket</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Pick product: </h2>\n" +
                "<form action=\"products\" method=\"post\" value=\"add product\">\n" +
                "    <select name=\"article\">\n" +
                "        <option value=\"\" disabled selection>Select ...</option>\n" +
                products.entrySet().stream().map(entry -> "<option value=\"" + entry.getKey() + "\">" + entry.getValue() + "</option>").collect(Collectors.joining()) +
                "    </select>\n" +
                "    <h2>Set quantity</h2>\n" +
                "    <select action=\"quantity\" method=\"post\">\n" +
                "        <input type=\"number\" min=\"1\" name=\"quantity\">\n" +
                "\n" +
                "    </select>\n" +
                "    <input type=\"submit\" name=\"add\" <br>>\n" +
                "</form>\n" +
                "<form action=\"basket\" method=\"get\" value=\"Go to cart\">" +
                " \"<input type=\"submit\"action=\"/basket\" method=\"get\"value=\"Go to cart\" >\" " +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        Object object = session.getAttribute("basket");
        Map<String, Integer> basket = (Map<String, Integer>) object;

        if (basket == null) {
            basket = new HashMap<>();
        }

        Integer article = Integer.valueOf(request.getParameter("article"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));

        for (Map.Entry<Integer, String> entry : products.entrySet()) {
            if (entry.getKey() == article) {
                if (basket.get(entry.getValue()) == null) {
                    basket.put(entry.getValue(), quantity);
                } else {
                    basket.compute(entry.getValue(), (key, val) -> val + quantity);
                }
            }
        }
        session.setAttribute("basket", basket);

        response.sendRedirect("/shop");
    }
}
