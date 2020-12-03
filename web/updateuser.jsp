<%-- 
    Document   : update
    Created on : Jul 14, 2020, 5:15:55 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
        <s:head/>
    </head>
    <body>
        <div class="main">

            <div class="container">
                <div class="signup-content">
                    <s:form action="UpdateUserAction" method="POST" id="signup-form" class="signup-form">
                        <h1>Update User</h1>
                        <div class="form-group">
                            <s:textfield name="username" label="Username" readonly="true" value="%{#session.DTO.username}" class="form-input"
                                         id="name"/>
                        </div>
                        <div class="form-group">
                            <s:password name="password" label="Password" class="form-input" id="password"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="fullname" label="Fullname" class="form-input"
                                         id="name"/>
                        </div>
                        <s:combobox label="Role" name="role" 
                                    headerValue="--- Please Select Role ---"
                                    headerKey="1" list="{'actor','director'}" />
                        <div class="form-group">
                            <s:textfield name="phonenumber" label="PhoneNumber" class="form-input"
                                         id="name"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="email" label="Email" class="form-input"
                                         id="name"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="image" label="Image" class="form-input"
                                         id="name"/> 
                        </div>
                        <div class="form-group">
                            <s:textfield name="description" label="Description" class="form-input"
                                         id="name"/>
                        </div>
                        <div class="form-group">
                            <s:submit value="Update" name="submit" id="submit" class="form-submit submit"/>
                        </div>
                    </s:form>
                </div>
            </div>

        </div>
        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
