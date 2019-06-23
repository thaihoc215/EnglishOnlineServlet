<%--
  Created by IntelliJ IDEA.
  User: HOCHNT
  Date: 5/29/2019
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<html>
<head>
    <title><fmt:message key="label.home" bundle="${lang}"></fmt:message> </title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap-responsive.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/web/css/style.css' />" />
    <!--Font-->
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css'>
    <!-- SCRIPT
      ============================================================-->
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>

    <dec:head></dec:head>
</head>
<body>
    <%@ include file="/common/web/header.jsp" %>
    <%--<%@ include file="/common/web/menu.jsp" %>--%>
    <div class="container">
        <dec:body></dec:body>
    </div>
    <%@ include file="/common/web/footer.jsp" %>
</body>
</html>
