package com.taison.servlets.users.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.taison.servlets.models.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2176330293524695509L;
	private static final String LOGIN_JSP = "/WEB-INF/views/login.jsp";
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(null, email, password);
		
		User validateUser = validateUser(user);
		
		if(validateUser != null) {
			request.getSession().setAttribute("user", validateUser);
			response.sendRedirect(request.getContextPath() + "/admn/users");
			
		}else {
			request.setAttribute("alertText", "Email or password incorrect");
			request.setAttribute("levelAlert", "danger");
			request.setAttribute("user", user);
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
		
	}

	private User validateUser(User user) {
		User userFound = Global.DAO.getByEmail(user.getEmail());
		
		if(userFound != null && user.getPassword().equals(userFound.getPassword())) {
			return userFound;
		}
		
		return null;
	}


	

}
