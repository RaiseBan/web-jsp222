package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = "/*")
public class NotFoundFilter implements Filter {

    private Set<String> allowedURIs;

    @Override
    public void init(FilterConfig filterConfig) {
        // Инициализация списка разрешенных URI
        allowedURIs = new HashSet<>();
        allowedURIs.add("/Web_Lab2/");
        allowedURIs.add("/Web_Lab2/index.jsp");
        allowedURIs.add("/Web_Lab2/styles/header.css");
        allowedURIs.add("/Web_Lab2/styles/main.css");
        allowedURIs.add("/Web_Lab2/scripts/canvas.js");
        allowedURIs.add("/Web_Lab2/scripts/sendData.js");
        allowedURIs.add("/Web_Lab2/scripts/validation.js");
        allowedURIs.add("/Web_Lab2/scripts/changeStyles.js");
        allowedURIs.add("/Web_Lab2/notFound.jsp");
        allowedURIs.add("/Web_Lab2/img/background-image.jpg");
        allowedURIs.add("/Web_Lab2/scripts/clickOnCanvas.js");
        allowedURIs.add("/Web_Lab2/img/cats)))))).jpg");
        allowedURIs.add("/Web_Lab2/controller");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        System.out.println(requestURI);
        if (allowedURIs.contains(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/notfound.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
        // Ресурсы освобождены
    }
}
