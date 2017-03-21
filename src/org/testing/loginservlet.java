package org.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

import oracle.jdbc.*;
/**
 * Servlet implementation class loginservlet
 */
@WebServlet(name ="login" , urlPatterns = { "/loginpath" })
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter Writer = response.getWriter();
		String name = request.getParameter("name").toString();
		
		String password=request.getParameter("password").toString();
		/*
		String email=request.getParameter("email").toString();
		*/
		/*try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr","University13");
		
		// String sql="select * from login where ID='"+name+"'";
		
		 
		 
		 Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select * from login where ID=?' and password=?");
           */ 
                
         if(validate.checkUser(name,password))
         {
             System.out.println(name);
             
             HttpSession session=request.getSession();  
             session.setAttribute("name",name);  
        	  response.sendRedirect("homepage.jsp");
             /*
             RequestDispatcher rs = request.getRequestDispatcher("homepage.jsp");
             rs.forward(request, response);
             */
             
         }
         else
         {
            System.out.println("Invalid ID");
            RequestDispatcher rs = request.getRequestDispatcher("invalidlogin.html");
            
            
            rs.include(request, response);
            
            Writer.close();  
         }
        	
                
               
         
                	
        
             
         /*
             response.sendRedirect("WelcomeL.html"); 
             
             RequestDispatcher rd=request.getRequestDispatcher("WelcomeL.html");
			 rd.forward(request,response);
             
           
		 
             PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
		  ResultSet rs= (ResultSet) pst.executeQuery();
		  
		     if(rs.getString(1)!=" "){
		    	 System.out.println("invalid Login");
			//System.out.println(rs.getString(1)+" "+rs.getString(2)+rs.getString(3));
		     }
		     else{
		    	 
		    	
		    	 RequestDispatcher rd=request.getRequestDispatcher("WelcomeL.html");
				 rd.forward(request,response);
		     }
		
		 
		
             
            
		 con.close();
		    
		 }
		 catch(Exception e){
		System.out.print(e);
		 }
		}
*/
}}
