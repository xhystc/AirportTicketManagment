
var usernameValidate=false;
var passwordValidate = false;
var repasswordValidate = false;
$('#username').bind('input propertychange',function (evt) {
    var username = $(this).val();
    if(username.length<4 || username.length>20)
    {
        $('#username-tip').html('用户名应当在4-20个字符之间');
        usernameValidate=false;
    }
    else
    {
        $('#username-tip').html(' ');
        usernameValidate=true;
    }
});
$('#password').bind('input propertychange',function (evt) {
    var password = $(this).val();
    if(password.length<4 || password.length>20)
    {
        $('#password-tip').html('密码应当在4-20个字符之间');
        passwordValidate=false;
    }
    else
    {
        $('#password-tip').html(' ');
        passwordValidate=true;
    }
});
$('#repassword').bind('input propertychange',function (evt) {
    var repass = $('#repassword').val();
    if(repass===$('#password').val())
    {
        $('#repassword-tip').html(' ');
        repasswordValidate=true;
    }
    else
    {
        $('#repassword-tip').text('与密码不一致');
        repasswordValidate=false;

    }
});
$('#regist').click(function (evt) {

    if(repasswordValidate && passwordValidate && usernameValidate){
        var param={};
        param.username=$('#username').val();
        param.password=$('#password').val();
        $.post('/service/regist',param,function (data) {
            if(data.result=="yes")
                $(window).attr('location','/login_page');
            else
                $('#tip').text(data.tip);
        });
    }
    return false;
});

