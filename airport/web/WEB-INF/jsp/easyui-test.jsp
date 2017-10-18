<%--
  Created by IntelliJ IDEA.
  User: 87173
  Date: 2017/10/11
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/jquery-easyui/themes/default/easyui.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/jquery-easyui/themes/icon.css" type="text/css">
</head>
<body>
<table id="dg" title="My Users" class="easyui-datagrid" style="width:550px;height:250px"
       url="/service/search/easyui/tickets?des=&dep=&date=2017-12-01"
       toolbar="#toolbar" idField="id"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50" >id</th>
        <th field="airlineId" width="50" editor="text">airlineId</th>
        <th field="dep" width="50" editor="{type:'validatebox',options:{required:true}}">dep</th>
        <th field="des" width="50" editor="text">des</th>
        <th field="date" width="50" editor="{type:'validatebox',options:{required:true,validType:'date'}}">date</th>
        <th field="takeoffTime" width="50" >takeoffTime</th>
        <th field="landingTime" width="50">landingTime</th>
        <th field="total" width="50" editor="text">total</th>
        <th field="stock" width="50" editor="text">stock</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').datagrid('addRow')">New User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>
<script src="/javascript/jquery-3.2.1.js"></script>
<script src="/jquery-easyui/jquery.easyui.min.js"></script>
<script src="/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="/jquery-easyui/plugins/jquery.datagrid.js"></script>

</body>
</html>
