<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Student</title>
</head>
<body>
	<div class="container">
		<h3>Student Directory</h3>
		<hr>

		<p class="h4 mb-4">New Student Form</p>
		<form action="/student/students/saveForm" modelAttribute="Student" method="POST">
	
		<!-- Add hidden form to handle update -->
		<input type="hidden" name="id" value="${Student.id}" />
		<div class="form-inline">

			<input type="text" name="firstName" value="${Student.firstName}"
				class="form-control mb4  col-4" placeholder="First Name">


		</div>
		<div class="form-inline">
			<input type="text" name="lastName" value="${Student.lastName}"
				class="form-control mb-4 col-4" placeholder="Last Name">

		</div>

		<div class="form-inline">
			<input type="text" name="course" value="${Student.course}"
				class="form-control mb-4 col-4" placeholder="Course">

		</div>



		<div class="form-inline">
			<input type="text" name="country" value="${Student.country}"
				class="form-control mb-4 col-4" placeholder="Country">

		</div>

		<button type="submit" class="btn btn-info col-2">Save</button>
		

		<hr>
		<a href="/student/students/printstudents">Back to
			Students List</a>
			</form>
	</div>
</body>

</html>