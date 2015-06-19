<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Church Application</title>		
        <link href = "css\bootstrap.css" rel = "stylesheet" type = "text/css">
        <link href = "css\bootstrap.min.css" rel = "stylesheet" type = "text/css">
        <link href = "css\bootstrap-theme.css" rel = "stylesheet" type = "text/css">
        <link href = "css\bootstrap-theme.min.css" rel = "stylesheet" type = "text/css">
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
        <nav class = "navbar navbar-inverse navbar-fixed-top" id = "my-navbar" ><!--style= "padding-left:350px"-->
            <div class = "container">
                <div class = "navbar-header">
                    <button type = "button" class = "navbar-toggle" data-toggle ="collpase" data-target = "#navbar-collapse">
                        <span class = "icon-bar"></span>
                        <span class = "icon-bar"></span>						
                        <span class = "icon-bar"></span>						
                        <span class = "icon-bar"></span>						
                    </button>                    
                </div><!-- End of navbar header-->

            </div><!--End of Container -->
        </nav><!--End of nav bar -->
        <div class = "jumbotron">
            <div class = "container text-center" style = "height:30px">
                <h3>Registration form</h3>
                <p>
                    <small>Please fill in all the fields</small>
                </p>
            </div>
        </div><!--End of jumbotron-->
        <br><br>
        <div class = "container">	
          
                <form action = "management.do.system" method = "POST">	
                    <p>
                            <label for = "user_name" >Name</label>
                            <input  type = "text" name = "user_name" class = "form-control input-lg " placeholder = "enter your name (minimum of 2 characters)" id = "user_name" required autofocus ="" minlength="2">
                        </p>
                        <p>
                              <label for = "surname" >Surname</label>
                              <input type = "text" name = "usersurname" class = "form-control input-lg" placeholder = "enter your surname (minimum of 2 characters)" id = "usersurname" required minlength="2">
                       
                        </p>
                         <p>
                            <label for = "userid" >ID number</label>
                            <input type = "text" name = "user_id" class = "form-control input-lg" placeholder = "enter your id number (13 digits)" id = "userid" required minlength="13" maxlength="13">
                       
                         </p>
                         <p>
                            <label for="inputEmail">Email address</label>
                            <input type="email" id="inputEmail" class="form-control input-lg" placeholder="Email address" name = "useremail" required >                        
                        </p>
                         <p>
                            <label for = "username">Username</label>
                            <input type = "text" class = "form-control input-lg "  minlength="5" required id = "username" placeholder = "enter your username (minimum of 5 characters)" size = "20"  name = "username">
                         </p>
                       
                        <label for = "password">Password</label>
                        <input type ="password" class ="form-control input-lg" id = "password" placeholder="enter your password (minimum of 8 characters)" required name = "password"  minlength="5">
                        <br>
                                <input type = "submit" class = "btn btn-danger" name = "selection" value = "Register Management">					
                                </form>
                              

                                </div>
                             
                                
                                <script src = "js\jquery-1.11.1.min.js"></script>
                                <script src = "js\bootstrap.min.js"></script>
                                <script>
                                    $("document").ready(function () {
                                        $("form").validate();
                                    })
                                </script>
                                </body>

                                </html>