
$('#login').click(function (evt) {
    var username = $("form input[name='username']").val();
    var password = $("form input[name='password']").val();

    if (username.length <= 0) {
        $('#username-tip').text("用户名不能为空");
        return false;
    }
    else {
        $('#username-tip').text(" ");
    }
    if (password.length <= 0) {
        $('#password-tip').text("密码不能为空");
        return false;
    }
    else{
        $('#password-tip').text(" ");
    }
    var param = {
        username: "",
        password: ""
    };
    param.username = username;
    param.password = password;
    console.log("start");
    $.ajax(
        "/service/login",
        {
            method: "post",
            dataType: "json",
            data: param,
            success: function (data) {
                console.log(data.tip);
                if (data.result === "no") {
                    $('#login-tip').text(data.tip);
                }
                else if (data.result==="yes"){
                    console.log("yes");
                    $(window).attr('location', "/index");
                }
            },
            complete: function () {
                console.log("com");
            }
        }
    );

    return false;
});























