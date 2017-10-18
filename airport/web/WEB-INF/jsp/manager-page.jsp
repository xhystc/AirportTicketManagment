<%--
  Created by IntelliJ IDEA.
  User: 87173
  Date: 2017/8/31
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/user-search.css">
    <link rel="stylesheet" type="text/css" href="/css/ticket-item.css">
    <link rel="stylesheet" type="text/css" href="/css/airline-item.css">
</head>
<body>



<div id="airport-option-template" class="airport-option-template" hidden></div>

<div id="airline-item-template" class="airline-item" hidden>
    <div class="airline-items-wapper">
        <div class="airline-item-airlineId"></div>
        <div class="airline-item-dep"></div>
        <div class="airline-item-dao">-></div>
        <div class="airline-item-des"></div>
        <div class="airline-item-takeoffTime"></div>
        <div class="airline-item-landingTime"></div>
        <div class="airline-item-plane"></div>
        <div class="airline-item-button-update"><button type="button" id="updateAirline">修改</button> </div>
        <div class="airline-item-button-delete"><button type="button" id="deleteAirline">删除</button> </div>
        <div class="airline-item-button-tickets"><button type="button" id="checkTicket">查看</button></div>
    </div>
    <div class="airline-ticket-items-wapper" hidden>
        <div id="create-ticket-block" class="create-ticket-block">
            <label>日期：</label><input type="date" class="dateCreate" size="10%"> <label>总数：</label><input class="totalCreate" name="totalCreate" size="10%">
            <input type="submit" id="create-ticket" value="创建">
        </div>
        <div class="ticket-items">
            <div class="ticket-item-description">
                <div class="ticket-item-ticketId">机票号</div>
                <div class="ticket-item-date">出发日期</div>
                <div class="ticket-item-stock">剩余</div>
                <div class="ticket-item-total">总数</div>
            </div>
        </div>
    </div>
</div>
<div id="ticket-item-template" class="ticket-item" hidden>
    <div class="ticket-item-ticketId"></div>
    <div class="ticket-item-date"></div>
    <div class="ticket-item-stock"></div>
    <div class="ticket-item-total"></div>
    <div class="ticket-item-button-update"><button type="button" id="updateTicket">修改</button> </div>
    <div class="ticket-item-button-delete"><button type="button" id="deleteTicket">删除</button> </div>
</div>

<div id="total-div">
    <div class="search-block">
        <div class="search-bar">
            <div class="search-lab">
                <label for="dep">出发地：</label>
            </div>
            <div class="search-inp">
                <input id="dep" name="dep"     class="airport-input" >
                <div class="option-block"></div>
            </div>

        </div>
        <div class="search-bar">
            <div class="search-lab">
                <label for="des">目的地：</label>
            </div>
            <div class="search-inp">
                <input id="des" name="des"   class="airport-input">
                <div class="option-block" ></div>
            </div>
        </div>

        <div  class="submit">
            <input type="submit" id="search" value="查询航班">
        </div>
    </div>


    <div class="create-block">
        <div class="create-bar">
            <div class="create-lab">
                <label for="dep">出发地：</label>
            </div>
            <div class="create-inp">
                <input id="depCreate" name="dep"    class="airport-input"  required>
                <div class="option-block"  ></div>
            </div>

        </div>
        <div class="create-bar">
            <div class="create-lab">
                <label for="des">目的地：</label>
            </div>
            <div class="create-inp">
                <input id="desCreate" name="des"  class="airport-input" required>
                <div class="option-block" ></div>
            </div>
        </div>
        <div class="create-bar">
            <div class="create-lab">
                <label for="createTakeoffTime">时间：</label>
            </div>
            <div  class="create-inp">
                <input type="time" name="takeoffTime" class="createTakeoffTime" id="createTakeoffTime">--<input type="time"name="landingTime" class="createLandingTime">
            </div>
        </div>
        <div class="create-bar">
            <div class="create-lab">
                <label>机号：</label>
            </div>
            <div class="create-inp">
                <input id="planeCreate" style="width: 111px" class="aiport-input" required>
            </div>
        </div>

        <div  class="submit">
            <input type="submit" id="create" value="创建航班">
        </div>
    </div>
</div>

<div id="airline-items">
    <div id="airline-item-description" class="airline-item">
        <div class="airline-item-airlineId">航班号</div>
        <div class="airline-item-dep">出发地</div>
        <div class="airline-item-dao"></div>
        <div class="airline-item-des">目的地</div>
        <div class="airline-item-takeoffTime">起飞时间</div>
        <div class="airline-item-landingTime">降落时间</div>
        <div class="airline-item-plane">机号</div>
    </div>
