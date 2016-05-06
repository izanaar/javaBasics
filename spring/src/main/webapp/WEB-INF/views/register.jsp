<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value="/css/register.css"/>">
</head>
<body>
<sf:form method="POST" commandName="spitter" cssClass="card-panel teal lighten-2">
    <h3>Register in Spitter</h3>
    <table>
        <tr>
            <td>First Name:</td>
            <td><sf:input path="firstName"/></td>
        </tr>
        <tr>
            <td colspan="2"><sf:errors path="firstName"/> </td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><sf:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><sf:input path="email"/></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><sf:input path="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><sf:password path="password"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Register" style="width: 100%"/></td>
        </tr>
    </table>
</sf:form>
</body>
</html>
