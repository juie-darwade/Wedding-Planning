package login;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

import Signup.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String emaila=request.getParameter("email");
		String password=request.getParameter("password");
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/db101";
		final String USER="user101";
		final String PASSWORD="password";
		String query;
		try{
		Statement stmt=null;
		ResultSet rs=null;
		java.sql.PreparedStatement pstmt=null;
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
		Class.forName(JDBC_DRIVER);	
		query="select email,password from signup where email=? and password=?;";
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, emaila);
		pstmt.setString(2, password);
		rs=pstmt.executeQuery();
		HttpSession session = request.getSession(true);
		if(rs.next())
		{
			PrintWriter out2=response.getWriter();
            session.setAttribute("email", request.getParameter("email"));
			out2.print("<html><body>Welcome</body></head>");
		}
		else
		{
			 session.invalidate();
             request.setAttribute("errorMessage", "Invalid user or password");
             RequestDispatcher rd = request.getRequestDispatcher("/us.jsp");
             rd.forward(request, response); 
						
		}
		rs.close();
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
