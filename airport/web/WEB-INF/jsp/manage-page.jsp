<%--
  Created by IntelliJ IDEA.
  User: 87173
  Date: 2017/10/12
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/jquery-easyui/themes/default/easyui.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/jquery-easyui/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="/css/draggdiv.css" type="text/css">
</head>
<body>

<div class="airline-wapper">
    <div id="mydatagrid" title="Airlines" class="easyui-datagrid" flag="airline"></div>

</div>
<div id="toolbar">
    <span>出发地:</span>
    <input id="dep" style="line-height:15px;border:1px solid #ccc;width:80px;font-size: small">
    <span>目的地:</span>
    <input id="des" style="line-height:15px;border:1px solid #ccc;width:80px">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()"  iconCls="icon-search"></a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="createAirline()" style="width:65px">New</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="updateAirline()" style="width:75px">Update</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAirline()" style="width:75px">Remove</a>
</div>

<div class="ticket-wapper">
    <div id="ticket-panel" class="easyui-panel"  title="Tickets"
         style="width:350px;height:220px;padding:10px;background:#fafafa;"
         data-options="iconCls:'icon-save',closable:true,
    collapsible:true,minimizable:true,maximizable:true"
         closed="true">
        <div id="ticketdatagrid" title="My Users" class="easyui-datagrid" flag="ticket">

        </div>
    </div>
</div>
<div id="ticket-toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="createTicket()" style="width:75px">New</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="" style="width:80px">Update</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteTicket()" style="width:85px">Remove</a>
</div>

<script src="/jquery-easyui/jquery.min.js"></script>
<script src="/jquery-easyui/jquery.easyui.min.js"></script>
<script src="/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="/javascript/datagrid-utils.js"></script>
<script src="/javascript/datagrid-airline.js"></script>

<script>
    $('#ticketdatagrid').datagrid({
        height: 160,
        width:350,
        striped:true,
        url: '',
        method: 'POST',
        idField: 'id',
        toolbar:'#ticket-toolbar',
        rownumbers:true,
        singleSelect:true,
        columns: [[
            { field: 'id', title: 'id', width: 40, align: 'center' },
            { field: 'date', title: 'date', width: 80, align: 'center',editor:{
                type: 'datebox'
            } },
            { field: 'total', title: 'total', width: 80, align: 'center', editor:{
                type: 'numberbox',
                options:{
                    min:0,
                    max:999
                }
            } },
            { field: 'stock', title: 'stock', width: 80, align: 'center', editor:{
                type: 'numberbox',
                options:{
                    min:0,
                    max:999
                }
            } }
        ]],
        onBeforeLoad: function (param) {
        },
        onLoadSuccess: function (data) {

        },
        onLoadError: function () {

        },
        onDblClickRow:onDbClickRow,
        onClickRow:onClickRow
    });

</script>
</body>
</html>



















