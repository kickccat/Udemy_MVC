<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mvc-Handler-Mapping-Adapter</title>
</head>
<body>

<h1>Organization home page</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<ul>
    <li><a href="${contextPath}/jstlsql">Listing organization using JSTL sql tags</a><br></li>
    <li><a href="${contextPath}/service">Listing organizations using Service</a> </li>
</ul>

</body>
</html>