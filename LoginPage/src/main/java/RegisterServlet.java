

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter pw = response.getWriter();
		String a = request.getParameter("n1");
		String b = request.getParameter("n2");

		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","Bhaktha06");
			Statement st = con.createStatement();
			st.executeUpdate("insert into reg values ('"+a+"','"+b+"') ");
			/* pw.println("Insert successful"); */
			response.sendRedirect("login.jsp");
		
		}
		catch(Exception e) {
			pw.println(e);
		}
	}

}
