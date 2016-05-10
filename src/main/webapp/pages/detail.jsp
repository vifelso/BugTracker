<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <title>Detail</title>

    <link href="<c:url value="/css/myCSS.css" />" rel="stylesheet">

</head>
<body>

<table border="1" width="100%">


    <jsp:useBean id="bugDtoDetail" scope="request" type="com.dto.BugDto"/>

    <c:set var="detailBugDto" value="${bugDtoDetail}"/>
    <tr>
        <td><spring:message code="label.idBug"/></td>
        <td><c:out value="${detailBugDto.idBug}"/></td>
    </tr>
    <tr>
        <td><spring:message code="label.title"/></td>
        <td><c:out value="${detailBugDto.title}"/></td>
    </tr>
    <tr>

        <td><spring:message code="label.status"/></td>
        <td><c:out value="${detailBugDto.status}"/></td>
    </tr>
    <tr>
        <td><spring:message code="label.priority"/></td>
        <td><c:out value="${detailBugDto.prior}"/></td>
    </tr>
    <tr>
        <td height="400"><spring:message code="label.description"/></td>
        <td height="400"><label>
            <textarea disabled style="height: 300px;width: 700px"><c:out value="${detailBugDto.desc}"/></textarea>
        </label></td>
    </tr>
    <tr>
        <td><spring:message code="label.autor"/></td>
        <td><c:out value="${detailBugDto.autor}"/></td>
    </tr>
    <tr>
        <td><spring:message code="label.date"/></td>
        <td><c:out value="${detailBugDto.date}"/></td>
    </tr>


</table>
<br>
<a href="<c:url value="/"/>"><spring:message code="home.title"/></a>
<br>

</body>
</html>

