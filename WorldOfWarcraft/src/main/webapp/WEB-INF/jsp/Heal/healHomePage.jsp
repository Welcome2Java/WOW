<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@include file="HeaderFooter/Header.jsp"%>

<h1 style="text-align: center">Heal</h1>
<form:form action="showResult" modelAttribute="healClassesToUse">
    <form:checkboxes path="healClasses" name="healClasses" items="${healClassesToUse.healingClassOptionsMap}"/>

    <br><br>
    <input type="submit" value="Submit"/>
</form:form>
<%@include file="HeaderFooter/Footer.jsp"%>