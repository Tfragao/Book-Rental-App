<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>



<table class="table table-hover table-striped table-bordered">
	 		<thead>
	 			<tr>
	 				<th>id</th>
	 				<th>Email</th>
	 				<th>password</th>
	 				<th>Comments</th>
	 				<th>Options</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<c:forEach items="${users}" var="user">
	 				<tr>
	 					<th>${user.id}</th>
	 					<td>${user.email}</td>
	 					<td>${user.password}</td>
	 					<td><c:if test="${user.email.contains(user.password)}">
				Better Change password
			</c:if></td>
	 					<td>
	 						<a class="btn btn-sm btn-primary" href="admin/user?id=${user.id}">Edit</a>  <!-- TODO: change id number by book description, in order to appear in the url -->
	 						<a class="btn btn-sm btn-danger" href="admin/delete?id=${user.id}">Delete</a>
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
	 				<td><a class="btn btn-sm btn-primary" href="admin/user">Add a user</a></td>
	 			</tr>
	 		</tfoot>
	 </table>
 <%@ include file="/WEB-INF/views/includes/footer.jsp"%>