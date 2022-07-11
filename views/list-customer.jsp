<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Customer Relation Management Directory</title>
</head>

<body>
	<div class="container">
		<h3>Customer Relation Management Directory</h3>
		<hr>
		<!--  table form -->
		<table class="table table-bordered table-striped">
			<thead class="thead-light">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<!-- body to display the Customer details -->
			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerRelationManagement/Updateform?CustomerId=${tempCustomer.id}"
							class="btn btn-outline-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/CustomerRelationManagement/delete?CustomerId=${tempCustomer.id}"
							class="btn btn-outline-danger btn-sm"
							onclick="if (!(confirm('confirm to delete the student?'))) return false">Delete
						</a>

						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="text-right">
			<!-- Add a button -->
			<a href="/CustomerRelationManagement/Addform"
				class="btn btn-outline-success btn-sm mb-3"
				style="text-align: center"> Add Customer </a>
		</div>
	</div>
</body>
</html>



