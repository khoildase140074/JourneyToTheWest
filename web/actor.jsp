<%-- 
    Document   : actor
    Created on : Jul 14, 2020, 3:03:49 PM
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
    <body style="background-image: url(https://wallpapercave.com/wp/wp2704824.jpg); background-size: cover">
        <h1>Welcome <s:property value="%{#session.DTO.fullname}"/></h1>
        <table border="1" style="background-color: white">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Role</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Image</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <td><s:property value="%{#session.DTO.username}"/></td>
                        <td><s:property value="%{#session.DTO.fullname}"/></td>
                        <td><s:property value="%{#session.DTO.role}"/></td>
                        <td><s:property value="%{#session.DTO.phone}"/></td>
                        <td><s:property value="%{#session.DTO.email}"/></td>
                        <td><img src="<s:property value="%{#session.DTO.imagelink}"/>" </td>
                        <td><s:property value="%{#session.DTO.description}"/></td>
                    </tr>
            </tbody>
        </table>                    
        <s:a action="LogoutAction">LogOut</s:a>
    </body>
</html>
