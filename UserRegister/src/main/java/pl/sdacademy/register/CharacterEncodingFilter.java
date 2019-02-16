package pl.sdacademy.register;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter (filterName = "CharacterEncodingController", value = "/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        filter.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
