
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
                    <h1 class="color-green pull-left"> <div class="headline"><h3>Create New Project</h3></div></h1>
                </div>
                <!--/container-->
            </div>
            <!--/breadcrumbs-->
            <div class="container">
                <div class="row blog-page">
                    <!-- Left Sidebar -->
                    <div class="col-md-9">
                       
                        <div class="blog margin-bottom-30">

                            <div class="blog-short">
                               
                                
                            <form class="form_settings" method="POST" action="management.do.system">
                                <input type="text" class="form-control" name="proj_name" placeholder="Enter the project name" id='proj_name' required="">
                                <select name="start_day" id='proj_start_day' class="form-control">
                                    <option>Project Start Day</option>
                                    <%
                                        for (int x = 1; x < 32; x++) {
                                    %>
                                    <option value="<%= x%>"><%= x%></option>
                                    <%
                                        }
                                    %>
                                </select>

                                <select name="start_month" id="proj_start_month" class="form-control" required="">
                                    <option>Project Start Month</option>                            
                                    <option value="1">January</option>
                                    <option value="2">February</option>
                                    <option value="3">March</option>
                                    <option value="4">April</option>
                                    <option value="5">May</option>
                                    <option value="6">June</option>
                                    <option value="7">July</option>
                                    <option value="8">August</option>
                                    <option value="9">September</option>
                                    <option value="10">October</option>
                                    <option value="11">November</option>
                                    <option value="12">December</option>
                                </select>

                                <select name="start_year" id="proj_start_year" class="form-control" required="">
                                    <option>Project Start Year</option>
                                    <option value="2015">2015</option>   
                                    <option value="2015">2016</option>   
                                    <option value="2015">2017</option>   
                                </select>

                                <br>

                                <select name="end_day" id='proj_end_day' class="form-control" required="">
                                    <option>Project End Day</option>
                                    <%
                                        for (int x = 1; x < 32; x++) {
                                    %>
                                    <option value="<%= x%>"><%= x%></option>
                                    <%
                                        }
                                    %>
                                </select>

                                <select name="end_month" id="proj_end_month" class="form-control" required="">
                                    <option>Project End Month</option>                            
                                    <option value="1">January</option>
                                    <option value="2">February</option>
                                    <option value="3">March</option>
                                    <option value="4">April</option>
                                    <option value="5">May</option>
                                    <option value="6">June</option>
                                    <option value="7">July</option>
                                    <option value="8">August</option>
                                    <option value="9">September</option>
                                    <option value="10">October</option>
                                    <option value="11">November</option>
                                    <option value="12">December</option>
                                </select>

                                <select name="end_year" id="proj_end_year" class="form-control" required="">
                                    <option>Project End Year</option>
                                    <option value="2015">2015</option>   
                                    <option value="2015">2016</option>   
                                    <option value="2015">2017</option>   
                                </select>
                                <br>
                                <input name="proj_cost" type="text" class="form-control" placeholder="Enter the cost of the project" required="">
                                <br>

                                <input type="submit" name="selection" class="btn btn-danger" value="Create New Project">                     
                            </form>     

                            </div>
                        </div>
                


                        <!--/span4-->
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
