<%-- 
    Document   : loginError
    Created on : Mar 3, 2022, 1:48:03 PM
    Author     : strix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Error Page</title>
        <style><%@include file="/WEB-INF/style.css"%></style>
    </head>
    <body>
        <div class="container">

        <header>
            <a class="logos"><%out.println(getServletContext().getInitParameter("Header-Value1"));%></a>
            <ul class="right">
            <li><a href="<%=request.getContextPath()%>/index.jsp"><%out.println(getServletContext().getInitParameter("Header-Value2"));%></a></li>
            <li><a href="<%=request.getContextPath()%>/listings.jsp"><%out.println(getServletContext().getInitParameter("Header-Value3"));%></a></li>
            </ul>            
        </header>
    
 
            <h2>Incorrect Credentials</h2>
            <img src="https://icon-library.com/images/error-icon-transparent/error-icon-transparent-5.jpg" class="image">
            <button><a href ="<%=request.getContextPath()%>/index.jsp">Back</button></a>
        
    </div>
            
        <footer>
            <ul class="footern">
                <li><%out.println(getServletContext().getInitParameter("Footer-Value1"));%></li>
            <li><%out.println(getServletContext().getInitParameter("Footer-Value2"));%></li>
            </ul>            
        </footer>   
    </body>
</html>
