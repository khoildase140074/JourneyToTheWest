<%-- 
    Document   : updatescene
    Created on : Jul 15, 2020, 2:14:26 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
        <title>JSP Page</title>
        <s:head/>
        <sx:head/>
    </head>
    <body>
        <div class="main">

            <div class="container">
                <div class="signup-content">
                    <s:form action="UpdateSceneAction" method="POST" id="signup-form" class="signup-form">
                        <h2>Update Scene</h2>
                        <div class="form-group">
                            <s:textfield name="id" label="SceneId" value="%{#session.DTO.Id}" readonly="true" class="form-input"
                                         id="name"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="name" label="SceneName" class="form-input"
                                         id="name"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="description" label="Description" class="form-input"
                                         id="name"/>
                        </div>
                        <div class="form-group">
                            <s:textfield name="location" label="Location" class="form-input"
                                         id="name"/>
                        </div>
                        <sx:datetimepicker name="starttime" displayFormat="yyyy-MM-dd" label="StartTime"/>
                        <sx:datetimepicker name="endtime" displayFormat="yyyy-MM-dd" label="EndTime"/>
                        <div class="form-group">
                            <s:textfield name="record" label="Record" class="form-input"
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
