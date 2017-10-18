function getOrders(data) {
    if(data.result==="yes"){
        var orders = data.orders;
        for(var i in orders){
            var $orderItem = $('#order-item-template').clone(true);
            console.log(orders[i].id);
            $orderItem.attr('orderId',orders[i].id);
            var $children = $orderItem.children();
            var airline = orders[i].ticket.airline;
            $orderItem.attr('hidden',false);
            //   console.log("airlineId:"+orders[i].ticket.id);
            console.log(orders[i]);
            $children.filter('.order-item-id').text(airline.id);
            $children.filter('.order-item-dep').text(airline.departure.name);
            $children.filter('.order-item-des').text(airline.destination.name);
            var date = new Date(orders[i].date);
            var ticketDate = new Date(orders[i].ticket.date);
            var currentDate = new Date();
            $children.filter('.order-item-date').text(dateToString(ticketDate));
            $children.filter('.order-item-orderDate').text(dateToString(date));
            $children.filter('.order-item-takeoffTime').text(getAirlineTime(airline,"takeoff"));
            $children.filter('.order-item-landingTime').text(getAirlineTime(airline,"landing"));
            var ticketDateValue = parseInt(dateToString(ticketDate).replace(/-/g,""));
            var currentDateValue = parseInt(dateToString(currentDate).replace(/-/g,""));
            if(ticketDateValue>currentDateValue){
                $children.children().filter('button').attr('hidden',false);
            }
            $orderItem.appendTo('#order-items');
        }

    }
    else {
        alert(data.tip);
        window.location='/index';
    }
}
$('#backTicket').click(function (evt) {
    var $orders =  $(this).parent().parent();
    var orderId = $orders.attr('orderId');
    console.log(orderId);
    var param={
        orderId:orderId
    };
    $.post('/service/back_order',param,function (data) {
        if(data.result==="yes"){
            $('#order-items').children().not('#order-description').remove();
            $.post('/service/user_order',null,getOrders);
        }
        else {
            alert(data.tip);
        }
    });
});
$.post('/service/user_order',null,getOrders);