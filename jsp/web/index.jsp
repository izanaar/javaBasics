<%--
  Created by IntelliJ IDEA.
  User: traum
  Date: 12.03.16
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tteq</title>
</head>
<body>
<%
    out.println("Your IP address is " + request.getRemoteAddr());
%>

${pageContext.servletContext.getInitParameter("test")}

<p><jsp:text>Tempest keep was merely a setback</jsp:text></p>

<p>${pageContext.response.getHeader("Content-Type")}</p>
Today's date: <%= (new java.util.Date()).toLocaleString()%>
</body>
</html>
