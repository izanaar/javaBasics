<%@page import="java.time.LocalTime" %>
<div style="margin: 0px 20px 5px 20px">
    <div style="width: 80%">
        SessionID: ${pageContext.request.session.id}
        ime: ${LocalTime.now().toString()}
    </div>
</div>