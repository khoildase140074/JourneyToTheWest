<%-- 
    Document   : error
    Created on : Jul 14, 2020, 4:19:22 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>ERROR PAGE</h1>
        <h1><s:property value="%{#request.ERROR}"/></h1>
    </body>
</html>
