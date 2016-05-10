<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <title>Home page</title>
    <link href="<c:url value='/css/myCSS.css' />" rel="stylesheet"/>
</head>
<body>
Language : <a href="?language=en">English</a>|<a href="?language=ru">Russian</a><br>

<div class="myCenter">
    <h1><spring:message code="home.title"/></h1>

    <p><spring:message code="home.welcome"/><br/>
        <a href="<c:url value='/account' />"><spring:message code="home.into_bugTracker"/></a><br/>
        <sec:authorize access="isAnonymous()">
            <a href="<c:url value="/register"/>"><spring:message code="home.register"/></a><br/>
        </sec:authorize>
    </p>
</div>
</body>
</html>