package com.apex.advance.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apex.advance.java.vo.ValueObj;

public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String phone = request.getParameter("phone");

			ValueObj register = new ValueObj();

			register.setAddress(address);
			register.setCity(city);
			register.setState(state);
			register.setCountry(country);
			register.setPhone(phone);

			String error = "";
			if (address == null || address.trim().length() == 0) {
				error += "<br/>Address name can't be empty";
			}
			if (city == null || city.trim().length() == 0) {
				error += "<br/>City name can't be empty";
			}
			if (state == null || state.trim().length() == 0) {
				error += "<br/>State name can't be empty";
			}
			if (country == null || country.trim().length() == 0) {
				error += "<br/>Country name can't be empty";
			}
			if (phone == null || phone.trim().length() == 0) {
				error += "<br/>Phone name can't be empty";
			}
			if (error == null || error.trim().length() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("contactInfo", register);
				response.sendRedirect("html/bankinfo.html");
			} else {
				request.setAttribute("errors", error);
				RequestDispatcher req = request.getRequestDispatcher("jsp/contactinfo.jsp");
				req.forward(request, response);
			}
	}
}
