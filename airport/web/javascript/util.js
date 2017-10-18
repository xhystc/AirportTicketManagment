function dateToString(curr) {
    var day = curr.getDate()<9?("0"+curr.getDate()):(""+curr.getDate());
    var month = curr.getMonth()+1<9?("0"+(curr.getMonth()+1)):(""+(curr.getMonth()+1));
    var date = ""+curr.getFullYear()+"-"+month+"-"+day;
    return date;
}
function getAirlineTime(airline,type) {
    if(type==="takeoff"){
        var takeoffHour = airline.time.takeoffHour>9?(""+airline.time.takeoffHour):("0"+airline.time.takeoffHour);
        var takeoffMin = airline.time.takeoffMinute>9?(""+airline.time.takeoffMinute):("0"+airline.time.takeoffMinute);
        return takeoffHour+":"+takeoffMin;
    }
    else if(type==="landing"){
        var landingHour = airline.time.landingHour>9?(""+airline.time.landingHour):("0"+airline.time.landingHour);
        var landingMin = airline.time.landingMinute>9?(""+airline.time.landingMinute):("0"+airline.time.landingMinute);
        return landingHour+":"+landingMin;
    }
    else return undefined;
}