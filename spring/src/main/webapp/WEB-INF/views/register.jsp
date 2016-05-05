<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<sf:form method="POST" commandName="spitter">
    <h3>Register in Spitter</h3>
    <table>
        <tr>
            <td>First Name:</td>
            <td><sf:input path="firstName"/></td>
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
            <td></td>
            <td><input type="submit" value="Register"/></td>
        </tr>
    </table>
</sf:form>
</body>
</html>
