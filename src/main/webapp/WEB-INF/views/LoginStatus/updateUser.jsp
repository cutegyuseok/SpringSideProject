<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
  <title>updateCustomer</title>
  <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../Layout/header.jsp"/>
<%@include file="../message/showMessage.jsp"%>
<%
  showMessage(request, response, "update", Status.FAIL);
%>
<main>
  <div>사용자 정보 수정</div>
  <div>
    <form method="post" accept-charset="utf-8" action="/login/update">
      <div class="form__list">
        <label>사용자 아이디: ${user.userID}</label>
      </div>

      <div class="form__list">
        <label for="userName">사용자 이름: </label>
        <input type="text" id="userName" name="userName" value=${user.userName} placeholder="${user.userName}" required/>
      </div>

      <div class="form__list">
        <label for="userEmail">사용자 이메일: </label>
        <input type="text" id="userEmail" name="userEmail" value=${user.userEmail} placeholder="${user.userEmail}" required/>
      </div>

      <div class="form__list">
        <label for="userPassword">사용자 기존 비밀번호: </label>
        <input type="text" id="userPassword" name="userPassword" placeholder="INPUT YOUR PASSWORD" required/>
      </div>

      <div class="form__list">
        <label for="userNewPassword">사용자 변경 비밀번호: </label>
        <input type="text" id="userNewPassword" name="userNewPassword" placeholder="INPUT YOUR NEW PASSWORD" required/>
      </div>

      <div class="form__list">
        <label for="userStoreName">사용자 스토어 이름: </label>
        <input type="text" id="userStoreName" name="userStoreName" value=${user.userStoreName} placeholder="${user.userStoreName}" required/>
      </div>
      <input type="submit" name="submit" value="Submit">
    </form>
  </div>
</main>
</body>
</html>
