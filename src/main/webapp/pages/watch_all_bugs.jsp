<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <title>All Posts</title>
    <link href="<c:url value='/css/myCSS.css' />" rel="stylesheet"/>

</head>
<body>

<table border="1" width="100%">
    <tr>
        <th><spring:message code="label.idBug"/></th>
        <th><spring:message code="label.title"/></th>
        <th><spring:message code="label.status"/></th>
        <th><spring:message code="label.priority"/></th>
        <th><spring:message code="label.autor"/></th>
        <th><spring:message code="label.date"/></th>
    </tr>

    <jsp:useBean id="bugsList" scope="request" type="java.util.Set"/>
    <c:forEach var="bug" items="${bugsList}">
        <tr>
            <td>${bug.idBug}</td>
            <td>${bug.title}</td>
            <td>${bug.status}</td>
            <td>${bug.prior}</td>
            <td>${bug.autor}</td>
            <td>${bug.date}</td>
            <td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">


                    <a href="<c:url value="/bugs/edit?id=${bug.idBug}"/>"><spring:message code="label.edit"/></a>
                </sec:authorize>

                <a href="<c:url value="/bugs/detail?id=${bug.idBug}"/>"><spring:message code="label.detail"/></a>


            </td>
        </tr>
    </c:forEach>
</table>
<br>

<div align="center"><a href="<c:url value="/index"/>"><spring:message code="home.title"/></a></div>
<br>
</body>
</html>
