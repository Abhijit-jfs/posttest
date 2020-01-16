package com.posttest3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertaccount")
public class AccountInsertServlet extends HttpServlet {
	
	private Connection connection;

	/**
	 * Load O JDBC driver and establish database connection.
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Accept user input, insert into database and redirect to success/error page.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String city = request.getParameter("city");
		String gender = request.getParameter("gender");
		
		int noOfRowsInserted = 0;
		try {
			Statement statement = connection.createStatement();
			String queryString = "insert into accounts values('" + firstName + "', '" + lastName + "', '" + city + "', '" + gender + "')";
			noOfRowsInserted = statement.executeUpdate(queryString);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher;
		if (noOfRowsInserted == 1) {
			requestDispatcher = request.getRequestDispatcher("success.html");
		} else {
			requestDispatcher = request.getRequestDispatcher("error.html");
		}
		requestDispatcher.forward(request, response);
	}
	
	/**
	 * Close database connection when servlet gets destroyed.
	 */
	@Override
	public void destroy() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
