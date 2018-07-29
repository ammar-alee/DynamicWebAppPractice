<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Successful</title>
</head>
<body>
<h1>You have registered successfully</h1>
<% Object err = request.getAttribute("errors");
	if(err != null) {
		String strErr = (String) err;
	
%>
<%= strErr %>
<% } %>
<!-- personal info -->
Name: <font color="blue"><%= session.getAttribute("firstname") %> 
<%= session.getAttribute("middlename") %>
<%= session.getAttribute("lastname") %> </font><br>
Gender: <font color="blue"><%= session.getAttribute("gender") %> </font><br>

<!-- contact info -->
 Address: <font color="blue"><%= session.getAttribute("address") %>
<%= session.getAttribute("city") %>
<%= session.getAttribute("state") %>
<%= session.getAttribute("country") %> </font><br>
Phone: <font color="blue"><%= session.getAttribute("tel") %> </font><br>

<!-- bank info -->
Bank Name: <font color="blue"><%= session.getAttribute("bankname") %> </font><br>
Account Number: <font color="blue"><%= session.getAttribute("accountnumber") %> </font><br>
SSN: <font color="blue"><%= session.getAttribute("ssn") %> </font>
<br/><br/><br/>
<%
 java.util.Date date = new java.util.Date();    
%>
Last Updated on: <font color="green"><%= date %></font>
</body>
</html>