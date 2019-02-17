<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 2/15/2019
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <div class="w3-card-4">
    <div class="w3-container w3-light-blue  w3-round">
            <h2>User Detail</h2>
    </div>
    <div>
        <table class="w3-table w3-bordered w3-striped">
            <tr>
                <td class="w3-large w3-col m1 ">ID:</td>
                <td class="w3-col m11">${user.id}</td>
            </tr>
            <tr>
                <td class="w3-large w3-col m1 ">Name:</td>
                <td class="w3-col m11">${user.name}</td>
            </tr>
            <tr>
                <td class="w3-large w3-col m1">Email:</td>
                <td class="w3-col m11">${user.email}</td>
            </tr>
            <tr>
                <td class="w3-large w3-col m1 ">Sex:</td>
                <td class="w3-col m11">${user.sex}</td>
            </tr>
            <tr>
                <td class="w3-large w3-col m1 ">Country:</td>
                <td class="w3-col m11">${user.country}</td>
            </tr>
            <tr>
                <td class="w3-large w3-col m1 ">Adress:</td>
                <td class="w3-col m11">${user.adress}</td>
            </tr>
            <tr>
                <td class="w3-large w3-col m1 ">Skill:</td>
                <td class="w3-col m11">${user.skillsList}</td>
            </tr>
            <tr>
                <td class="w3-large w3-col m1 ">Frameworks:</td>
                <td class="w3-col m11">${user.frameworksList}</td>
            </tr>
    </table>
    </div>
    </div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large w3-hover-light-grey" onclick="location.href='/list'">Back to users</button>
</div>
</body>
</html>
