package com.mp.jdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/loginform")
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("pass1");
		
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mp_demo", "root","Nithya@2011");
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=?");
			//positional parameter creation
			ps.setString(1, myemail);
			ps.setString(2, mypass);
			
			ResultSet rs = ps.executeQuery();
				if(rs.next())
				
				{
					HttpSession session = req.getSession();
					session.setAttribute("session_name", rs.getString("name"));
					session.setAttribute("EMAIL",rs.getString("email"));
					
					RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
					
					rd.include(req, resp);
					
				}
				else
					
				{
					
					out.print("<h3 style= 'color:red'>Email id and password didnot match</h3>");
					RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
					rd.include(req, resp);
				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				out.print("<h3 style= 'color:red'> Error :: "+e.getMessage()+"</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
			}
		
	
	}

}
