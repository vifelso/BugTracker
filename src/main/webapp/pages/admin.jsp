<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <link href="<c:url value='/css/myCSS.css' />" rel="stylesheet"/>
    <title>Admin page</title>
</head>
<body>

<table border="1" width="100%">
    <tr>
        <th><spring:message code="admin.page.id"/></th>
        <th><spring:message code="admin.page.login"/></th>
        <th><spring:message code="admin.page.password"/></th>
        <th><spring:message code="admin.page.firstname"/></th>
        <th><spring:message code="admin.page.lastname"/></th>
        <th><spring:message code="admin.page.email"/></th>
        <th><spring:message code="admin.page.role"/></th>
    </tr>
    <jsp:useBean id="allUsers" scope="request" type="java.util.Set"/>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.email}</td>
            <td>${user.role.role}</td>
        </tr>
    </c:forEach>
</table>
<div align="center"><a href="<c:url value="/index"/>"><spring:message code="home.title"/></a></div>
</body>
</html>
