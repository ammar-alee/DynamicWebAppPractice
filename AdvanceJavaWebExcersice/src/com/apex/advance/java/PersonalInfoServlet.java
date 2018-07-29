package com.apex.advance.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apex.advance.java.vo.ValueObj;

public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

			String firstName = request.getParameter("firstName");
			String middleName = request.getParameter("middleName");
			String lastName = request.getParameter("lastName");
			String gender = request.getParameter("gender");

			ValueObj register = new ValueObj();

			register.setFirstName(firstName);
			register.setMiddleName(middleName);
			register.setLastName(lastName);
			register.setGender(gender);

			String error = "";
			if (firstName == null || firstName.trim().length() == 0) {
				error += "<br/>First name can't be empty";
			}
			if (middleName == null || middleName.trim().length() == 0) {
				error += "<br/>Middle name can't be empty";
			}
			if (lastName == null || lastName.trim().length() == 0) {
				error += "<br/>Last name can't be empty";
			}

			if (error == null || error.trim().length() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("personalInfo", register);
				response.sendRedirect("html/contactinfo.html");
			} else {
				request.setAttribute("errors", error);
				RequestDispatcher req = request.getRequestDispatcher("jsp/personalinfo.jsp");
				req.forward(request, response);
			}
	}
}