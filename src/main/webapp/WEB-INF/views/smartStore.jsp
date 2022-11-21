<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Smart_Store</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">


  </head>
  <body>
  <jsp:include page="Layout/header.jsp"/>
  <%@include file="message/showMessage.jsp"%>
  <%
    showMessage(request, response, "logout", Status.SUCCESS);
    showMessage(request, response, "unregister", Status.SUCCESS);


  %>
  <main>
  <h1>Welcome</h1>
  <div>자바에서 진행한 스마트 스토어와 스프링에서 진행한 네이버페이 프로젝트를 결합하여 해보는 스프링 연습 입니다.</div>

    <div>👉🏻<a href="/login"><b> Login 하기</b></a></div>

  </main>
  </body>
</html>
