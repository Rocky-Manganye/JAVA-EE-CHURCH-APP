<%@page import="rocksta.user.User"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>App</title>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
        <link rel="stylesheet" href="css/themes/default/jquery.mobile-1.4.5.min.css">

        <script src="js/jquery.min.js"></script>
        <script src="_assets/js/index.js"></script>
        <script src="js/jquery.mobile-1.4.5.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css.map">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <style>
            #edit-with-js-bin { display: none !important; }
        </style>
    </head>
    <body>

        <div data-role="page" id="one">

            <div data-role="header">
                <h1>

                    MANAGEMENT PANEL
                </h1>
            </div><!-- /header -->
            <div role="main" class="ui-content">                         

                <table class="table-responsive" id="table-column-toggle">
                    <%
                        User searchuser = (User) request.getAttribute("searchuser");
                        if (searchuser != null) {
                    %>
                    <h3> VIEW PROFILE</h3>
                    <table class="table-condensed">
                        <tr><th>Name</th><th><input readonly="" type ="text" class="form-control alert-danger" name ="name" value = <%=searchuser.getName()%> ></th>
                            <th>ID Number</th><th><input type ="text" readonly class="form-control alert-danger" name ="id" value = <%=searchuser.getId()%> ></th> </tr>
                        <tr><th>Surname</th><th><input readonly type ="text" class="form-control alert-danger" name ="surname" value = <%= searchuser.getSurname()%>></th>
                            <th>Gender</th><th> <input readonly type ="text" class="form-control  alert-danger" name ="gender" value = <%=searchuser.getGender()%>> </th> </tr>
                        <tr><th>Account Number</th><th>  <input value = "<%= searchuser.getAccountNumber()%>" readonly="" class="form-control alert-danger" name ="accnum"></th> 
                            <th>Email Address</th> <th><input type ="text" class="form-control alert-danger" name ="email" value = <%=searchuser.getEmail()%>></th></tr>               
                        <tr><th>Username</th> <th><input type ="text" class="form-control" name ="uname" value = <%=searchuser.getUsername()%>></th>

                            <th>Password</th><th><input type ="hidden" class="form-control" name ="psw" value = <%=searchuser.getPassword()%>></th></tr>
                        <tr> <th>Role</th><th>

                                <input value="<%=searchuser.getRole()%>" class="form-control alert-danger" type="text" readonly="">

                    </table>
                    <%} else {%>
                    USER NOT FOUND
                    <%}%>
            </div>  

            <div data-role="footer" data-theme="a">
                <h4>Page Footer</h4>
            </div><!-- /footer -->
        </div><!-- /page one -->
    </div>
    <div data-role="footer" data-position="fixed" data-tap-toggle="false" class="jqm-footer">
        <p>Power by  jQuery Mobile<span class="jqm-version"></span></p>                    
    </div><!-- /footer -->
</body>
</html>
