<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JSP Timing</title>
</head>
<body>
<div>
    <a href="/request_info">Request info</a>
    <a href="/send_mail">Send email</a>
    <a href="/old_style">Old style</a>
    <a href="/new_style">New style</a>
</div>
<h5>Счетчик времени от запуска приложения до нажатия кнопки</h5>
<jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
<form name="Simple" action="FirstServlet" method="POST">
    <input type="hidden" name="time" value="${calendar.timeInMillis}"/>
    <input type="submit" name="button" value="Посчитать время"/>
</form>
</body>
</html>
