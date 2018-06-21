<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mvc-Handler-Mapping-Adapter</title>
</head>
<body>

<h2 align="center" style="color: cadetblue">Welcome! <c:out value="${greeting}"/></h2>
<hr>
<h1 align="center">Organization Details</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div style="text-align: center">
    <a href="${contextPath}/location" style="font-size: 30px">Click here to get organization details for your location.</a>
</div>

</body>
</html>