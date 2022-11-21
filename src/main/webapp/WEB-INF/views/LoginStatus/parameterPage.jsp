<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-22
  Time: 오전 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<%@include file="../message/showMessage.jsp"%>
<%
    showMessage(request, response, "update", Status.SUCCESS);
    showMessage(request, response, "update", Status.FAIL);
%>
<%
    showMessage(request, response, "deleteParameter", Status.FAIL);
    showMessage(request, response, "deleteParameter", Status.SUCCESS);
%>
<header>
    <jsp:include page="../Layout/header.jsp"/>
</header>
<div class="goods_info">
    <c:forEach var="parameterListToPage" items="${parameterListToPage}">
        <div class="card">
            <h5 class="card-header"></h5>
            <div class="card-body">
                <form method="post" accept-charset="utf-8" action="/parameter/update/${parameterListToPage.grade}">
                    <h5 class="card-title">${parameterListToPage.grade}</h5>
                    <div class="form__list">
                        <label for="minimumSpentMoney">최소 사용금액: </label>
                        <input type="text" id="minimumSpentMoney" name="minimumSpentMoney" value=${parameterListToPage.minimumSpentMoney} placeholder="${parameterListToPage.minimumSpentMoney}" required/>
                    </div>
                    <div class="form__list">
                        <label for="minimumPurchaseCount">최소 구매횟수: </label>
                        <input type="text" id="minimumPurchaseCount" name="minimumPurchaseCount" value=${parameterListToPage.minimumPurchaseCount} placeholder="${parameterListToPage.minimumPurchaseCount}" required/>
                    </div>
                    <p class="btn"><input type="submit" name="submit" value="Submit"></p>
                </form>
                <p class = "btn"><a href="/parameter/delete/${parameterListToPage.grade}" class="btn btn-secondary">정보 삭제</a></p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
