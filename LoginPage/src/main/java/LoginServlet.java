

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		String a = request.getParameter("n1");
		String b = request.getParameter("n2");

		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","Bhaktha06");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from reg where username = '"+a+"' and password = '"+b+"' ");
			
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("username", a);
				response.sendRedirect("home.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		}
		catch(Exception e) {
			pw.println(e);
		}
	}

}
