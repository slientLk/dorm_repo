package cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAndRegisterFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		int last = uri.lastIndexOf("/");
		String page = uri.substring(last + 1);
		if(page.equals("index.jsp")) {
			chain.doFilter(request, response);
		}else {
			HttpSession session = req.getSession();
			if(session.getAttribute("list") != null) {
				chain.doFilter(request, response);
			}else {
				String contextPath = req.getContextPath();
				res.sendRedirect(contextPath + "/index.jsp");
			}
		}
	}
	
}
