<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bank Info</title>
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

	<h1>Bank Information</h1>
	<form method="post" action="/AdvanceJavaWebExcersice/BankInfoServlet"
		id="bankInfo">
		<input type="hidden" name="registerForm" value="register" />
		<table cellpadding="5" cellspacing="5">
			<tr>
				<td>Bank Name:</td>
				<td><input type="text" name="bankName" required="required"></td>
			</tr>
			<tr>
				<td>Account Number:</td>
				<td><input type="number" name="accountNumber"
					required="required"></td>
			</tr>
			<tr>
				<td>SSN:</td>
				<td><input type="number" name="ssn" required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"
					style="height: 200px; width: 200px"></td>
			</tr>
		</table>
	</form>
</body>
</html>