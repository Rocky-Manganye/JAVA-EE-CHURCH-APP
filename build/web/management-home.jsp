
<%@page import="rocksta.user.User"%>
<%@page import="java.util.Vector"%>
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
        <link rel="stylesheet" href="deck/core/deck.core.css">
        <link rel="stylesheet" href="deck/extensions/goto/deck.goto.css">
        <link rel="stylesheet" href="deck/extensions/menu/deck.menu.css">
        <link rel="stylesheet" href="deck/extensions/navigation/deck.navigation.css">
        <link rel="stylesheet" href="deck/extensions/status/deck.status.css">
        <link rel="stylesheet" href="deck/extensions/hash/deck.hash.css">
        <link rel="stylesheet" href="deck/extensions/clippy/deck.clippy.css">
        <link rel="stylesheet" href="deck/themes/style/custom.css">
        <link rel="stylesheet" href="deck/themes/transition/horizontal-slide.css">

        <script src="deck/modernizr.custom.js"></script>
        <script src="js/jquery-1.7.min.js"></script>
        <script src="deck/core/deck.core.js"></script>
        <script src="deck/extensions/hash/deck.hash.js"></script>
        <script src="deck/extensions/menu/deck.menu.js"></script>
        <script src="deck/extensions/goto/deck.goto.js"></script>
        <script src="deck/extensions/status/deck.status.js"></script>
        <script src="deck/extensions/navigation/deck.navigation.js"></script>
        <!-- <script src="deck/extensions/clippy/deck.clippy.js"></script> -->
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css" /> 
        <script type='text/javascript' src="js/image_slide.js"></script>
        <script type='text/javascript' src="js/bootstrap.js"></script>
        <script>
            $(function () {
                $("#tabs").tabs();
            });
        </script>

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
                        <br><br>
                        <ul class="nav navbar-nav navbar-right navbar-collapse collapse top-2">
                            <li class='active'>
                                
                                <a href='PrintMaleMembers' class="navbar-btn btn btn-warning">PRINT MEMBERS REPORT</a>
                            </li>
                            
                            <li class='active'>
                                
                                <a href='PrintProjects' class="navbar-btn btn btn-warning">PRINT PROJECTS REPORT</a>
                            </li>
                            <li class='active'>
                                
                                <a href='PrintTitheReport' class="navbar-btn btn btn-warning">PRINT TITHE REPORT</a>
                            </li>
                            <li class='active'>
                                
                                <a href='PrintDonations' class="navbar-btn btn btn-warning">PRINT DONATION REPORT</a>
                            </li>
                            <li class='active'>
                                
                                <a href='Send' class="navbar-btn btn btn-warning">Send Email</a>
                            </li>
                            <li class='active'><a href='create-project.jsp' class="navbar-btn btn btn-warning">Create Project</a>
                            </li> <li class='active'><a href='search-user.jsp' class="navbar-btn btn btn-warning">SEARCH USER</a>
                            </li> 
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
            <div class="breadcrumbs margin-bottom-20">
                <div class="container">
                    <h1 class="color-green pull-left">MANAGEMENT</h1>
                </div>
                <!--/container-->
            </div>
            <!--/breadcrumbs-->
            <div class="container">
                <div id="tabs">
                    <ul class="ui-tabs-nav">
                        <li><a href="#tabs-1">PROFILE</a></li>
                        <li><a href="#tabs-2">DONATIONS</a></li>
                        <li><a href="#tabs-3">TITHES</a></li>
                        <li><a href="#">_________________________________________________________</a></li>

                    </ul>
                    <div id="tabs-1"> 
                        <%
                            User user = (User) request.getAttribute("user");
                            if (user == null) {
                                user = (User) session.getAttribute("user");
                            }
                            session.setAttribute("user", user);
                        %>
                        <div class="headline">
                            <h3> USER PROFILE</h3>
                        </div>

                        <table class="table-condensed">
                            <tr><th>Name</th><th><input readonly="" type ="text" class="form-control alert-danger" name ="name" value = <%=user.getName()%> ></th>
                                <th>ID Number</th><th><input type ="text" readonly class="form-control alert-danger" name ="id" value = <%=user.getId()%> ></th> </tr>
                            <tr><th>Surname</th><th><input readonly type ="text" class="form-control alert-danger" name ="surname" value = <%= user.getSurname()%>></th>
                                <th>Gender</th><th> <input readonly type ="text" class="form-control  alert-danger" name ="gender" value = <%=user.getGender()%>> </th> </tr>
                            <tr><th>Account Number</th><th>  <input value = "<%= user.getAccountNumber()%>" readonly="" class="form-control alert-danger" name ="accnum"></th> 
                                <th>Email Address</th> <th><input type ="text" class="form-control alert-danger" name ="email" value = <%=user.getEmail()%>></th></tr>               
                            <tr><th>Username</th> <th><input type ="text" class="form-control" name ="uname" value = <%=user.getUsername()%>></th>

                                <th>Password</th><th><input type ="password" class="form-control" name ="psw" value = <%=user.getPassword()%>></th></tr>


                            <input value="<%=user.getRole()%>" class="form-control alert-danger" type="hidden" readonly="">
                        </table>
                    </div>
                    <div id="tabs-2">
                        <div class="headline"> <h3>DONATIONS</h3></div>

                        <table class="table table-responsive">
                                 <thead>
                                       <tr>
                                             <th data-priority="1">Donation Number</th>
                                             <th data-priority="2">Account Number</th>
                                             <th data-priority="3">Donation Amount</th>                                             
                                           </tr>
                                     </thead>
                            <tbody>
                                <%
                                    Vector<String> data1 = (Vector<String>) request.getAttribute("dons");
                                    if (!data1.isEmpty()) {
                                        for (int x = 0; x < data1.size(); ++x) {
                                            String elements[] = data1.get(x).split("@");
                                %>
                                <tr>
                                    <th><%=elements[0]%></th>
                                    <th><%=elements[1]%></th>
                                    <th><%=elements[2]%></th>
                                </tr>
                                <%
                                        }
                                    }
                                %>

                                 </tbody>
                                                </table>
                    </div>
                    <div id="tabs-3">

                        <div class="headline">
                            <h3>TITHE</h3>
                        </div>
                        <table class="table table-responsive">
                                 <thead>
                                       <tr>
                                             <th data-priority="1">Tithe Amount</th>
                                             <th data-priority="2"> Tithe Date</th>                                             
                                           </tr>
                                     </thead>
                            <tbody>
                                <%
                                    double total = 0.00;
                                    java.util.ArrayList<rocksta.donation.Donation> list = (java.util.ArrayList<rocksta.donation.Donation>) request.getAttribute("donations");
                                    if (!list.isEmpty()) {

                                        for (int x = 0; x < list.size(); ++x) {
                                            total += list.get(x).getAmount();
                                %>   
                                <tr>
                                    <th>
                                        <%= list.get(x).getAmount()%>
                                    </th>
                                    <th>
                                        <%= list.get(x).getDate()%>
                                    </th>
                                </tr>

                                <%
                                        }
                                    }
                                %>   

                                <tr>
                                    <th>Total User Tithe : <input class="form-control alert-success" type ="text" readonly="" value = "R <%= total%>"></th>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <br><br>
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
