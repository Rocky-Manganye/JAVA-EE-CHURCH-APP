
<%@page import="rocksta.donation.Donation"%>
<%@page import="java.util.ArrayList"%>
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
        <%
            User user = (User) request.getAttribute("user");
            ArrayList<Donation> list = (ArrayList<Donation>) request.getAttribute("donations");
            java.util.Date date = new java.util.Date();
        %>
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
                    <h1 class="color-green pull-left">MEMBER</h1>
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
                        <h1>PROFILE</h1>
                        <input readonly="" type ="text" class="form-control alert-danger" name ="name" value = <%=user.getName()%> >
                        <input type ="text" readonly class="form-control alert-danger" name ="id" value = <%=user.getId()%> >
                        <input readonly type ="text" class="form-control alert-danger" name ="surname" value = <%= user.getSurname()%>>
                        <input readonly type ="text" class="form-control  alert-danger" name ="gender" value = <%=user.getGender()%>>
                        <input value = "<%= user.getAccountNumber()%>" readonly="" class="form-control alert-danger" name ="accnum">
                        <input type ="text" class="form-control" name ="email" value = <%=user.getEmail()%>>            
                        <input type ="text" class="form-control" name ="uname" value = <%=user.getUsername()%>>

                        <input type ="password" class="form-control" name ="psw" value = <%=user.getPassword()%>>                        

                        <input value="<%=user.getRole()%>" class="form-control alert-danger" type="text" readonly="">

                    </div>
                    <div id="tabs-2"> 
                        <div class="row">
                            <div class="col-lg-4">
                                <h1>DONATE  </h1>
                                <form action="" method="POST">
                                    <label class="form-control">Account Number</label>
                                    <input type="text" value="<%= user.getAccountNumber()%>" readonly="" class="form-control" name="account">                    
                                    <label class="form-control">Project Name</label>
                                    <select class="form-control" name="Project" required="">
                                        <%
                                            ArrayList<String> projects = (ArrayList<String>) request.getAttribute("projects");
                                            for (int x = 0; x < projects.size(); ++x) {
                                                String[] data = projects.get(x).split("@");
                                        %>
                                        <option value="<%= data[1]%>"><%= data[1]%></option>
                                        <%
                                            }
                                            request.setAttribute("user", user);
                                        %>
                                    </select>
                                    <label class="form-control">Amount</label>
                                    <input type="number"  class="form-control" name="amount" required="">  

                                    <label class="form-control">Description</label>
                                    <input type="text"  class="form-control" name="description" required="">     
                                    <input type ="hidden" class="form-control" name ="uname" value = <%=user.getUsername()%>>
                                    <input type ="hidden" class="form-control" name ="psw" value = <%=user.getPassword()%>>

                                    <input name="selection" value="Donate to project" type="submit" class="btn btn-danger">
                                </form>
                            </div>
                            <div class="col-lg-4">
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
                                                if (elements[1].equalsIgnoreCase(user.getAccountNumber())) {
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
                            </div>
                        </div>
                    </div>
                    <div id="tabs-3">   
                        <div class="row">
                            <div class="col-lg-4">
                                <form action="management.do.system" method="POST">
                                    <h1>TITHE</h1>
                                    <label class="form-control">Account Number </label>
                                    <input name="account" value="<%= user.getAccountNumber()%>" readonly="" class="form-control">
                                    <label class="form-control">Enter Amount to Tithe (R)</label>
                                    <input type="number" class="form-control" name="amount" required placeholder="Enter Amount to Tithe" maxlength=""> 

                                    <label class="form-control">Current Date And Time</label>
                                    <input name="date" type="text" value="<%= date.toString()%>" class="form-control" readonly="">
                                    <input type ="hidden" class="form-control" name ="uname" value = <%=user.getUsername()%>>
                                    <input type ="hidden" class="form-control" name ="psw" value = <%=user.getPassword()%>>
                                    <tr> 
                                    <input name="selection" value="Tithe" type="submit" class="btn btn-primary">
                                </form> 
                            </div>
                            <div class="col-lg-4">


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
                            </div>
                        </div>
                    </div>

                </div>


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
