package com.apex.advance.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apex.advance.java.db.DbManager;
import com.apex.advance.java.vo.ValueObj;

public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bankName = request.getParameter("bankName");
		String accountNumber = request.getParameter("accountNumber");
		String ssn = request.getParameter("ssn");

		ValueObj register = new ValueObj();

		register.setBankName(bankName);
		register.setAccountNumber(accountNumber);
		register.setSsn(ssn);

		String error = "";
		if (bankName == null || bankName.trim().length() == 0) {
			error += "<br/>Bank name can't be empty";
		}
		if (accountNumber == null || accountNumber.trim().length() == 0) {
			error += "<br/>Account Number can't be empty";
		}
		if (ssn == null || ssn.trim().length() == 0) {
			error += "<br/>SSN field name can't be empty";
		}

		if (error == null || error.trim().length() == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("bankInfo", register);
			response.sendRedirect("jsp/output.jsp");
		} else {
			request.setAttribute("errors", error);
			RequestDispatcher req = request.getRequestDispatcher("jsp/bankinfo.jsp");
			req.forward(request, response);
		}
		try {
			DbManager.createTable();
			DbManager.insertRecord(register);
			DbManager.checkUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
