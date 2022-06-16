<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

		<form action="book" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" id="id" name="id" value="${book.id}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="title" class="col-sm-2 col-form-label">Title</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="title" name="title" value="${book.title}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="author" class="col-sm-2 col-form-label">Author</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="author" name="author" value="${book.author}">
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-sm-10 offset-sm-2">
			<button type="submit" class="btn btn-primary">Save Changes</button>
			<a class="btn btn-danger" href="books">Canncel</a>
		</div>
	</div>
	
</form>
		
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>