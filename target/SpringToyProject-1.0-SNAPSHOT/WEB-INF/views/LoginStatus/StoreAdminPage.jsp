<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>StoreAdminPage</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<header>
    <jsp:include page="../Layout/header.jsp"/>
</header>
<%@include file="../message/showMessage.jsp"%>
<%
    showMessage(request, response, "login", Status.SUCCESS);
    showMessage(request, response, "logout", Status.FAIL);
    showMessage(request, response, "delete_all_customer", Status.FAIL);
    showMessage(request, response, "delete_user", Status.FAIL);
%>
<main>
<div>${userStoreName}의Admin Page 입니다.</div>
<div>환영합니다 ${userName}님</div>
<div>👉🏻<a href="/customerManage/list"><b>고객 리스트</b></a></div>
    <div>👉🏻<a href="/parameter/page"><b>고객 등급 설정</b></a></div>
    <div>👉🏻<a href="/login/update"><b>사용자 정보 수정</b></a></div>
    <form onsubmit="return askDelete()" method="get" action="/unregister">
        <script>
            function askDelete() {
                return confirm("삭제된 내역은 복구할 수 없습니다. 정말로 삭제하시겠습니까?");
            }
        </script>
        <div>👉🏻<input type="submit" value="회원 탈퇴"></div>
    </form>



</main>
</body>
</html>
