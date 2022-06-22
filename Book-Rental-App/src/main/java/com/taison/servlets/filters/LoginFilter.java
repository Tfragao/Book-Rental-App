package com.taison.servlets.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.taison.servlets.models.User;


@WebFilter("/admin/*")
public class LoginFilter extends HttpFilter {
       
	private static final long serialVersionUID = 1895926193742720686L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if(user == null) {
			httpRequest.setAttribute("alertText", "You must be logged in to access the administrative section");
			httpRequest.setAttribute("levelAlert", "danger");
			httpRequest.getRequestDispatcher("login").forward(httpRequest, httpResponse);
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
