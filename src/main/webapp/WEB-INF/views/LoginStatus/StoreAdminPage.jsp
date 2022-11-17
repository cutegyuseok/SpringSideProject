<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>StoreAdminPage</title>
</head>
<body>
<%@include file="../message/showMessage.jsp"%>
<%
    showMessage(request, response, "login", Status.FAIL);
%>
<div>Admin Page 입니다.</div>
<div>${userID}</div>
<div>${userName}</div>
<div>${userStoreName}</div>
</body>
</html>
