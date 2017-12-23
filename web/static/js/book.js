
function addRow() {
    var class_dict={0:"table-info",1:"table-success",2:"table-danger",3:"table-warning",4:"table-active",5:""};
    var bookTable=document.getElementById('bookTable');
    var rows=bookTable.rows.length;
    var new_Tr=bookTable.insertRow(rows);
    var pos = getRandom() % 6;
    new_Tr.className=class_dict[pos]+" trs";
    var cell0=new_Tr.insertCell(0);
    var cell1=new_Tr.insertCell(1);
    var cell2=new_Tr.insertCell(2);
    var cell3=new_Tr.insertCell(3);
    var cell4=new_Tr.insertCell(4);
    var cell5=new_Tr.insertCell(5);
    var cell6=new_Tr.insertCell(6);
    cell0.innerHTML="<input class='myInputs' id='markName' name='addBookName' type='text' />";
    cell1.innerHTML="<input class='myInputs' name='addBookPrice' type='text' />";
    cell2.innerHTML="<input class='myInputs' name='addBookAuthor' type='text' />";
    cell3.innerHTML="<input class='myInputs' id='markPublisher' name='addBookPublisher' type='text' />";
    cell4.innerHTML="<input class='myInputs' name='addBookNumber' type='number' />";
    cell5.innerHTML="<input name=\"operationAdd\" type=\"submit\" value=\"添加\" class=\"btn-success addSubmit\"/>";
    cell6.innerHTML="<input name=\"operationDelete\" type=\"button\" value=\"删除\" onclick='addRowPromptDelete(this)' class=\"btn-info addSubmit\"/>";
}
function getRandom() {
    return Math.floor(Math.random()*10);
}
function getRowObj(obj) {
    var i=0;
    while(obj.tagName.toLowerCase()!=="tr"){
        obj=obj.parentNode;
        if(obj.tagName.toLowerCase()==="table")
            return null;
    }
    return obj;
}
function getRowIndex(obj) {
    var trObj=getRowObj(obj);
    var trArr;
    if(trObj!=null)trArr=trObj.parentNode.children;
    var trIndex;
    for(trIndex=0;trIndex<trArr.length;trIndex++){
        if(trObj===trObj.parentNode.children[trIndex])
            return trIndex+1;
    }
    return -1;
}
function myModify(obj) {
    var clickIndex=getRowIndex(obj);
    document.getElementById('rowIndex').value=clickIndex;
    //alert(clickIndex);
    document.getElementById('operationModify').value="修改";
    var strModifyNum=document.getElementsByName('modifyNumber');
    //alert(strModifyNum[clickIndex-1].value);
    document.getElementById('modifyTrueNum').value=strModifyNum[clickIndex-1].value;
    document.getElementById('myForm').submit();
}
function promptBeforeDelete(obj) {
    var clickIndex=getRowIndex(obj);
    // alert(clickIndex);
    document.getElementById('rowIndex').value=clickIndex;
    document.getElementById('operationDelete').value="删除";
    if(confirm("您确定要删除该项吗？")){
        var myForm=document.getElementById('myForm');
        myForm.submit();
    }
}
function addRowPromptDelete(obj) {
    var clickIndex=getRowIndex(obj);
    // alert(clickIndex);
    var bookTable=document.getElementById('bookTable');
    bookTable.deleteRow(clickIndex);
}