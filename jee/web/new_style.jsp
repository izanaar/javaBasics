<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>EL for pageContext</title></head>
<body>
<jsp:include page="WEB-INF/pages/header.jsp"/>
Путь к контексту : ${ pageContext.request.contextPath } <br/>
Имя хоста : ${ header["host"] }<br/>
Тип и кодировка контента : ${pageContext.response.contentType}<br/>
Кодировка ответа : ${pageContext.response.characterEncoding}<br/>
ID сессии : ${pageContext.request.session.id}<br/>
Время создания сессии в мсек : ${pageContext.request.session.creationTime}<br/>
Время последнего доступа к сессии : ${pageContext.request.session.lastAccessedTime}<br/>
Имя сервлета : ${pageContext.servletConfig.servletName}<br/>
Параметр контекста cparam: ${pageContext.getServletContext().getInitParameter("cparam")} <br/>
<jsp:expression>"A"+"B"</jsp:expression>
</body>
</html>

