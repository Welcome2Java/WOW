<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="HeaderFooter/Header.jsp"%>

<h1 style="text-align: center">Tank</h1>
<h1 style="text-align: center">${chosenPick}</h1>
<c:choose>
    <c:when test="${chosenPick == 'Warrior'}">
        <a href="https://worldofwarcraft.com/en-us/character/us/grizzly-hills/breathon">Warrior</a>
    </c:when>
    <c:when test="${chosenPick == 'Paladin'}">
        <a href="https://worldofwarcraft.com/en-us/character/us/grizzly-hills/cytomander">Paladin</a>
    </c:when>
    <c:when test="${chosenPick == 'Druid'}">
        <a href="https://worldofwarcraft.com/en-us/character/us/grizzly-hills/gington">Druid</a>
    </c:when>
    <c:when test="${chosenPick == 'DemonHunter'}">
        <a href="https://worldofwarcraft.com/en-us/character/us/grizzly-hills/tyria">Demon Hunter</a>
    </c:when>
    <c:when test="${chosenPick == 'Monk'}">
        <a href="https://worldofwarcraft.com/en-us/character/us/grizzly-hills/andira">Monk</a>
    </c:when>
    <c:when test="${chosenPick == 'DeathKnight'}">
        <a href="https://worldofwarcraft.com/en-us/character/us/grizzly-hills/moraxes">Death Knight</a>
    </c:when>
    <c:otherwise>
        <a href="https://worldofwarcraft.com/en-us/">World Of Warcraft</a>
    </c:otherwise>

</c:choose>
<%@include file="HeaderFooter/Footer.jsp"%>