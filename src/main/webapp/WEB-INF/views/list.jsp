<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 1/31/2019
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-dark-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <c:if test="${not empty msg}">
        <div class="w3-panel w3-display-container w3-round w3-margin-bottom w3-padding w3-light-green w3-card-4">
            <span class="w3-button w3-display-topright w3-hover-light-green" onclick="this.parentElement.style.display='none'">X</span>
            <h3>${msg}</h3>
        </div>
    </c:if>
    <c:if test="${not empty dlt}">
        <div class="w3-panel w3-display-container w3-round w3-margin-bottom w3-padding w3-red w3-card-4">
            <span class="w3-button w3-display-topright w3-hover-red" onclick="this.parentElement.style.display='none'">X</span>
            <h3>${dlt}</h3>
        </div>
    </c:if>
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue w3-round">
            <h2>Users</h2>
        </div>
        <div>
            <table class="w3-table w3-center">
                <thread>
                    <tr>
                        <th class="w3-col m1 w3-center w3-large">#ID</th>
                        <th class="w3-col m2 w3-center w3-large">Name</th>
                        <th class="w3-col m3 w3-center w3-large">Email</th>
                        <th class="w3-col m3 w3-center w3-large">Skill</th>
                        <th class="w3-col m3 w3-center w3-large">Action</th>
                    </tr>
                </thread>


        <c:forEach items="${users}" var="user">
            <tr>
                <td class="w3-col m1 w3-center">${user.id}</td>
                <td class="w3-col m2 w3-center">${user.name}</td>
                <td class="w3-col m3 w3-center">${user.email}</td>
                <td class="w3-col m3 w3-center">${user.skillsList}</td>
                <td class="w3-col m3 w3-center">
                    <spring:url value="/list/${user.id}" var="userUrl"/>
                    <spring:url value="/list/${user.id}/delete" var="deleteUrl"/>
                    <spring:url value="/list/${user.id}/update" var="updateUrl"/>
                    <table class="w3-table">
                        <tr>
                            <td class="w3-center w3-col m3">
                                <button class="w3-btn w3-round-large w3-blue" onclick="location.href='${userUrl}'">Query</button>
                            </td>
                            <td class="w3-center w3-col m3">
                                <button class="w3-btn w3-round-large w3-green" onclick="location.href='${updateUrl}'">Update</button>
                            </td>
                            <td class="w3-center w3-col m3">
                                <form method="post" action="${deleteUrl}">
                                    <button class="w3-btn w3-round-large w3-red">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
            </table>
        </div>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large w3-hover-light-grey" onclick="location.href='../..'">Back to main</button>
</div>
</body>
</html>
