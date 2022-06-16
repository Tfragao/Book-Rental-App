<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book</title>
</head>
<body>
		<form action="book" method="post">
			<input name="id" placeholder="Id" value="${book.id}">
			<input name="title" placeholder="book title" value="${book.title}">
			<input name="author" placeholder="book author" value="${book.author}">
			<button>Save Changes</button>
		 
		</form>
		
		<c:choose>
			<c:when test="${book.id != null}">
				<dl>
					<dt>Id</dt>
					<dd>${book.id}</dd>
					<dt>Title</dt>
					<dd>${book.title}</dd>
					<dt>Author</dt>
					<dd>${book.author}</dd>
				</dl>
			</c:when>
			<c:otherwise>
				<p>Book could not be found.</p>
			</c:otherwise>
		</c:choose>
</body>
</html>