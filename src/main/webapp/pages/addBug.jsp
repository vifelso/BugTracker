<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <title>Add bug</title>
    <link href="<c:url value="/css/myCSS.css"/> " rel="stylesheet"/>
</head>

<body>

<h3><spring:message code="create.title"/></h3>

<form:form method="post" modelAttribute="bugDto" action="/bugs/saveBugComplete">
    <div class="widthDiv"><spring:message code="label.title"/></div>
    <form:input path="title" cssClass="widthField"/><br>

    <div class="widthDiv"><spring:message code="label.status"/></div>
    <form:select path="status">
        <form:option value="Close"><spring:message code="label.close"/></form:option>
        <form:option value="Open"><spring:message code="label.open"/></form:option>
    </form:select><br>

    <div class="widthDiv"><spring:message code="label.priority"/></div>
    <form:select path="prior">
        <form:option value="Unimportant"><spring:message code="label.unimportant"/></form:option>
        <form:option value="Average"><spring:message code="label.average"/></form:option>
        <form:option value="Important"><spring:message code="label.important"/></form:option>
    </form:select><br>

    <div class="widthDiv"><spring:message code="label.description"/></div>
    <form:textarea path="desc" cssClass="heightDesc"/><br>
    <form:errors path="*" cssClass="error"/><br>
    <input type="submit" value="<spring:message code="label.save"/>"/>

</form:form>
<br>

<p><a href="<c:url value="/index"/>"><spring:message code="home.title"/></a></p>

</body>
</html>
