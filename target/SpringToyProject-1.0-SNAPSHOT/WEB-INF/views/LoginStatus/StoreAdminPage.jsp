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
%>
<main>
<div>${userStoreName}의Admin Page 입니다.</div>
<div>환영합니다 ${userName}님</div>
</main>
</body>
</html>
