<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
  <title>AddCustomer</title>
  <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../Layout/header.jsp"/>
<%@include file="../message/showMessage.jsp"%>
<%
  showMessage(request, response, "add parameter", Status.FAIL);
%>
<main>
  <div>등급 추가</div>
  <div>
    <form method="post" accept-charset="utf-8" action="/parameter/add">
      <div class="form__list">
        <label for="grade">등급 이름: </label>
        <input type="text" id="grade" name="grade" placeholder="INPUT PARAMETER GRADE" required/>
      </div>

      <div class="form__list">
        <label for="minimumSpentMoney">최소 사용 금액: </label>
        <input type="number" id="minimumSpentMoney" name="minimumSpentMoney" placeholder="INPUT MINIMUM SPENT MONEY" required/>
      </div>

      <div class="form__list">
        <label for="minimumPurchaseCount">최소 구매 횟수: </label>
        <input type="number" id="minimumPurchaseCount" name="minimumPurchaseCount" placeholder="INPUT MINIMUM PURCHASE COUNT" required/>
      </div>

      <input type="submit" name="submit" value="Submit">
    </form>
  </div>
</main>
</body>
</html>
