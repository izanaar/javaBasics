<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" href="<c:url value="/css/app.css" />"/>
</head>
<body>
<c:out value="Spitter says hello, using JSTL"/>
<h1>Welcome to Spittr</h1>
<a href="<c:url value="/spittles/get"/>">Spittles</a> |
<a href="<c:url value="/register" />">Register</a>
</body>
</html>