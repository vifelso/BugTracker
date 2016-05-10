<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login page</title>

    <link href="<c:url value='/css/myCSS.css' />" rel="stylesheet"/>


</head>
<body>

<h1><spring:message code="login.title"/></h1>


<form method="post" action="<c:url value="/j_spring_security_check"/>">
    <table>
        <tbody>
        <tr>
            <td><spring:message code="login.label.login"/></td>
            <td><label><input type="text" name="j_username" id="j_username" size="30" maxlength="40"/></label></td>
        </tr>
        <tr>
            <td><spring:message code="login.label.password"/></td>
            <td><label><input type="password" name="j_password" id="j_password" size="30" maxlength="32"/></label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="<spring:message code="label.submit"/>"/></td>
        </tr>
        </tbody>
    </table>
</form>

<p>

    <a href="<c:url value="/index"/>"><spring:message code="home.title"/></a>

</p>
</body>
</html>