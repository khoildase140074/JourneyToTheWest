<%-- 
    Document   : admin
    Created on : Jul 14, 2020, 3:03:18 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(https://wallpapercave.com/wp/wp2704824.jpg); background-size: cover" >
        <font color="red">
        <h1>Welcome <s:property value="%{#session.DTO.fullname}"/></h1>
        </font>
        <s:form action="MoveToAccountAction" method="POST">
            <s:submit value="Manage Account"/>
        </s:form>       
        <s:form action="MoveToSceneAction" method="POST">
            <s:submit value="Manage Scene"/>
        </s:form>
        <s:form action="MoveToToolAction" method="POST">
            <s:submit value="Manage Tool"/>
        </s:form>
        <s:a action="LogoutAction">LogOut</s:a>
    </body>
</html>
