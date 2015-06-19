<%@page import="java.util.ArrayList"%>
<%@page import="rocksta.donation.Donation"%>
<%@page import="rocksta.user.User"%>
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
                    <a href ="index.html" class = "navbar-brand  btn btn-danger" >Logout</a>
                    </div><!-- End of navbar header-->

            </div><!--End of Container -->
        </nav><!--End of nav bar -->
        <div class = "jumbotron">
            <div class = "container text-center" style = "height:30px">
                <h3>User Portal</h3>
                <p><small>Welcome </small></p>
            </div>
        </div><!--End of jumbotron-->	
            <table class="table-condensed">
                <tr>
                  <td>
                       <%
                            String account = (String)request.getAttribute("account");
                            String id = (String)request.getAttribute("id");
                       %>
                       <form action="management.do.system" method="POST">                          
                                    <tr>
                                      <td><label for="account">Account Number</label></td>
                                      <td><input class="form-control alert-info" name="accnumber" value="<%= account.trim() %>"></td>
                                    </tr>
                                    <tr>
                                      <td><label for="id">ID Number</label></td>
                                      <td><input class="form-control alert-info" name="id" value="<%=id.trim()%> "></td>
                                    </tr>
                                    <tr>
                                      <td><label for="amount">Amount to donate</label></td>
                                      <td><input class="form-control alert-info" name="amount"></td>
                                    </tr>
                                    <tr>                            
                                        <td><input class="btn btn-danger" name="selection" value="Donate" type="submit"></td>
                                    </tr>
                                </form>
                        </tbody>
                      </table>
                  </td>
                </tr>
            </table> 
              <div id="side" >
                  <table class ="table" >
                     
                  </table>
              </div>
   </div>
        </div>
        <div class = "jumbotron">
                     <div class = "container text-center" style = "height:10px">
                     <small>Rocksta Creations Copy right</small>		
               </div>
        </div><!--End of jumbotron-->

        <div class = "container">	
            <div id = "main_content">
        </div>                                                
    </div>
  <script src = "js\jquery-1.11.1.min.js"></script>
  <script src = "js\bootstrap.min.js"></script>
                                        
  </body>

  </html>ml>
