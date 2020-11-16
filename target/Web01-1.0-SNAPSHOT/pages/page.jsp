
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        @import "../styles/main.css" screen;
    </style>
</head>
<body>
    <h2>Hi from jsp</h2>

    <%@page import="java.util.Date" %>
    <%@ page import="logic.BuisnesLog" %>

    <%
        Date now = new Date();
    %>

    <%=
    now
    %>



<%
    BuisnesLog bl = new BuisnesLog();
    out.println("<div><b>" + bl.getString() + "</b></div>");
    %>



</body>
</html>
