<%-- 
    Document   : removeListing
    Created on : Feb 27, 2022, 8:33:52 PM
    Author     : strix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Listing</title>
        <style><%@include file="/WEB-INF/style.css"%></style>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
<body>
    
        <header>
            <a class="logos"><%out.println(getServletContext().getInitParameter("Header-Value1"));%></a>
            <ul class="right">
            <li><a href="<%=request.getContextPath()%>/registeredUser/addListing.jsp"><%out.println(getServletContext().getInitParameter("Header-Value4"));%></a></li>
            <li><a href="<%=request.getContextPath()%>/registeredUser/removeListing.jsp"><%out.println(getServletContext().getInitParameter("Header-Value5"));%></a></li>
            <li><a href="<%=request.getContextPath()%>/registeredUser/updateListing.jsp"><%out.println(getServletContext().getInitParameter("Header-Value6"));%></a></li>
            </ul>            
        </header>
                <% 
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                
                if(session.getAttribute("username") == null)
                {
                    response.sendRedirect("listings.jsp");
                } 
                %>            
  <div class="container">
    <div class="title">DB Registration</div>
    <div class="content">
      <form action="<%=request.getContextPath()%>/RemoveProduct" method="POST">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Database ID:</span>
            <input type="text" placeholder="Enter Database  ID" name="dormID" required>
          </div>

        </div>
        <div class="button">
          <input type="submit" value="Remove Listing">
        </div>
       </form>
        <form action="${pageContext.request.contextPath}/Logout">

            <button><input type="submit" value="Logout"></button>
        </form>
    </div>

</body>
</html>
