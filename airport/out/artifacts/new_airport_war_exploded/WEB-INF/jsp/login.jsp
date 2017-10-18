<%--
  Created by IntelliJ IDEA.
  User: 87173
  Date: 2017/8/27
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/css/input-bar.css" >
    <meta charset="utf-8">

</head>
<body>
<br>
<form action="#">
       <div class="input">
           <div id="login-tip" class="tip">${loginTip}</div>
           <div class="input-bar">
               <div class="tip" id="username-tip"></div>
               <div>
                   <div class="input-lab">
                       <label for="username">用户名：</label>
                   </div>
                   <div class="input-inp">
                       <input  name="username" id="username">
                   </div>
               </div>
           </div>
           <div class="input-bar">
               <div class="tip" id="password-tip"></div>
               <div>
                   <div class="input-lab">
                       <label for="password">密&nbsp;&nbsp;码：</label>
                   </div>
                   <div class="input-inp">
                       <input type="password" name="password" id="password">
                   </div>
               </div>
           </div>
           <div class="input-button">
               <button type="submit" id="login">登录</button>&nbsp;&nbsp;&nbsp;<a href="/regist_page">注册</a>
           </div>
       </div>

</form>
<script src="/javascript/jquery-3.2.1.js"></script>
<script src="/javascript/login-page.js"></script>
</body>
</html>

