<%@ page import="com.xhystc.airport.bean.result.GeneralResultBean" %>
<%@ page import="com.xhystc.airport.entities.AirlineTime" %>
<%@ page import="com.xhystc.airport.entities.Ticket" %>
<%@ page import="com.xhystc.airport.bean.result.TicketOrderResult" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: 87173
  Date: 2017/8/29
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/input-bar.css" type="text/css">
</head>
<body>
    <%
        Ticket result = (Ticket) request.getAttribute("ticket");
        AirlineTime time = result.getAirline().getTime();
        String takeoffTime = time.getTakeoffHour()>9?(""+time.getTakeoffHour()):("0"+time.getTakeoffHour());
        takeoffTime+=":";
        takeoffTime+=time.getTakeoffMinute()>9?(""+time.getTakeoffMinute()):("0"+time.getTakeoffMinute());
        String landingTime = time.getLandingHour()>9?(""+time.getLandingHour()):("0"+time.getLandingHour());
        landingTime+=":";
        landingTime+=time.getLandingMinute()>9?(""+time.getLandingMinute()):("0"+time.getLandingMinute());
        String dateString = result.getDate().get(Calendar.YEAR)+"-"+(result.getDate().get(Calendar.MONTH)+1)+result.getDate().get(Calendar.DAY_OF_MONTH);

    %>
    <div class="input">
        请确认机票信息!!<br>
        出发地：${ticket.airline.departure.name}<br/>
        目的地：${ticket.airline.destination.name}<br/>
        日期：<%=dateString%><br/>
        时间：<%=takeoffTime%> -- <%=landingTime%><br/>
        <div id="checkdiv">
            <form>
                <div class="check-bar">
                    <div class="check-lab">
                        <label>用户名：</label>
                    </div>
                    <div class="check-input">
                        <input name="username" id="username">
                    </div>
                </div>
                <div class="check-bar">
                    <div class="check-lab">
                        <label>密码：</label>
                    </div>
                    <div class="check-input">
                        <input name="password" type="password" id="password">
                    </div>
                </div>
                <div class="check-button">
                    <button type="submit" id="submit">确认</button>
                </div>
            </form>
        </div>
    </div>
    <script src="/javascript/jquery-3.2.1.js"></script>
    <script>
        $('#submit').click(function (evt) {
           var param={
              username:$('#username').val(),
              password:$('#password').val()
           };
           $.post('/service/do_order',param,function (data) {
               if(data.result==="yes"){
                   alert("订购成功!");
               }
               else {
                   alert("订购失败:"+data.tip);
               }
               window.location='/index';
           });
           return false;
        });
    </script>
</body>
</html>












