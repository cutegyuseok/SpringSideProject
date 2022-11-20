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
<jsp:include page="../Layout/header.jsp"/>
<%@include file="../message/showMessage.jsp"%>
<%
    showMessage(request, response, "login", Status.FAIL);
    showMessage(request, response, "signup", Status.SUCCESS);

%>
<main>
<div>로그인</div>
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
    <div>👉🏻<a href="/login/signUp"><b>회원 가입</b></a></div>
</main>
</body>
</html>
