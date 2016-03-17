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




<jsp:useBean id="msg" class="def.Message"></jsp:useBean>

<jsp:getProperty name="msg" property="text"></jsp:getProperty>

<p>
    ${param.get("pass")}
</p>

<p>
    ${msg.id}
</p>
</body>
</html>
