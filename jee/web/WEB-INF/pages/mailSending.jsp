<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JavaMail</title>
</head>
<body>
<p>
    The message will be send from ${sender}
</p>
<form action="MailServlet" method="POST">
    <table>
        <tr>
            <td>Send to:</td>
            <td><input type="text" name="to"/></td>
        </tr>
        <tr>
            <td>Subject:</td>
            <td><input type="text" name="subject"/></td>
        </tr>
    </table>
    <hr/>
    <textarea type="text" name="body" rows="5" cols="45">Message text</textarea>
    <br/><br/>
    <input type="submit" value="Send message!"/>
</form>
</body>
</html>