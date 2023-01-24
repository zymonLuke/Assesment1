<%-- 
    Document   : error
    Created on : Feb 24, 2022, 8:45:55 PM
    Author     : strix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conection Error Page</title>
        <style><%@include file="/WEB-INF/style.css"%></style>
    </head>
    <body>
        <header>
            <a class="logos"><%out.println(getServletContext().getInitParameter("Header-Value1"));%></a>
            <ul class="right">
            <li><a href="<%=request.getContextPath()%>/index.jsp"><%out.println(getServletContext().getInitParameter("Header-Value2"));%></a></li>
            <li><a href="<%=request.getContextPath()%>/listings.jsp"><%out.println(getServletContext().getInitParameter("Header-Value3"));%></a></li>
            </ul>            
        </header>
            
        <div class="container">
            <div class="error">
                <img src="https://cdn0.iconfinder.com/data/icons/shift-free/32/Error-512.png" class="controller">
            <h1>Connection Error</h1>
            <button><a href ="<%=request.getContextPath()%>/index.jsp">Back</button></a>
            </div>
        </div>
            
        <footer>
            <ul class="footern">
                <li><%out.println(getServletContext().getInitParameter("Footer-Value1"));%></li>
            <li><%out.println(getServletContext().getInitParameter("Footer-Value2"));%></li>
            </ul>            
        </footer>   
    </body>
</html>
