<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h1 style="text-align: center">Main Menu</h1>
<h2 style="text-align: center">Here is the main menu</h2>

<br><br>
<h1 style="text-align: center">Pick Your Preferred Role</h1>

<h2 style="text-align: center"><a href="${pageContext.request.contextPath}/tank/home">Tank</a></h2>
<h2 style="text-align: center"><a href="${pageContext.request.contextPath}/dps/home">DPS</a></h2>
<h2 style="text-align: center"><a href="${pageContext.request.contextPath}/heal/home">Heal</a></h2>

<br><br>
<a href="${pageContext.request.contextPath}/"><b>Home Page</b> </a>
</body>
</html>