</div>
<script src="/javascript/jquery-3.2.1.js"></script>
<script src="/javascript/util.js"></script>
<script src="/javascript/airport-option.js"></script>
<script>
    function loadTickets($ticketItems,param) {

        $.post("/root/service/search/ticketsByAirline",param,function (data) {
            $ticketItems.children().not('.ticket-item-description').remove();
            console.log(data);
            var tickets = data.tickets;
            for(var i in tickets){
                var $ticketItem = $('#ticket-item-template').clone(true);
                $ticketItem.attr('ticketId',tickets[i].id);
                var $children = $ticketItem.children();
                $ticketItem.attr('hidden',false);

                var date = new Date(tickets[i].date);
                $children.filter('.ticket-item-ticketId').text(tickets[i].id);
                $children.filter('.ticket-item-date').text(dateToString(date));
                $children.filter('.ticket-item-stock').text(tickets[i].stock);
                $children.filter('.ticket-item-total').text(tickets[i].total);

                $ticketItem.appendTo($ticketItems);
            }
        });
    }
    $('#updateTicket').click(function (evt) {
        var $target = $(evt.target).parent().prevAll();
        if($target.attr('updateToken')===undefined || $target.attr('updateToken')===null){
            $target.attr('updateToken',"input");
            var $temp =  $target.filter('.ticket-item-date');
            var temp = $temp.text().split("-");
            $temp.html('').append('<input class="createYear" style="width: 40px">-')
                .append('<input class="createMonth" style="width: 20px">-')
                .append('<input class="createDay" style="width: 20px">')

            $temp.children('.createYear').val(temp[0]);
            $temp.children('.createMonth').val(temp[1]);
            $temp.children('.createDay').val(temp[2]);

            $temp = $target.filter('.ticket-item-total');
            temp = $temp.text();
            $temp.html('').append('<input class="createTotal" style="width:40px;">').children().val(temp);
        }else {
                var ticketId = $target.parent().attr('ticketId');
                var total = $target.find('.createTotal').val();
                var year = $target.find('.createYear').val();
                var month = $target.find('.createMonth').val();
                var day = $target.children('.createDay').val();
                var param = {
                    ticketId:ticketId,
                    year:year,
                    month:month,
                    day:day,
                    total:total
                };
                console.log("param:"+param);

                $.post('/root/service/update_ticket',param,function (data) {
                        if(data.result=="yes"){
                            var ticket = data.ticket;
                            $target.filter('.ticket-item-date').html(dateToString(new Date(ticket.date )));
                            $target.filter('.ticket-item-stock').html(ticket.stock);
                            $target.filter('.ticket-item-total').html(ticket.total);
                            $target.attr('updateToken',null);
                        }else
                            console.log(data.tip);
                });
        }
    });
    $('#updateAirline').click(function (evt) {
            var $target = $(evt.target).parent().prevAll();
            if($target.attr('updateToken')===undefined || $target.attr('updateToken')===null){
                $target.attr('updateToken',"input");
                var $temp =  $target.filter('.airline-item-dep');
                var temp = $temp.text();
                $temp.html('').append($('.search-inp').last().clone(true));
                $temp.children().children('input').val(temp);

                $temp =  $target.filter('.airline-item-des');
                temp = $temp.text();
                $temp.html('').append($('.search-inp').last().clone(true));
                $temp.children().children('input').val(temp);

                $temp = $target.filter('.airline-item-takeoffTime');
                temp = $temp.text().split(":");
                $temp.html('').append('<input class="createTakeoffHour" style="width: 30px;margin-top: 0px"> : ').children().val(temp[0]);
                $temp.append('<input class="createTakeoffMin" style="width: 30px;margin-top: 0px">').children().last().val(temp[1]);

                $temp = $target.filter('.airline-item-landingTime');
                temp = $temp.text().split(":");
                $temp.html('').append('<input class="createLandingHour" style="width: 30px;margin-top: 0px"> : ').children().val(temp[0]);
                $temp.append('<input class="createLandingMin" style="width: 30px;margin-top: 0px">').children().last().val(temp[1]);

                $temp = $target.filter('.airline-item-plane');
                temp = $temp.text();
                $temp.html('').append('<input class="createPlane" style="width:60px;">').children().val(temp);


            }else {

                var dep = $target.filter('.airline-item-dep').find('.airport-input').val();
                var des = $target.filter('.airline-item-des').find('.airport-input').val();
                var takeoffHour = $target.filter('.airline-item-takeoffTime').find('.createTakeoffHour').val();
                var takeoffMin = $target.filter('.airline-item-takeoffTime').find('.createTakeoffMin').val();
                var landingHour = $target.filter('.airline-item-landingTime').find('.createLandingHour').val();
                var landingMin =  $target.filter('.airline-item-landingTime').find('.createLandingMin').val();
                var plane =$target.filter('.airline-item-plane').find('.createPlane').val();
                console.log("dep:"+dep+" des:"+des+" takeoffHour:"+takeoffHour);
                var param={
                    airlineId:$(evt.target).parent().parent().parent().attr('airlineId'),
                    dep:dep,
                    des:des,
                    takeoffHour:takeoffHour,
                    takeoffMin:takeoffMin,
                    landingHour:landingHour,
                    landingMin:landingMin,
                    plane:plane
                };

                $.post('/root/service/update_airline',param,function (data) {
                        if(data.result==="yes"){
                            var airline = data.airline;
                            $target.attr('updateToken',null);
                            var $temp =  $target.filter('.airline-item-dep');
                            $temp.html(airline.departure.name);

                            $temp = $target.filter('.airline-item-des');
                            $temp.html(airline.destination.name);

                            $temp = $target.filter('.airline-item-takeoffTime').html(getAirlineTime(airline,"takeoff"));
                            $temp = $target.filter('.airline-item-landingTime').html(getAirlineTime(airline,"landing"));
                            $('#search').click();
                        }
                        else {
                            console.log(data.tip);
                        }
                });

            }
    });

    $('#create-ticket').click(function (evt) {
            console.log($(evt.target).prevAll().filter('.dateCreate').val());
            var date =$(evt.target). prevAll().filter('.dateCreate').val().split("-");

            var param={
                total:$(evt.target).prevAll().filter('.totalCreate').val(),
                year:date[0],
                month:date[1],
                day:date[2],
                airlineId:$(evt.target).parent().parent().parent().attr('airlineId')
            };
            console.log(param);
            $.post('/root/service/create_ticket',param,function (data) {
                if(data.result==="yes")
                {
                    alert("添加成功");
                    var $temp = $(evt.target).parent().parent().prev();
                    $(evt.target).parent().next().attr('loaded',null);
                    $temp.find('.airline-item-button-tickets button').click();
                }
                else
                    alert(data.tip);
            });
            return false;
    });

    $('#create').click(function (evt) {
                var takeoffTime = $('#createTakeoffTime').val().split(":");
                var landingTime = $('#createLandingTime').val().split(":");
                var param = {
                    dep:$('#depCreate').val(),
                    des:$('#desCreate').val(),
                    takeoffHour:takeoffTime[0],
                    takeoffMin:takeoffTime[1],
                    landingHour:landingTime[0],
                    landingMin:landingTime[1],
                    plane:$('#planeCreate').val()
                };
                $.post('/root/service/create_airline',param,function (data) {
                        if(data.result==="yes")
                        {
                            alert("添加成功");
                            $('#search').click();
                        }
                        else
                            alert(data.tip);
                });
                return false;
    });


    $('#deleteAirline').click(function (evt) {
            var $airlineItem = $(this).parent().parent().parent();
            var param = {
                airlineId : $airlineItem.attr('airlineId')
            };
            if(window.confirm('确定删除 航班:'+$airlineItem.attr('airlineId')+'?')===true){
                $.post('/root/service/delete_airline',param,function (data) {
                        if(data.result==="yes"){
                            alert("删除成功");
                        }else {
                            alert(data.tip);
                        }
                    $('#submit').click();
                });

            }
            return false;

    });
    $('#deleteTicket').click(function (evt) {
            var $ticketItem = $(this).parent().parent();
            var param={
                ticketId:$ticketItem.attr('ticketId')
            };
            if(confirm("确定删除 机票:"+$ticketItem.attr('ticketId')+"?")===true){
                    $.post('/root/service/delete_ticket',param,function (data) {
                            if(data.result==="yes"){
                                alert("删除成功");
                            }else {
                                alert(data.tip);
                            }
                            var $parent =  $ticketItem.parent();
                            console.log( $parent.attr('loaded'));
                             $parent.attr('loaded',null);
                             $parent.parent().prev().find('.airline-item-button-tickets button').click();
                    });
            }
    });
    $('#checkTicket').click(function (evt) {
            var $ticketItems = $(this).parent().parent().next().children('.ticket-items');

            if($ticketItems.attr('loaded')===undefined || $ticketItems.attr('loaded')===null){
                $('.airline-ticket-items-wapper').hide();
                var param={
                    airlineId:$(this).parent().parent().parent().attr('airlineId')
                };
                $ticketItems.parent().show();
                loadTickets($ticketItems,param);
                $ticketItems.attr('loaded',"yes");
            }
            else {

                var $target = $(this).parent().parent().next();
                if (!$target.is(':hidden'))
                    $target.hide();
                else{
                    $('.airline-ticket-items-wapper').hide();
                    $target.show();
                }
            }
            return false;
    });

    $('#search').click(function (evt) {
        $('#airline-items').children().not('#airline-item-description').remove();
       var param = {
           dep:$('#dep').val(),
           des:$('#des').val()
       };
       $.post('/root/service/search/airlines',param,function (data) {
           console.log(data);
          if(data.result==="yes"){
                var airlines = data.airlines;

                for(var i in airlines){
                    var $airline = $('#airline-item-template').clone(true);
                    $airline.attr('airlineId',airlines[i].id);
                    var $children = $airline.children().filter('.airline-items-wapper').children();
                    $airline.attr('hidden',false);
                    $children.filter('.airline-item-airlineId').text(airlines[i].id);
                    $children.filter('.airline-item-dep').text(airlines[i].departure.name);
                    $children.filter('.airline-item-des').text(airlines[i].destination.name);
                    $children.filter('.airline-item-takeoffTime').text(getAirlineTime(airlines[i],"takeoff"));
                    $children.filter('.airline-item-landingTime').text(getAirlineTime(airlines[i],"landing"));
                    $children.filter('.airline-item-plane').text(airlines[i].plane);
                    $airline.appendTo('#airline-items');
                }
        }else {
              console.log(data.tip);

          }

       });
       return false;
    });

</script>
</body>
</html>



















