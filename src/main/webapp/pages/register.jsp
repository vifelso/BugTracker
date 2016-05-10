<%--
  Created by IntelliJ IDEA.
  User: Andrei
  Date: 26.03.2016
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
    <link rel="shortcut icon" href="<c:url value="/css/image/favicon.jpg"/>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
    <link href="<c:url value="/css/myCSS.css" />" rel="stylesheet">

    <script type="text/javascript">


        function ajaxAsyncRequest() {
            var req = new XMLHttpRequest();
            req.open("POST", "/ajaxController", true);
            req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            req.onreadystatechange = function () {
                if (req.status == 200 && req.readyState == 4) {
                    document.getElementById("message").innerHTML = req.responseText;
                }
            };
            req.send("uNameAjax=" + document.getElementById("checkLogin").value);
        }


    </script>
</head>
<body>

<form:form method="post" action="/doneRegistration" commandName="user">


    <table border="1" width="30%" cellpadding="5" class="tableCenter">
        <thead>
        <tr>
            <th colspan="2"><spring:message code="register.title"/></th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td><spring:message code="label.userName"/></td>
            <td>
                <label><input type="text" name="login" value="" maxlength="40" id="checkLogin"
                              onblur='ajaxAsyncRequest()' required/>
                    <br>
                    server :: <span id="message"></span>
                </label>
                <form:errors path="login" cssClass="error"/>

            </td>

        </tr>
        <tr>
            <td><spring:message code="label.password"/></td>
            <td><label><input type="password" name="password" value="" maxlength="40" required/></label>
                <form:errors path="password" cssClass="error"/>
            </td>

        </tr>

        <tr>
            <td><spring:message code="label.firstname"/></td>
            <td><label><input type="text" name="firstname" value="" maxlength="25" required/></label>
                <form:errors path="firstname" cssClass="error"/>
            </td>
        </tr>
        <tr>

            <td><spring:message code="label.lastname"/></td>
            <td><label><input type="text" name="lastname" value="" maxlength="40" required/></label>
                <form:errors path="lastname" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="label.email"/></td>
            <td><label><input type="text" name="email" value="" maxlength="40" required/></label>
                <form:errors path="email" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="<spring:message code="label.submit"/>"/></td>
            <td><input type="reset" value="<spring:message code="label.reset"/>"/></td>
        </tr>
        <tr>
            <td colspan="2"><a href="<c:url value="/index"/>"><spring:message
                    code="register.label.alreadyRegister"/></a></td>
        </tr>
        </tbody>
    </table>

</form:form>


</body>
</html>
