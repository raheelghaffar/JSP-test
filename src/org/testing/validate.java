package org.testing;

import java.sql.*;
import oracle.jdbc.*;

public class validate
 {
     public static boolean checkUser(String name, String password)
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:orcl", "hr","University13");
         PreparedStatement ps =con.prepareStatement
                             ("select * from login where id=? and password=?");
         ps.setString(1, name);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}