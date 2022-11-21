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
  <div>고객 정보 수정</div>
  <div>
    <form method="post" accept-charset="utf-8" action="/customerManage/updateCustomer">
      <div class="form__list">
        <label for="customerID">고객 아이디: </label>
        <input type="text" id="customerID" name="customerID" placeholder=${customer.customerID} required/>
      </div>

      <div class="form__list">
        <label for="customerName">고개 이름: </label>
        <input type="text" id="customerName" name="customerName" placeholder=""${customer.customerName}" required/>
      </div>

      <div class="form__list">
        <label for="customerSpentMoney">고객 사용 금액: </label>
        <input type="number" id="customerSpentMoney" name="customerSpentMoney" placeholder="${customer.customerSpentMoney}" required/>
      </div>

      <div class="form__list">
        <label for="customerPurchaseCount">고객 구매 횟수: </label>
        <input type="number" id="customerPurchaseCount" name="customerPurchaseCount" placeholder="${customer.customerPurchaseCount}" required/>
      </div>

      <input type="submit" name="submit" value="Submit">
    </form>
  </div>
</main>
</body>
</html>
