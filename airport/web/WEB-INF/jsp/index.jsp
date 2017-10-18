<%--
  Created by IntelliJ IDEA.
  User: 87173
  Date: 2017/8/27
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/user-search.css" type="text/css">
    <link rel="stylesheet" href="/css/ticket-item.css" type="text/css">
</head>
<body>
    <div id="top-bar-wapper">
       <div id="top-bar">
           hello:${currentUser.username}&nbsp;&nbsp;<a href="/user_information">用户信息</a>&nbsp;&nbsp;[<a href="/logoff">注销</a>]
       </div>
    </div>
    <div id="airport-option-template" class="airport-option-template" hidden></div>
    <div id="ticket-item-template" class="ticket-item" hidden>
        <div class="ticket-item-airlineId"></div>
        <div class="ticket-item-dep"></div>
        <div class="ticket-item-dao">-></div>
        <div class="ticket-item-des"></div>
        <div class="ticket-item-date"></div>
        <div class="ticket-item-takeoffTime"></div>
        <div class="ticket-item-landingTime"></div>
        <div class="ticket-item-stock"></div>
        <div class="ticket-item-button"><button type="button" id="buyTicket">订购</button> </div>
    </div>
    <div class="search-block">
        <div class="search-bar">
            <div class="search-lab">
                <label for="dep">出发地：</label>
            </div>
            <div class="search-inp">
                <input id="dep" name="dep"  style="width: 111px"  required class="airport-input" value="北京首都">
                <div class="option-block" id="option-dep"></div>
            </div>

        </div>
        <div class="search-bar">
            <div class="search-lab">
                <label for="des">目的地：</label>
            </div>
            <div class="search-inp">
                <input id="des" name="des"  style="width: 111px" required class="airport-input" value="上海虹桥">
                <div class="option-block" id="option-des" ></div>
            </div>
        </div>
        <div class="search-bar">
            <div class="search-lab">
                <label for="des">日期：</label>
            </div>
            <div class="search-inp">
                <input type="date"   style="width: 120px"name="date" id="date" required style="width: 101px" value="2017-12-01">
            </div>
        </div>
        <div id="submit" class="submit">
            <input type="submit" value="搜索">
        </div>
    </div>

    <div id="ticket-items">
        <div id="ticket-item-description" class="ticket-item">
            <div class="ticket-item-airlineId">航班号</div>
            <div class="ticket-item-dep">出发地</div>
            <div class="ticket-item-dao"></div>
            <div class="ticket-item-des">目的地</div>
            <div class="ticket-item-date">出发日期</div>
            <div class="ticket-item-takeoffTime">起飞时间</div>
            <div class="ticket-item-landingTime">降落时间</div>
            <div class="ticket-item-stock">剩余</div>
        </div>
    </div>

    <script src="/javascript/jquery-3.2.1.js"></script>
    <script src="/javascript/mouseouver-event.js"></script>
    <script src="/javascript/airport-option.js"></script>
    <script src="/javascript/util.js"></script>
    <script src="/javascript/user-search.js"></script>'

</body>
</html>
