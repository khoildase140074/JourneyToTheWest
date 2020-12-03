<%-- 
    Document   : insertuser
    Created on : Jul 20, 2020, 3:48:09 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

            <section class="signup">
                <!-- <img src="images/signup-bg.jpg" alt=""> -->
                <div class="container">
                    <div class="signup-content">
                        <s:form action="InsertUserAction" method="POST" class="signup-form">
                            <h1 class="form-title">Register Page</h1>
                            <div class="form-group">
                                <s:textfield name="username" class="form-input"
                                             id="name"
                                             placeholder="Username"/>
                            </div>
                            <s:if test="%{exception.message.indexOf('duplicate') > -1}">
                                <font color ="red">
                                <s:property value="username"/> is existed!
                                </font>
                            </s:if>
                            <div class="form-group">
                                <s:password name="password" class="form-input"
                                            id="password"
                                            placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <s:password name="confirm" class="form-input"
                                            id="password"
                                            placeholder="ConfirmPassword"/>
                            </div>
                            <div class="form-group">
                                <s:textfield name="fullname" class="form-input"
                                             id="name"
                                             placeholder="Fullname"/>
                            </div>
                            <s:combobox name="role" 
                                        headerValue="--- Please Select Role ---"
                                        headerKey="1" list="{'actor','director'}" />
                            <div class="form-group">
                                <s:textfield name="phone" class="form-input"
                                             id="name"
                                             placeholder="Phone"/>
                            </div>

                            <div class="form-group">
                                <s:textfield name="email" class="form-input"
                                             id="name"
                                             placeholder="Email"/>
                            </div>

                            <div class="form-group">
                                <s:textfield name="image" class="form-input"
                                             id="name"
                                             placeholder="Image"/>
                            </div>

                            <div class="form-group">
                                <s:textfield name="description" class="form-input"
                                             id="name"
                                             placeholder="Description"/>
                            </div>
                            <div class="form-group">
                                <s:submit value="Insert" id="submit" class="form-submit" />
                            </div>
                        </div>
                    </div>
                </section>
            </div>

            <!-- JS -->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="js/main.js"></script>
        </s:form>
    </body>
</html>
