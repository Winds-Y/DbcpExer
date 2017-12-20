
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
    cell0.innerHTML="<input class='myInputs' name='addBookName' type='text' />";
    cell1.innerHTML="<input class='myInputs' name='addBookPrice' type='text' />";
    cell2.innerHTML="<input class='myInputs' name='addBookAuthor' type='text' />";
    cell3.innerHTML="<input class='myInputs' name='addBookPublisher' type='text' />";
    cell4.innerHTML="<input class='myInputs' name='addBookNumber' type='number' />";
    cell5.innerHTML="<input name=\"operationAdd\" type=\"submit\" value=\"添加\" class=\"btn-success addSubmit\"/>";
    cell6.innerHTML="<input name=\"operationDelete\" type=\"button\" value=\"删除\" onclick='promptBeforeDelete()' class=\"btn-info addSubmit\"/>";
}
function getRandom() {
    return Math.floor(Math.random()*10);
}
function promptBeforeDelete() {
    document.getElementById('operationDelete').value="删除";
    var flag=document.getElementsByName('addBookName').innerText==null ||
        document.getElementsByName('addBookPublisher').innerText==null;
    if(confirm("您确定要删除该项吗？")){
        var myForm=document.getElementById('myForm');
        if(!flag)
            myForm.submit();
        else{
            var bookTable=document.getElementById('bookTable');
            trs=bookTable.getElementsByTagName('tr');
            bookTable.deleteRow(trs.length-1);
        }
    }
}