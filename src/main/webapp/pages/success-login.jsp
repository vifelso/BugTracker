<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Welcome page</title>
    <link href="<c:url value='/css/myCSS.css' />" rel="stylesheet"/>

</head>
<body>
<div class="myCenter">
    <h1><spring:message code="success.title"/></h1>

    <p><spring:message code="success.success"/><br/>
        <a href="<c:url value="/"/>"><spring:message code="home.title"/></a><br/></p>
</div>
</body>
</html>