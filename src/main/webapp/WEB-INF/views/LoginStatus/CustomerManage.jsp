<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../Layout/header.jsp"/>
</header>
<div class="goods_info">
    <c:forEach var="customerDTOList" items="${customerList}">
        <div class="card">
            <h5 class="card-header">Grade</h5>
            <div class="card-body">
                <h5 class="card-title">${customerDTOList.getCustomerID()}</h5>
                <p class="card-text"><p>이름 ${customerDTOList.getCustomerName()}</p>
                <p class="q">사용 금액 ${customerDTOList.getCustomerSpentMoney()}원</p>
                <p class="q">구매 횟수 ${customerDTOList.getCustomerPurchaseCount()} </p></p>
                <p class = "btn"><a href="/" class="btn btn-secondary">세부 정보</a><a href="/" class="btn btn-secondary">세부 정보</a></p>

<%--            <p><a href="/CustomerManage/delete/${customerDTOList.customerID}" class="btn btn-secondary">세부 정보</a><a href="/naver/pay/detail/${shoppingListDTO.sId}" class="btn btn-secondary">세부 정보</a></p>--%>
            </div>
        </div>
    </c:forEach>
</div>


</body>
</html>
