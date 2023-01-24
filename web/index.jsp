
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <style><%@include file="/WEB-INF/style.css"%></style>
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
    </head>
          
    <body>
    <div class="container">
        <header>
            <a class="logos"><%out.println(getServletContext().getInitParameter("Header-Value1"));%></a>
            <ul class="right">
            <li><a href="index.jsp"><%out.println(getServletContext().getInitParameter("Header-Value2"));%></a></li>
            <li><a href="listings.jsp"><%out.println(getServletContext().getInitParameter("Header-Value3"));%></a></li>
            </ul>            
        </header>
            
            
    <div class="title">Required Details</div>
    <div class="content">
      <form method="POST" action="AppController">
        <div class="user-details">
          <div class="input-box">
            <span class="details">City Name</span>
            <input type="text" name="city" placeholder="Enter your City" required>
          </div>
          <div class="input-box">
            <span class="details">Bed Space</span>
            <input type="number" name="space" placeholder="Enter the number of Bed Space" required>
          </div>
          <div class="input-box">
            <span class="details">Minimum Budget</span>
            <input type="text" name="budget" placeholder="Enter your minimum" required>
          </div>
          <div class="input-box">
            <span class="details">Maximum Budget</span>
            <input type="text" name="budgetMax" placeholder="Enter your maximum" required>
          </div>

 
        <div class="button">
          <input type="submit" value="Search">
        </div>
      </form>
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
