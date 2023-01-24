<%-- 
    Document   : listings
    Created on : Feb 24, 2022, 4:00:39 PM
    Author     : strix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Listings Page</title>
        <style><%@include file="/WEB-INF/style.css"%></style>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
          
    <body>       
        <header>
            <a class="logos"><%out.println(getServletContext().getInitParameter("Header-Value1"));%></a>
            <ul class="right">
            <li><a href="index.jsp"><%out.println(getServletContext().getInitParameter("Header-Value2"));%></a></li>
            <li><a href="listings.jsp"><%out.println(getServletContext().getInitParameter("Header-Value3"));%></a></li>
            </ul>            
        </header>
            
            
        <div class="row">
        <form method="POST" action="Login">
            <label><h1>Username:</h1></label>
            <input type="text" name="Username" required>
            <label><h1>Password:</h1></label>
            <input type="password" name="Password" required>
            <button type="submit">Submit</button>
        </form>
        </div>
        
        <footer>
            <ul class="footern">
                <li><%out.println(getServletContext().getInitParameter("Footer-Value1"));%></li>
            <li><%out.println(getServletContext().getInitParameter("Footer-Value2"));%></li>
            </ul>            
        </footer>  
    </body>
</html>