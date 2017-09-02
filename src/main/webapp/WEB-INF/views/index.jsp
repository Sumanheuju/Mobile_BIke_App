<%-- 
    Document   : index.jsp
    Created on : Aug 9, 2017, 10:38:17 PM
    Author     : sumanheuju
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Super App</title>
    </head>
    <body>
        <h1>Super !!</h1>
        
        <c:forEach var="cor" items="${profileUsers}">
            <h2>${cor.name}</h2>
            <h2>${cor.licenseNo}</h2>
        </c:forEach>
    </body>
</html>
