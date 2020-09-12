<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@include file="HeaderFooter/Header.jsp"%>
<h1 style="text-align: center">Tank</h1>
<form:form action="showResult" modelAttribute="tankClassesToUse">
    <form:checkboxes path="tankClasses" name="tankClasses" items="${tankClassesToUse.tankingClassOptionsMap}"/>

    <br><br>
    <input type="submit" value="Submit"/>
</form:form>
<%@include file="HeaderFooter/Footer.jsp"%>