<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.io.PrintStream" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>JSP-страница</title></head>
<body>
<%!
    private int count = 0;
    String version = new String("1.2");

    private String getName() {
        return "Old Style";
    }

    private String getTime(){
        return LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

%>
<% out.println("Значение count: "); %>
<%= count++ %>
<br/>
<% out.println("Значение count после инкремента: " + count); %>
<br/>
<% out.println("Старое значение version: "); %>
<%= version %>
<br/>
<%= "Текущее время: " + getTime()%>
<br/>
<% version = getName();
    out.println("Новое значение version: " + version); %>
</body>
</html>