<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
</head>
<body>
<c:out value="Spitter says hello, using JSTL"/>
<h1>Welcome to Spittr</h1>
<a href="<c:url value="/spittles/get"/>">Spittles</a> |
<a href="<c:url value="/register" />">Register</a>
</body>
</html>