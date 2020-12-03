<%-- 
    Document   : managetool
    Created on : Jul 14, 2020, 3:58:59 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
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
        <s:head/>
        <sx:head/>
    </head>
    <body style="background-image: url('images/ok1.jpg'); background-size: cover">
        <h1>Manage Tool</h1>
        <h2>Search Tool</h2>
        <s:form action="SearchToolAction" method="POST">
            <s:textfield name="searchValue" label="ToolName"/>
            <s:submit value="Search"/>
            <s:if test="%{listTool != null}">
                <s:if test="%{listTool.size() > 0}">
                    <div class="limiter">
                        <div class="container-table100">
                            <div class="wrap-table100">
                                <div class="table100">
                                    <table border="1" style="background-color: white">
                                        <thead>
                                            <tr class="table100-head">
                                                <th class="column1">No.</th>
                                                <th class="column2">ToolId</th>
                                                <th class="column3">ToolName</th>
                                                <th class="column4">Description</th>
                                                <th class="column5">Image</th>
                                                <th class="column6">Quantity</th>
                                                <th class="column1">Status</th>
                                                <th class="column2">Delete</th>
                                                <th class="column3">Edit</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator var="dto" value="%{listTool}" status="counter">
                                                <tr>
                                                    <td class="column1"><s:property value="%{#counter.count}"/></td>
                                                    <td class="column2"><s:property value="%{#dto.id}"/></td>
                                                    <td class="column3"><s:property value="%{#dto.name}"/></td>
                                                    <td class="column4"><s:property value="%{#dto.description}"/></td>
                                                    <td class="column5"><img src="<s:property value="%{#dto.image}"/>" width="100"</td>
                                                    <td class="column6"><s:property value="%{#dto.quantity}"/></td>
                                                    <td class="column1"><s:property value="%{#dto.status}"/></td>
                                                    <td class="column2">
                                                        <s:url action="DeleteToolAction" id="DeleteLink">
                                                            <s:param name="id" value="%{#dto.id}"/>
                                                            <s:param name="lastSearchValue" value="%{#searchValue}"/>
                                                        </s:url>
                                                        <s:a href="%{#DeleteLink}">Delete</s:a>
                                                        </td>
                                                        <td class="column3">
                                                        <s:url action="EditToolAction" id="EditLink">
                                                            <s:param name="id" value="%{#dto.id}"/>
                                                            <s:param name="lastSearchValue" value="%{#searchValue}"/>
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
                    No Record Found
                </s:else>
            </s:if>
        </s:form>
        <font style="background-color: #1FC9FD">
        <s:a href="inserttool.jsp">Add More Tool</s:a><br/>
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
