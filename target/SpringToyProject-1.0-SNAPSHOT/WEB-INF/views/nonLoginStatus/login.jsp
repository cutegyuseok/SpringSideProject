<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-16
  Time: 오후 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>LoginPage</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@include file="../message/showMessage.jsp"%>
<%
    showMessage(request, response, "login", Status.FAIL);
%>
<div>로그인 화면</div>
<div>로그인 시도 횟수 ${loginAtempt}</div>
<div>
    <form method="post" action="/login">
        <div class="form__list">
            <label for="userID">ID: </label>
            <input type="text" id="userID" name="userID" placeholder="INPUT YOUR ID" required/>
        </div>

        <div class="form__list">
            <label for="userPassword">PASSWORD: </label>
            <input type="password" id="userPassword" name="userPassword" placeholder="INPUT YOUR PASSWORD" required/>
        </div>

        <div class="checkbox__form">
            <label for="save">AUTO LOGIN: </label>
            <input id="save" type="checkbox" name="save"/>
        </div>
        <input type="submit" name="submit" value="Submit">
    </form>
</div>
</body>
</html>
