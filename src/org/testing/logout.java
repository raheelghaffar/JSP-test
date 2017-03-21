package org.testing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        ;  
          
        HttpSession session=request.getSession();  
       if(session!=null){
    	   session.getAttribute("name");
    	   session.invalidate();
           response.sendRedirect("index.html");
              
       }
        //session.getAttribute("name");  
        //request.getRequestDispatcher("index.html").include(request, response) ;
        
        
        out.print("You are successfully logged out!");  
          
        out.close();  
	
	
	
	}

}
