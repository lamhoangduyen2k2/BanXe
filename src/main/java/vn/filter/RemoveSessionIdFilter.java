package vn.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "removeSessionIdFilter", urlPatterns = {"/*"})
public class RemoveSessionIdFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uri = request.getRequestURI();
        if (uri.endsWith(";jsessionid")) {
            String redirectUrl = uri.substring(0, uri.indexOf(";jsessionid"));
            response.sendRedirect(redirectUrl);
        } else {
            chain.doFilter(request, response);
        }
		
	}
	
	@Override
	public void destroy() {
	}

}
