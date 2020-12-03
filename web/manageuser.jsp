<%-- 
    Document   : manageuser
    Created on : Jul 14, 2020, 3:54:16 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
        <title>JSP Page</title>
    </head>
    <body style="background-image: url('images/ok1.jpg'); background-size: cover">
        <font color="Red">
        <h1>Manage User</h1>
        <h2>Search User</h2>
        </font>
        <s:form action="SearchUserAction" method="POST">
            <s:textfield name="searchValue" label="Fullname"/>
            <s:submit value="Search"/>
            <s:if test="%{listUser != null}">
                <s:if test="%{listUser.size() > 0}">
                    <div class="limiter">
                        <div class="container-table100">
                            <div class="wrap-table100">
                                <div class="table100">
                                    <table border="1" style="background-color: white">
                                        <thead>
                                            <tr class="table100-head">
                                                <th class="column1">No</th>
                                                <th class="column2">Username</th>
                                                <th class="column3">Fullname</th>
                                                <th class="column4">Role</th>
                                                <th class="column5">Phone</th>
                                                <th class="column6">Email</th>
                                                <th class="column1">ImageLink</th>
                                                <th class="column2">Description</th>
                                                <th class="column3">DeleteUser</th>
                                                <th class="column4">EditUser</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator var="dto" value="%{listUser}" status="counter">
                                                <tr>
                                                    <td  class="column1"><s:property value="%{#counter.count}"/></td>
                                                    <td  class="column2"><s:property value="%{#dto.username}"/></td>
                                                    <td  class="column3"><s:property value="%{#dto.fullname}"/></td>
                                                    <td  class="column4"><s:property value="%{#dto.role}"/></td>
                                                    <td  class="column5"><s:property value="%{#dto.phone}"/></td>
                                                    <td  class="column6"><s:property value="%{#dto.email}"/></td>
                                                    <td  class="column1"><img src="<s:property value="%{#dto.imagelink}"/>" width="100px" height="100px"</td>
                                                    <td  class="column2"><s:property value="%{#dto.description}"/></td>
                                                    <td  class="column3">
                                                        <s:url action="DeleteUserAction" id="DeleteLink">
                                                            <s:param name="lastSearchValue" value="%{searchValue}"/>
                                                            <s:param name="id" value="%{#dto.username}"/>
                                                        </s:url>
                                                        <s:a href="%{#DeleteLink}">Delete</s:a>
                                                    </td>
                                                    <td class="column4">
                                                    <s:url action="EditUserAction" id="EditLink">
                                                        <s:param name="lastSearchValue" value="%{searchValue}"/>
                                                        <s:param name="id" value="%{#dto.username}"/>
                                                    </s:url>
                                                    <s:a href="%{#EditLink}">Edit</s:a>
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </s:if>
                <s:else>
                    No Result found
                </s:else>
            </s:if>
        </s:form>
        <font style="background-color: #1FC9FD">
        <s:a href="insertuser.jsp">Create an account</s:a><br/>
        <s:a href="admin.jsp">Back</s:a>
        </font>
        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
    </body>
</html>
