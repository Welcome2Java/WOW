<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="HeaderFooter/Header.jsp"%>
<h1 style="text-align: center">DPS</h1>
<form:form action="showResult" modelAttribute="dpsClassesToUse">
    <form:checkboxes path="dpsClasses" name="dpsClasses" items="${dpsClassesToUse.dpsClassOptionsMap}"/>

    <br><br>
    <input type="submit" value="Submit"/>
</form:form>
<%@include file="HeaderFooter/Footer.jsp"%>