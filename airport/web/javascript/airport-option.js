$('.airport-input').bind('input',function (evt) {
    var param={
        airport:$(this).val()
    };

    $('.airport-option').remove();
    var target = this;
    if($(this).val()==="")
        return;
    $.post('/service/search/airports',param,function (data) {
        var $clone =  $('#airport-option-template').clone(true);
        $clone.attr('hidden',false);
        $clone.addClass("airport-option");

        if(data.result==="yes") {
            var airports  = data.rows;

            if(airports===null || airports.length===0) {
                $clone.text('找不到机场');
                $clone.appendTo($(target).next());
            }
            else {
                for(var i in airports){
                    $clone.text(airports[i].name);
                    $clone.appendTo($(target).next());
                }
            }
        }
        else {
            console.log("no");
            $clone.text('找不到机场');
            $clone.appendTo($(target).next());
        }
    });

});

$('input').focus(function () {
    $('.airport-option').remove();
});
$('#airport-option-template').on("mouseout",function (evt) {
    $(evt.target).css("color",mouseOverLastColor).css('cursor','auto').css("background-color",mouseOverLastBackground);
});
$('#airport-option-template').on('mouseover',function (evt) {
    mouseOverLastBackground = $(evt.target).css("background-color");
    mouseOverLastColor =$(evt.target).css("color");
    $(evt.target).css("color","white").css('cursor','pointer').css("background-color","#3385FF");
});
$('.option-block').on('mouseup',function (evt) {
    var $target = $(evt.target).css('cursor','auto');
    $($target).parent().prev().val($target.text());
    $('.airport-option').remove();

});



















