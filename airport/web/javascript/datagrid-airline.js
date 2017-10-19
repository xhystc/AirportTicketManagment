function deleteAirline(){
    if(editIndex===undefined || editIndex<0) return false;
    var row = $('#mydatagrid').datagrid('getRows')[editIndex];
    if(createIndex===editIndex){
        $('#mydatagrid').datagrid('deleteRow',editIndex);
    }else if(confirm('确认删除航班:'+row.id+'?')){
        $.post('/root/service/delete_airline',{airlineId:row.id},function (data) {
            if(data.result==="yes")
                alert('删除成功!');
            else
                alert('删除失败:'+data.tip);
        });
        $('#mydatagrid').datagrid('reload');
    }
    editIndex=undefined;
    createIndex=undefined;

}

function updateAirline() {
    if(editIndex===undefined || editIndex<0) return false;
    var $mydatagrid =  $('#mydatagrid');
    var row = $mydatagrid.datagrid('getRows')[editIndex];
    $mydatagrid.datagrid('endEdit',editIndex);
    row.plane="test plane";
    if(createIndex===editIndex){
        $.post('/root/service/create_airline',row,function (data) {
                if(data.result==="yes")
                    alert('添加成功!');
                else
                    alert('添加失败:'+data.tip);
        });
    }else {
        $.post('/root/service/update_airline', row, function (data) {
            if (data.result === "yes")
                alert('修改成功!');
            else
                alert('修改失败:' + data.tip);
        });
    }
    editIndex=undefined;
    createIndex=undefined;
    $mydatagrid.datagrid('reload');
}

function createAirline() {
    var $mydatagrid =  $('#mydatagrid');
    if(!endEditing($mydatagrid)){
        $mydatagrid.datagrid('selectRow',editIndex);
        return;
    }
    $mydatagrid.datagrid('insertRow',{
        index:0,
        row:{
            id:0,
            airlineId:0,
            dep:'',
            des:'',
            date:'2017-12-02',
            takeoffTime:'00:00',
            landingTime:'00:00',
            total:0,
            stock:0
        }
    });
    $mydatagrid.datagrid('beginEdit',0);
    $mydatagrid.datagrid('selectRow',0);
    editIndex=0;
    createIndex=0;
}

function airlineDetail() {
    if(createIndex!=undefined) return false;
    var targetAirline = $('#mydatagrid').datagrid('getRows')[$(event.target).attr('rowindex')];
    $('#ticketdatagrid').datagrid('options').url=' /root/service/easyui/search/tickets';
    $('#ticketdatagrid').datagrid('load',{
       id:targetAirline.id
    });

    if(endEditing($('#mydatagrid'))){
        $('#ticket-panel').panel('open');
    }
}

$('#mydatagrid').datagrid({
    height: 250,
    width:510,
    striped:true,
    url: '',
    queryParams:{
        dep:'',
        des:''
    },
    method: 'POST',
    idField: 'id',
    toolbar:'#toolbar',
    rownumbers:true,
    singleSelect:true,
    columns: [[
        { field: 'id', title: 'id', width: 40, align: 'center' },
        { field: 'dep', title: 'dep', width: 80, align: 'center',editor:{
            type: 'text'
        } },
        { field: 'des', title: 'des', width: 80, align: 'center', editor:{
            type: 'text'
        } },
        { field: 'takeoffHour', title: '时', width: 30, align: 'center',formatter:timeformatter,
            editor: {
                type: 'numberbox',
                options:{
                    min:0,
                    max:23
                }
            }},
        {field:'maohao',title:' ',width:10,align:'center',formatter:function (value,row,index) {
            return ':'
        }},
        { field: 'takeoffMin', title: '分', width: 30, align: 'center' ,formatter:timeformatter,
            editor: {
                type: 'numberbox',
                options:{
                    min:0,
                    max:59
                }
            }},
        {field:'gang',title:' ',width:20,align:'center',formatter:function (value,row,index) {
            return '-'
        }},
        { field: 'landingHour', title: '时', width: 30, align: 'center' ,formatter:timeformatter,
            editor: {
                type: 'numberbox',
                options:{
                    min:0,
                    max:23
                }
            }},
        {field:'maohao',title:' ',width:10,align:'center',formatter:function (value,row,index) {
            return ':'
        }},
        { field: 'landingMin', title: '分', width: 30, align: 'center' ,formatter:timeformatter,
            editor: {
                type: 'numberbox',
                options:{
                    min:0,
                    max:59
                }
            }},
        {field:'op',title: '操作', align: "center", formatter: function (value,row,index) {
            var s = '<input type="button" value="详细" style="width: 40px;height: 20px;font-size: small;align-content: center" onclick="airlineDetail()" rowindex='+'"'+index+'"'+'/>';
            return s;
        },width: 60}
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

function doSearch() {
    $('#mydatagrid').datagrid('options').url='/root/service/easyui/search/airlines';
    $('#mydatagrid').datagrid('load',{dep:$('#dep').val(),des:$('#des').val()});
}
















