

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		String a = request.getParameter("n1");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","Bhaktha06");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from reg where username='"+a+"' ");
			if(rs.next()) {
				pw.println(rs.getString(2));
			}
			else {
				pw.println("Invalid username");
			}
		}
		catch(Exception e) {
			pw.println(e);
		}
	}

}
