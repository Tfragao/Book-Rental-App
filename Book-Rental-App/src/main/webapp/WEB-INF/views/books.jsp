<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	
	 <table class="table table-hover table-striped table-bordered">
	 		<thead>
	 			<tr>
	 				<th>Book id</th>
	 				<th>Book title</th>
	 				<th>Author name</th>
	 				<th>Comments</th>
	 				<th>Options</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<c:forEach items="${books}" var="book">
	 				<tr>
	 					<th>${book.id}</th>
	 					<td>${book.title}</td>
	 					<td>${book.author}</td>
	 					<td>Book's comments</td>
	 					<td>
	 						<a class="btn btn-sm btn-primary" href="book?id=${book.id}">Edit</a>  <!-- TODO: change id number by book description, in order to appear in the url -->
	 						<a class="btn btn-sm btn-danger" href="delete?id=${book.id}">Delete</a>
	 					</td>
	 				</tr>
	 			</c:forEach>		
	 		</tbody>
	 		<tfoot>
	 			<tr>
	 				<td></td>
	 				<td></td>
	 				<td></td>
	 				<td></td>
	 				<td><a class="btn btn-sm btn-primary" href="book">Add a book</a></td>
	 			</tr>
	 		</tfoot>
	 </table>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>