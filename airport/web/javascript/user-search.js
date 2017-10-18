
var curr = new Date();

$('#date').prop('min',dateToString(curr));
$('#submit').click(function (evt) {
    var dep = $('#dep').val();
    var des = $('#des').val();
    var date = $('#date').val();
    if(dep.length<4 || des.length<4 || date==="")
    {
        console.log("<4");
        return false;
    }
    var param={
        dep:dep,
        des:des,
        date:date
    };
    console.log(param);

    !$('#ticket-items').children().not('#ticket-item-description').remove();

    $.post('/service/search/tickets',param,function (data) {
        console.log(data);
        if(data.result==="yes"){
            var tickets = data.tickets;
            for(var i in tickets){
                var $ticketItem = $('#ticket-item-template').clone(true);
                $ticketItem.attr('ticketId',tickets[i].id);
                var $children = $ticketItem.children();
                var airline = tickets[i].airline;
                $ticketItem.attr('hidden',false);
                console.log("airlineId:"+tickets[i].airline.id);
                $children.filter('.ticket-item-airlineId').text(airline.id);
                $children.filter('.ticket-item-dep').text(airline.departure.name);
                $children.filter('.ticket-item-des').text(airline.destination.name);
                var date = new Date(tickets[i].date);
                $children.filter('.ticket-item-date').text(dateToString(date));
                $children.filter('.ticket-item-stock').text(tickets[i].stock);
                $children.filter('.ticket-item-takeoffTime').text(getAirlineTime(airline,"takeoff"));
                $children.filter('.ticket-item-landingTime').text(getAirlineTime(airline,"landing"));

                $ticketItem.appendTo('#ticket-items');
            }

        }
    });
    return false;
});

$('#buyTicket').click(function (evt) {

    window.location='/check_order?'+'ticketId='+$(this).parent().parent().attr('ticketId');
});