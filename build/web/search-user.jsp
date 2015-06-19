
<%@page import="java.util.Vector"%>
<%@page import="rocksta.donation.Donation"%>
<%@page import="java.util.ArrayList"%>
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
                    <%User user = (User) session.getAttribute("user");

                                %>
                    <div>
                        <ul class="nav navbar-nav navbar-right navbar-collapse collapse top-2">
                             
                            <li class='active'><form action="management.back">
                                <input name = "back" class="navbar-btn btn btn-warning" type="Submit" value="Back">
                                
                                <input type ="hidden" class="form-control" name ="uname" value = <%=user.getUsername()%>>
                                <input type ="hidden" class="form-control" name ="psw" value = <%=user.getPassword()%>>
                                </form></li>
                            <li class='active'><a href='index.html' class="navbar-btn btn btn-warning">LOGOUT</a>
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

            <!--/breadcrumbs-->
            <div class="container">
                <div class="row blog-page">
                    <!-- Left Sidebar -->
                    <div class="col-md-9">
                        <div class="blog-short margin-bottom-30">
                            <div class="headline">
                                
                                <h3>SEARCH MEMBER BY ACCOUNT NUMBER</h3>
                            </div>
                            <form action="search.do">
                                <input name = "acc" class="form-control glyphicon glyphicon-search" type="search" placeholder="enter member account" required="">
                                <br><br><input class="btn btn-success" type="submit" value="Search For Member">
                                <input type ="hidden" class="form-control" name ="uname" value = <%=user.getUsername()%>>
                                <input type ="hidden" class="form-control" name ="psw" value = <%=user.getPassword()%>>
                            </form>
                        </div>

                    </div> 
                    <!--/span4-->
                    <div class="col-md-9">
                        <div class="blog-short margin-bottom-30">
                            <%User user2 = (User) session.getAttribute("userResults");
                                if (user2 != null) { %>

                            <div class="headline">                                   
                                <h3>SEARCH RESULTS</h3>
                            </div>
                            <hr>
                            <%
                                ArrayList<Donation> list = (ArrayList<Donation>) request.getAttribute("donations");
                                java.util.Date date = new java.util.Date();
                            %>

                            <h1>Tithe Record</h1>
                            <table  class = "table table- table-bordered">
                                <thead class="alert-success">
                                    <tr>
                                        <th> Tithe Amount</th>
                                        <th>Tithe Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (int x = 0; x < list.size(); ++x) {
                                    %>
                                    <tr>
                                        <th><%= list.get(x).getAmount()%> </th>
                                        <th><%= list.get(x).getDate()%></th>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>  
                            <hr>
                            <h1>MY DONATION RECORD</h1>
                            <table class="table table- table-bordered">                    
                                <tr class="alert-danger">
                                    <td>Donation Number</td>
                                    <td>Account Number</td>
                                    <td>Donated Amount</td>
                                </tr>
                                <%
                                    request.setAttribute("logged", user);
                                    Vector<String> data1 = (Vector<String>) request.getAttribute("dons");
                                    if (!data1.isEmpty()) {
                                        for (int x = 0; x < data1.size(); ++x) {
                                            String elements[] = data1.get(x).split("@");
                                            if (elements[1].equalsIgnoreCase(user2.getAccountNumber())) {
                                %>
                                <tr>
                                    <td><%=elements[0]%></td>
                                    <td><%=elements[1]%></td>
                                    <td><%=elements[2]%></td>
                                </tr>
                                <%
                                            }
                                        }
                                    }
                                %>

                            </table>
                            <%}%>
                        </div>

                    </div>
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
