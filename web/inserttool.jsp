<%-- 
    Document   : inserttool
    Created on : Jul 15, 2020, 3:23:47 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <div class="main">

            <div class="container">
                <div class="signup-content">
                    <s:form action="InsertToolAction" method="POST" id="signup-form" class="signup-form">
                        <h2>Insert Tool</h2>
                        <div class="form-group">
                            <s:textfield name="id" label="ToolId"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="name" label="ToolName"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="description" label="Description"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="image" label="Image"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="quantity" label="Quantity"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="status" label="Status"/>
                        </div>
                        <div class="form-group">
                            <s:submit value="Add" name="submit" id="submit" class="form-submit submit"/>
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
