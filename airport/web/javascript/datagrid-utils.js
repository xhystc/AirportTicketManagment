function extendCopy(p) {
    var c = {};
    for (var i in p) {
        c[i] = p[i];
    }
    c.uber = p;
    return c;
}
var editIndex=undefined;
var createIndex=undefined;
var preRow=undefined;

function timeformatter(value,row,index) {
    var i = value;
    return i>9?i:"0"+i;
}

function endEditing(target){
    if(target.attr('flag')==='airline' && $('#ticket-panel').panel('options').closed===false) return false;
    if(createIndex!==undefined)return false;
    if(editIndex == undefined){return true}
    target.datagrid('endEdit', editIndex);
    target.datagrid('updateRow', preRow);
    preRow=undefined;
    editIndex=undefined;
}

function onDbClickRow(index) {
    if (editIndex !== index) {
        if (endEditing($(this))) {
            editIndex = index;
            $(this).datagrid('beginEdit', editIndex);
            preRow = extendCopy($(this).datagrid('getRows')[editIndex]);
            console.log(preRow);
        }else {
            $(this).datagrid('selectRow', editIndex);
        }
    }
}
function onClickRow(index) {
    if (endEditing($(this))){
        if(editIndex !== index && editIndex!=undefined){
                $(this).datagrid('endEdit', editIndex);
                $(this).datagrid('selectRow', index);
                editIndex = undefined;
                preRow=undefined;
            }else {
                $(this).datagrid('selectRow', editIndex);
            }
        }

}







