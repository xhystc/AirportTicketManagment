<%--
  Created by IntelliJ IDEA.
  User: 87173
  Date: 2017/8/30
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/order-item.css">
</head>
<body>
    <div class="order-item" id="order-item-template" hidden>
        <div class="order-item-id"></div>
        <div class="order-item-dep"></div>
        <div class="order-item-dao">-></div>
        <div class="order-item-des"></div>
        <div class="order-item-date"></div>
        <div class="order-item-takeoffTime"></div>
        <div class="order-item-landingTime"></div>
        <div class="order-item-orderDate">订购日期</div>
        <div class="order-item-button"><button type="button" id="backTicket" hidden>退订</button> </div>
    </div>
    <h1>你好：${currentUser.username}</h1><br>
    <div id="order-items">
        <div id="order-description" class="order-item">
            <div class="order-item-id">订单号</div>
            <div class="order-item-dep">出发地</div>
            <div class="order-item-dao"></div>
            <div class="order-item-des">目的地</div>
            <div class="order-item-date">出发日期</div>
            <div class="order-item-takeoffTime">起飞时间</div>
            <div class="order-item-landingTime">降落时间</div>
            <div class="order-item-orderDate">订购日期</div>
        </div>
    </div>
    <script src="/javascript/jquery-3.2.1.js"></script>
    <script src="/javascript/util.js"></script>
    <script src="/javascript/user-information.js"></script>
</body>
</html>














