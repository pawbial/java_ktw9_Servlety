import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;


@WebServlet (name = "DownloadServlet", value = "/download")
public class DownloadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>DownloadServlet</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Select file to download: </h1>\n" +
                "<form method=\"post\" action=\"/\" name=\"fileToDownload\">\n" +
                "    <input type=\"text\" name=\"fileName\">\n" +
                "    <input type=\"submit\" value=\"Download\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = request.getParameter("fileName");

        if (StringUtils.isBlank(fileName)) {
            response.getWriter().println("<html>+" +
                    "<body>" +
                    "Missing file name" +
                    "<a href=\"/download\">Back</a>" +
                    "</body>" +
                    "</html>");
            return;
        }
        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/" + fileName);

        if (inputStream == null) {
          response.getWriter().println("file not found!");
        }

        response.setContentType("application/octet-stream"); //informujesz przeglądarkę, że ona ma to pobrać, bo nie wie co z tym zrobić
        response.setHeader("Content-Disposition","attachment; filename=\""+ fileName + "\"");

        ServletOutputStream outputStream = response.getOutputStream();

//        IOUtils.copy(inputStream,outputStream);  Metoda z biblioteki commons-io, zastępuje całe pobieranie z tej sekcji. c

        byte [] buffer = new byte[8 * 1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) { //-1 oznacza, że cały plik został przesłany!
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        outputStream.close();

    }
}
