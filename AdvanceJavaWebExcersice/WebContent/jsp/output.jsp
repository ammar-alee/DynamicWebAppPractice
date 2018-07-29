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

<jsp:useBean id="personalInfo" class="com.apex.advance.java.vo.ValueObj" scope="session"></jsp:useBean>
<jsp:useBean id="contactInfo" class="com.apex.advance.java.vo.ValueObj" scope="session"></jsp:useBean>
<jsp:useBean id="bankInfo" class="com.apex.advance.java.vo.ValueObj" scope="session"></jsp:useBean>

<!-- personal info -->
Name: <font color="blue">
<jsp:getProperty property="firstName" name="personalInfo"/>
<jsp:getProperty property="middleName" name="personalInfo"/>
<jsp:getProperty property="lastName" name="personalInfo"/></font><br>
Gender: <font color="blue">
<jsp:getProperty property="gender" name="personalInfo"/></font><br>

<!-- contact info -->
 Address: <font color="blue">
 <jsp:getProperty property="address" name="contactInfo"/>
 <jsp:getProperty property="city" name="contactInfo"/>
 <jsp:getProperty property="state" name="contactInfo"/>
 <jsp:getProperty property="country" name="contactInfo"/></font>
 <br>
Phone: <font color="blue"><jsp:getProperty property="phone" name="contactInfo"/></font><br>

<!-- bank info -->
Bank Name: <font color="blue"> <jsp:getProperty property="bankName" name="bankInfo"/><br></font>
Account Number: <font color="blue"> <jsp:getProperty property="accountNumber" name="bankInfo"/><br></font>
SSN: <font color="blue"> <jsp:getProperty property="ssn" name="bankInfo"/></font>
<br/><br/><br/>
<%
 java.util.Date date = new java.util.Date();    
%>
Last Updated on: <font color="green"><%= date %></font>
</body>
</html>