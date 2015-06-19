
<%@page import="rocksta.user.User"%>
<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7"> <![endif]-->
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->

    <head>

        <title>LightHouse Chapel International</title>

        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/style-menu.css">
        <!-- <link rel="stylesheet" href="/css/bootstrap-responsive.min.css"> -->
        <!-- <link rel="stylesheet" href="/css/style_responsive.css"> -->
        <link rel="stylesheet" href="css/site.css">

    </head>

    <body>
        <!--=== Top ===-->
        <div id="top">
            <div class="container">
            </div>
        </div>
        <!--/top-->

        <!--=== Header ===-->
        <div id="header">
            <div class="container">

                <!-- Menu -->
                <div class="navbar navbar-default">
                    <div class="navbar-header">
                        <a class="btn navbar-btn navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="glyphicon glyphicon-bar"></span>
                            <span class="glyphicon glyphicon-bar"></span>
                            <span class="glyphicon glyphicon-bar"></span>
                        </a>
                        <!-- Logo -->
                        <div id="logo">
                            <a href="#">LightHouse Chapel International</a>
                            <div class="sublogo">LCI</div>
                        </div>
                        <!-- /logo -->
                    </div>
                    <!-- /navbar-header -->
                    <!-- /nav-collapse -->
                    <div>
                        <ul class="nav navbar-nav navbar-right navbar-collapse collapse top-2">
                           
                              <li class='active'><a href='index.html' class="navbar-btn btn btn-warning">LOGOUT</a>
                            </li> 
                            <li class='active'> <a href ="admin-reg-management.jsp" class =" navbar-btn btn btn-info">Register Management</a>
                            </li> 
                        </ul>
                    </div>
                    <!-- /nav-collapse -->
                </div>
                <!-- /navbar -->

            </div>
            <!-- /container -->
        </div>
        <!-- /header -->

        <!--=== Content part ===-->
        <div id="body">
            <div class="breadcrumbs margin-bottom-20">
                <div class="container">
                    <h1 class="color-green pull-left">ADMINISTRATION</h1>
                </div>
                <!--/container-->
            </div>
            <!--/breadcrumbs-->
            <div class="container">
               <form action="management.do.system" method="POST">
            <table class ="table table-bordered table-responsive">
                <thead class = "text-danger text-justify">
                    <tr class ="alert-success">
                        <td>Select User</td>
                        <td>Name</td>
                        <td>Surname</td>
                        <td>Gender</td>                        
                        <td>Username</td>
                        <td>Email Address</td>
                        <td>Account Number</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                        java.util.ArrayList<User> users = (java.util.ArrayList<User>) request.getAttribute("users");
                        for (User user : users) {
                    %>
                    <tr>
                        <td>
                            <input type = "radio" class="radio-inline" name ="userid" value ="<%= user.getId()%>" >
                        </td>
                        <td>
                            <%= user.getName()%>
                        </td>
                        <td>
                            <%= user.getSurname()%>
                        </td>
                        <td>
                            <%= user.getGender()%>
                        </td>

                        <td>
                            <%= user.getUsername()%>
                        </td>
                        <td>
                            <%= user.getEmail()%>
                        </td>
                        <td>
                            <%= user.getAccountNumber()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
                <tfoot>
                    <tr class = "well alert-warning">
                        <td>
                            Total Number of Users in the system : <%= users.size()%>
                        </td>
                    </tr>

                </tfoot>
            </table>
            <div class ="btn-group-lg ">
                <input type = "submit" class="btn btn-primary" name="selection" value="Update User Information">
                <input type = "submit" class="btn btn-danger" name="selection" value="Delete">
            </div>
        </form>
            </div>
                <!--/container-->
            </div>
            <!--/footer-->

            <!--=== copyright ===-->
            <div class="copyright">
                <div class="container">

                    <div class="row">
                        <div class="col-md-8">
                            <p>2001-2015 &copy; LCI. ALL Rights Reserved.</p>
                        </div>
                    </div>
                    <!--/row-->

                </div>
                <!--/container-->
            </div>
            <!--/copyright-->

            <!-- JS and jQuery -->
            <script type="text/javascript" src="/js/jquery-2.0.0.min.js"></script>
            <script type="text/javascript" src="/js/bootstrap.min.js"></script>

            <!-- Our Code -->
            <script type="text/javascript" src="/js/wildermuth.min.js"></script>



    </body>

</html>
