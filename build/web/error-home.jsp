<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Error!</h1>
        
        <%
            Exception ex = (Exception)request.getAttribute("error");
         %>
         
         <label> <%
                    ex.printStackTrace();
                    
         %>
         
         <%=  ex.getLocalizedMessage()%>
         <%=  ex.getCause()%>
         </label>
        
                 
    </body>
</html>
