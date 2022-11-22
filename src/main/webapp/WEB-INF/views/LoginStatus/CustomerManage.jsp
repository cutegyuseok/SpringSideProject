<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>고객 관리</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <style>
        .btn{
            margin-left: 5px;
        }
    </style>
</head>
<body>
    <jsp:include page="../Layout/header.jsp"/>
<%@include file="../message/showMessage.jsp"%>
<%
    showMessage(request, response, "add", Status.SUCCESS);
    showMessage(request, response, "update", Status.SUCCESS);
    showMessage(request, response, "delete", Status.SUCCESS);
    showMessage(request, response, "delete", Status.FAIL);
%>
<main>
<div>고객 리스트 </div>
    <div>👉🏻<a href="/customerManage/addCustomer"><b>고객 추가</b></a></div>
    <div class="goods_info">
    <c:forEach var="customerGradeList" items="${customerGradeList}">
        <div class="card">
            <h5 class="card-header">${customerGradeList.getGrade()}</h5>
            <div class="card-body">
                <h5 class="card-title">${customerGradeList.getCustomerID()}</h5>
                <p class="card-text"><p>이름 ${customerGradeList.getCustomerName()}</p>
                <p class="q">사용 금액 ${customerGradeList.getCustomerSpentMoney()}원</p>
                <p class="q">구매 횟수 ${customerGradeList.getCustomerPurchaseCount()} </p></p>
                <p class = "btn"><a href="/customerManage/updateCustomer/${customerGradeList.customerID}" class="btn btn-secondary">정보 수정</a><a href="/customerManage/deleteCustomer/${customerGradeList.customerID}" class="btn btn-secondary">정보 삭제</a></p>

<%--            <p><a href="/CustomerManage/delete/${customerDTOList.customerID}" class="btn btn-secondary">세부 정보</a><a href="/naver/pay/detail/${shoppingListDTO.sId}" class="btn btn-secondary">세부 정보</a></p>--%>
            </div>
        </div>
    </c:forEach>
</div>
</main>

</body>
</html>
