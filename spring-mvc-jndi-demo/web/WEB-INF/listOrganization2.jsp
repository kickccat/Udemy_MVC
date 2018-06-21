<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List organizations using a Service</title>
</head>
<body>
<h1>Listing organizations using a Service</h1>

<c:forEach var="row" items="${orgList}">
    Name: ${row.companyName} <br>
    Year: ${row.yearOfIncorporation} <br>
    Zip: ${row.postalCode} <br>
    Emp Count: ${row.employeeCount} <br>
    Slogan: ${row.slogan} <br>
</c:forEach>

</body>
</html>