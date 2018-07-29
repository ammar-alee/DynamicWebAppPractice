<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Info</title>
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

	<h1>Contact Information</h1>
	<form method="post"
		action="/AdvanceJavaWebExcersice/ContactInfoServlet" id="contactInfo">
		<input type="hidden" name="registerForm" value="register" />
		<table cellpadding="5" cellspacing="5">
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" required="required"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" required="required"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state" required="required"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country" required="required"></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="tel" name="phone" required="required"
					minlength="7"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"
					style="height: 200px; width: 200px"></td>
			</tr>
		</table>
	</form>
</body>
</html>