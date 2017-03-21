<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="welcomestyle.css" rel=stylesheet />
</head>
<body>


        
<ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="rent.jsp">Rent</a></li>
  <li><a href="#contact">Check</a></li> 
  <li><a href= "index.html">Logout</a></li> 
</ul>
 
  <div class="container">
 <h1>MR. <%=session.getAttribute("name").toString() %></h1>
 <br>
 <h1> Welcome to Rent check go</h1> 
</div>

</body>

</html>
