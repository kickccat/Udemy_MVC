<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Listing organizations using the JSTL Sql tag</title>
</head>
<body>
<h1>Listing organizations using the JSTL sql tag</h1>

<sql:query var="rs" dataSource="java:comp/env/jdbc/spring_db">
    SELECT * FROM organization
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    Name: ${row.company_name} <br>
    Year: ${row.year_of_incorporation} <br>
    Zip: ${row.postal_code} <br>
    Emp Count: ${row.employee_count} <br>
    Slogan: ${row.slogan} <br>
</c:forEach>

</body>
</html>