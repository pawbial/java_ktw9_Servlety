package pl.sdacademy;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet (name = "HelloWorldServlet", value = "/helloWorld")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html>\n" +
                "<html lang = \"pl\">\n" +
                "\n" +
                "<head>\n" +
                "\t<title>Statyczna strpna WWW</title>\n" +
                "\t<meta charset=\"utf-8\"  />\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "     <h1>Dzisiaj jest</h1>\n" +
                "\t \n" +
                "\t"+ LocalDateTime.now() + "\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }
}
