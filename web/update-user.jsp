
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

         <script src = "js\jquery-2.1.3.min.js"></script>
        <script src = "js\jquery.validate.js"></script>
        <style>
            #main_content{float:left;margin-left : 250px;padding:10px;width:300px;}
            #side{float:left;padding:10px;width:602px;}		
        </style>
         <script>
            var require = {
                paths: {
                    "jquery": "js/jquery-1.11.1"
                }
            };
        </script>
        <script src="js/require.js" data-main="js/app.js"></script>
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
                    <h1 class="color-green pull-right">Update User Information</h1>
                </div>
                <!--/container-->
            </div>
            <!--/breadcrumbs-->
            <div class="container">
                <div class="row blog-page">
                    <!-- Left Sidebar -->
                    <div class="col-md-9">
                        <div>

                        </div>
                        <hr />
                        <!--/blog-->
                        <div class="blog margin-bottom-30">

                            <div class="blog-short">
                                <form action = "management.do.system" method ="POST">
                                    <table class="table-striped table table-responsive">
                                        <%
                                            User user = (User) request.getAttribute("user");
                                        %>
                                        <tr><th>Name</th><th><input  type ="text" class="form-control  glyphicon glyphicon-zoom-in" name ="name" value = <%=user.getName()%> required="true"></th> </tr>
                                        <tr><th>ID Number</th><th><input type ="text" class="form-control" name ="id" value = <%=user.getId()%> readonly></th> </tr>
                                        <tr><th>Surname</th><th><input type ="text" class="form-control" name ="surname" value = <%= user.getSurname()%>></th> </tr>
                                        <tr><th>Gender</th><th> <input readonly type ="text" class="form-control" name ="gender" value = <%= user.getAccountNumber()%>> </th> </tr>
                                        <tr><th>Account Number</th><th>  <input value = "<%=user.getGender()%>" readonly="" class="form-control" name ="accnum"></th> </tr>
                                        <tr><th>Email Address</th> <th><input type ="text" class="form-control" name ="email" value = <%=user.getEmail()%>></th></tr>               
                                        <tr><th>Username</th> <th><input type ="text" class="form-control" name ="username" value = <%=user.getUsername()%>></th>
                                        </tr><tr><th>Password</th><th><input type ="password" class="form-control" name ="password" value = <%=user.getPassword()%>></th></tr>
                                        <tr> <th>Role</th><th>
                                                <select name ="role" class="form-control">
                                                    <option value="<%=user.getRole()%>"><%=user.getRole()%></option>
                                                    <option value="management">Management</option>
                                                    <option value="member">Member</option>
                                                    <option value="admin">Administrator</option>
                                                </select></table>
                                    <input type ="submit" class=" form-control btn btn-danger" name ="selection" value = "Update">
                                </form>
                            </div>
                        </div>
                        <hr />
                    </div>
                    <div class="col-md-3">

                    </div>
                    <!--/row-->

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
