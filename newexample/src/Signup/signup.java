package Signup;
import java.lang.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.Scanner;
/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		response.setContentType("text/html");
		u.firstname=request.getParameter("firstname");
		u.lastname=request.getParameter("lastname");
		u.phoneno=Integer.parseInt(request.getParameter("phoneno"));
		u.address=request.getParameter("address");
		u.email=request.getParameter("email");
		u.password=request.getParameter("password");
		PrintWriter l=response.getWriter();
		l.print("<tr>${u.firstname}</tr>");
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/db101";
		final String USER="user101";
		final String PASSWORD="password";
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		
		String query;
		try{
		
		Class.forName(JDBC_DRIVER);	
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
	        pstmt= conn.prepareStatement("insert into signup(firstname,lastname,phoneno,address,email,password) values(?,?,?,?,?,?);");
		pstmt.setString(1,u.firstname);
		
		pstmt.setString(2,u.lastname);
		
		pstmt.setInt(3, u.phoneno);
		pstmt.setString(4,u.address);
		pstmt.setString(5,u.email);
		pstmt.setString(6,u.password);
		pstmt.executeUpdate();
		conn.close();
		}
		catch(ClassNotFoundException e)
		{
		System.out.println("Cannot find driver1");
		e.printStackTrace();
		}
		catch(SQLException se)
		{
		System.out.println("Cannot find driver2");
		se.printStackTrace();
		}


	}

}
