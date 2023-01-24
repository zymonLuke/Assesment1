<%-- 
    Document   : result
    Created on : Feb 24, 2022, 7:58:28 PM
    Author     : strix
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
        <style><%@include file="/WEB-INF/style.css"%></style>
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
                
            <%  ResultSet output = (ResultSet)request.getAttribute("userOutput");
                while (output.next()){
            %>        
            
    <div class="title">Required Details</div>
    <div class="content">
      <form>

        <div class="user-details">
          <div class="input-box">
            <span class="details">Dormitory Name:</span>
                <p><%=output.getString("dorm_name")%></p><br>
          </div>
                  <div class="input-box">
            <span class="details">Dormitory Name:</span>
                <p><%=output.getString("dorm_name")%></p><br>
          </div>  <div class="input-box">
            <span class="details">City Location:</span>
                <p><%=output.getString("dorm_city")%></p><br>
          </div>
          <div class="input-box">
            <span class="details">Full Address:</span>
                <p><%=output.getString("dorm_address")%></p><br>
          </div>
          <div class="input-box">
            <span class="details">Room Price:</span>
                <p><%=output.getString("room_price")%></p><br>
          </div>
          <div class="input-box">
            <span class="details">Bed Space:</span>
                <p><%=output.getString("bed_space")%></p><br>
          </div>
          <div class="input-box">
            <span class="details">Contact Number:</span>
                <p><%=output.getString("dorm_contact")%></p><br>
          </div>
          <div class="input-box">
            <span class="details">Dormitory Image:</span>
                <img class="dormImage" src="<%=output.getString("image_link")%>" width="200px" height="150px" alt="alt"/>
          </div>

      </form>

    </div>
  </div>
       
            <%}%>
  
        
        <footer>
            <ul class="footern">
                <li><%out.println(getServletContext().getInitParameter("Footer-Value1"));%></li>
            <li><%out.println(getServletContext().getInitParameter("Footer-Value2"));%></li>
            </ul>            
        </footer>  
    </body>
</html>

