package pl.sdacademy;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(filterName = "UserLoginFilter", value = "/main")
public class UserLoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (request.getSession(false) == null) {
            response.sendRedirect("index.html");
            return;
        }
        chain.doFilter(request,response);
    }
}
