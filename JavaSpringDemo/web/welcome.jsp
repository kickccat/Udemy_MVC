<%--
  Created by IntelliJ IDEA.
  User: zhouyi
  Date: 08.05.18
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<%
    String[] messages = (String[]) request.getAttribute("myWelcomeMessage");
    StringBuilder welcomeMessage = new StringBuilder();
    for (String msg : messages) {
        welcomeMessage.append(msg).append(" ");
    }
    out.print(welcomeMessage.toString());
%>

</body>
</html>
