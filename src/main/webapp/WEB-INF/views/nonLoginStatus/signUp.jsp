<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
  <title>SignUpPage</title>
  <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../Layout/header.jsp"/>
<%@include file="../message/showMessage.jsp"%>
<%
  showMessage(request, response, "signup", Status.FAIL);
%>
<main>
  <div>회원가입</div>
  <div>
    <form method="post" accept-charset="utf-8" action="/login/signUp">
      <div class="form__list">
        <label for="userID">ID: </label>
        <input type="text" id="userID" name="userID" placeholder="INPUT YOUR ID" required/>
      </div>

      <div class="form__list">
        <label for="userPassword">PASSWORD: </label>
        <input type="password" id="userPassword" name="userPassword" placeholder="INPUT YOUR PASSWORD" required/>
      </div>

      <div class="form__list">
        <label for="userName">NAME: </label>
        <input type="text" id="userName" name="userName" placeholder="INPUT YOUR NAME" required/>
      </div>

      <div class="form__list">
        <label for="userEmail">EMAIL: </label>
        <input type="text" id="userEmail" name="userEmail" placeholder="INPUT YOUR EMAIL" required/>
      </div>

      <div class="form__list">
        <label for="userStoreName">STORE NAME: </label>
        <input type="text" id="userStoreName" name="userStoreName" placeholder="INPUT YOUR STORE NAME" required/>
      </div>

      <input type="submit" name="submit" value="Submit">
    </form>
  </div>
</main>
</body>
</html>
