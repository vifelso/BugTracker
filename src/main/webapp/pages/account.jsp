<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <title>Account's page</title>
    <link href="<c:url value="/css/myCSS.css"/> " rel="stylesheet"/>

</head>
<body>
Language : <a href="?language=en">English</a>|<a href="?language=ru">Russian</a><br>

<div class="myCenter">
    <h1><spring:message code="account.title"/></h1>

    <spring:message code="account.welcome"/><br/>

    <a href="<c:url value="/index" />"><spring:message code="home.title"/></a><br/>
    <a href="<c:url value="/bugs/watchAllBugs" />"><spring:message code="watchAllBugs.title"/></a><br/>
    <a href="<c:url value="/bugs/addBug" />"><spring:message code="addBug.title"/></a><br/>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="<c:url value="/admin" />"><spring:message code="admin.acccess"/></a><br/>
    </sec:authorize>
    <a href="<c:url value="/j_spring_security_logout" />"><spring:message code="logout"/></a> <br/>
</div>
</body>
</html>