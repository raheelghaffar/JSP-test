package org.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class Testingproject
 */
@WebServlet(name = "Testingprojectservlet", urlPatterns = { "/Testingprojectservlet" })
public class Testingproject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    //response.setContentType("text/html");
		
		
		PrintWriter Writer = response.getWriter();
	    
		String name = request.getParameter("name").toString();
		String password=request.getParameter("password").toString();
		String email=request.getParameter("email").toString();
		/* for session and context 
		if(name!= " " &&name!=null){
		session.setAttribute("savedname", name);
		context.setAttribute("savedname", name);
		}
		*/
		/*
		Writer.println("<h3>ID<h3>" + name);
		Writer.println("<h3>password<h3>" + password);
		Writer.println("<h3>email<h3>" + email);
	   */
		try{
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
				
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr","University13");
			 Statement st=con.createStatement();
			 ResultSet rs;
			 //PreparedStatement pst =(PreparedStatement) con.prepareStatement("INSERT INTO login VALUES ( '"+name+"', '"+password+"' , '"+email+"')");
			 
			 PreparedStatement pst =(PreparedStatement) con.prepareStatement("INSERT INTO login VALUES ( ?,?,?)");
			 
			 pst.setString(1, name);
			 pst.setString(2, password);
			 pst.setString(3, email);
			 
			 //int i =st.executeUpdate("INSERT INTO login VALUES ( '"+name+"', '"+password+"' , '"+email+"')");
			 
		       int i=pst.executeUpdate();
		       ///con.commit();
			    rs=pst.executeQuery();
			   
			    RequestDispatcher rd= request.getRequestDispatcher("WelcomeR.html");
			    rd.forward(request, response);
			
			    
			    
			 //ResultSet rs=st.executeQuery();
			 /*
			 while(rs.next()){
				 System.out.println(rs.getString(1)+" "+rs.getString(2)+rs.getString(3));
			 
			 }
			 */
			 
			 
			 
			 con.close();
			    
			 }
			 catch(Exception e){
			System.out.print(e);
			 }

		 }
}

	


