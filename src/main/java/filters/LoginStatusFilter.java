package filters;

import javax.servlet.*;
import java.io.IOException;

public class LoginStatusFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //todo: check login status through cookies
    }

    public void destroy() {

    }
}
