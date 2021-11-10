package mk.ukim.finki.lab1.lab1.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ColorFilter")
public class ColorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String color = (String) req.getSession().getAttribute("color");
        String path = req.getServletPath();

        if(color == null && !path.equals("")){
            resp.sendRedirect("/");
        }
        else {
            chain.doFilter(request,response);
        }

    }
}
