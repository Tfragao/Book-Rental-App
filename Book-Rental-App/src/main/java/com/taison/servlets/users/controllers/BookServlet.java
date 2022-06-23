package com.taison.servlets.users.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.taison.servlets.dao.DaoBook;
import com.taison.servlets.dao.DaoBookMemory;
import com.taison.servlets.models.Book;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final DaoBook DAO = DaoBookMemory.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if (id != null) {
			Book book = DAO.getBooksById(Long.parseLong(id));
			request.setAttribute("book", book);
		}
		
		request.getRequestDispatcher("WEB-INF/views/book.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		
		Book book = new Book(null, title, author);
		
		if(id == null || id.trim().length() == 0) {
			DAO.insert(book);
		}else {
			book.setId(Long.parseLong(id));
			DAO.modify(book);
		}
		
		response.sendRedirect(request.getContextPath() + "/books");
	}

}
