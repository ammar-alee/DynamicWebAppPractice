<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal Info</title>
</head>
<body>
	<%
		Object err = request.getAttribute("errors");
		if (err != null) {
			String strErr = err.toString();
	%>
	<%=strErr%>
	<%
		}
	%>

	<h1>Personal Information</h1>
	<form method="get"
		action="/AdvanceJavaWebExcersice/PersonalInfoServlet"
		id="personalInfo">
		<input type="hidden" name="registerForm" value="register" />
		<table cellpadding="5" cellspacing="5">
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" required="required"
					minlength="2"></td>
			</tr>
			<tr>
				<td>Middle Name::</td>
				<td><input type="text" name="middleName"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" required="required"
					minlength="2"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" id="Male" value="Male"><label
					for="Male">  Male  </label><input type="radio" name="gender"
					id="Female" value="Female"> <label for="Female">  Female  </label></td>
			</tr>
			<tr>
				<td><input class="submit" type="submit" value="Submit"
					style="height: 200px; width: 200px"></td>
			</tr>
		</table>
	</form>
</body>
</html>