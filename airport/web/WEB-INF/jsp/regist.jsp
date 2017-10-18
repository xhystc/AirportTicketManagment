<%--
  Created by IntelliJ IDEA.
  User: 87173
  Date: 2017/8/27
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/input-bar.css" type="text/css">
</head>
<body>
    <div id="tip">${requestScope.registTip}</div>
    <form action="#">
            <div id="input" class="input">
                <div class="tip"></div>
                <div class="input-bar">
                    <div id="username-tip" class="tip"></div>
                    <div class="input-lab">
                        <label>*用户名：</label>
                    </div>
                    <div class="input-inp">
                        <input  name="username" id="username">
                    </div>

                </div>
                <div  class="input-bar">
                    <div id="password-tip" class="tip"></div>
                    <div class="input-lab">
                        <label>*密 码：</label>
                    </div>
                    <div class="input-inp">
                        <input type="password" name="password" id="password">
                    </div>
                </div>

                <div class="input-bar">
                    <div id="repassword-tip" class="tip"></div>
                    <div class="input-lab">
                        <label>*重复密码：</label>
                    </div>
                    <div class="input-inp">
                        <input type="password" name="repassword" id="repassword">
                    </div>
                </div>
                <div class="input-button">
                <button type="submit" id="regist" >注册</button>
                </div>
            </div>

    </form>
    <script src="/javascript/jquery-3.2.1.js"></script>
    <script src="/javascript/regist-page.js"></script>
</body>
</html>














