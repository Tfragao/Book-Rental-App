package com.taison.servlets.users.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.taison.servlets.models.User;

@WebServlet("/admin/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if(id != null) {
			User user = Global.DAO.getUsersById(Long.parseLong(id));
			request.setAttribute("user", user);
		}
		
		request.getRequestDispatcher("/WEB-INF/views/user.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(null, email, password);
		
		String op = "";
		
		try {
			
				if(id == null || id.trim().length() == 0) {
					op = "added";
					Global.DAO.insertUser(user);
				}else {
					op = "modified";
					user.setId(Long.parseLong(id));
					Global.DAO.modifyUser(user);
				}
				request.setAttribute("alertText", "The register has been " + op +  " correctly");
				request.setAttribute("levelAlert", "success");
			
		}catch(NumberFormatException e) {
			request.setAttribute("alertText", "The option of " + op + " did not work");
			request.setAttribute("levelAlert", "danger");
		}
		
		request.getRequestDispatcher("/admin/users").forward(request, response);
	}

}
