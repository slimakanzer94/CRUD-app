<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="org.springframework.ui.ModelMap" %><%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 1/31/2019
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-dark-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

    <div class="w3-card-4">
        <div class="w3-container w3-light-blue w3-round">
            <h2>Add user</h2>
        </div>
        <form:form action="/checkUser" method="post" modelAttribute="user" class="w3-selection w3-light-grey w3-padding">
            <form:hidden path="id"/>
            <spring:bind path="name">
                <div class="${status.error ? 'has-error': ''}">
                    <label class="w3-validate">Name:</label>
                    <div>
                        <form:input path="name" type="text" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"/><br />
                        <form:errors class="w3-validate" path="name"/>
                    </div>
                </div>
            </spring:bind>
            <spring:bind path="email">
            <div class="${status.error?'has-error': ''}">
                <label class="w3-validate">Email:
                    <form:input path="email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"/><br />
                    <form:errors class="w3-validate" path="name"/>
            </label>
            </div>
            </spring:bind>
            <form:label path="password">Password:
                <form:input path="password" type="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"/><br />
            </form:label>
            <form:label path="confirmPassword">Confirm password:
                <form:input path="confirmPassword" type="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"/><br />
            </form:label>
            <form:label path="sex">Sex:
                <div class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                <label class="radio">
                    <form:radiobutton path="sex" value="M" />Male
                </label>
                    <label class="radio">
                        <form:radiobutton path="sex" value="F" />Female
                    </label> <br/>
                </div>
            </form:label>
            <form:label path="country">Country:
                <div class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                    <form:select path="country" class="w3-input w3-animate-input w3-border w3-round-large">
                        <form:option value="NONE" label="---Select---"/>
                        <form:options items="${countrysList}"/>
                        <form:errors path="country" class="control-label"/>;
                    </form:select>
                </div>
            </form:label>
            <form:label path="adress">Adress:
                <form:textarea path="adress" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"/><br />
            </form:label>
            <form:label path="phoneNumber">Phone number:
                <form:input path="phoneNumber" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"/><br />
            </form:label>
            <form:label path="newsLetter"><h4>News letter:</h4>
                <form:checkbox path="newsLetter" id="newsLetter" class="w3-input w3-border w3-round-large" style="width: 30%"/><br />
            </form:label>
            <form:label path="frameworks"><h4>Web frameworks:</h4>
                <form:checkboxes path="frameworks" items="${frameworksList}" class="w3-input w3-border w3-round-large" style="width: 30%"/>
            </form:label><br />
            <form:label path="skills">
                <h4>Java sills:</h4>
                <form:checkboxes path="skills" items="${skillsList}" class="w3-input w3-border w3-round-large" style="width: 30%"/>
            </form:label><br />
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom w3-margin-top">Submit</button>
        </form:form>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large w3-hover-light-grey" onclick="location.href='../..'">Back to main</button>
</div>
</body>
</html>
