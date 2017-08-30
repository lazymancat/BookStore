function deleteBookType(){
	if(confirm("Sure to delete it?")){
		var typeId = document.getElementById("bookTypeId").value;
		location.href="deleteBookType?typeId="+typeId;
	}
}

function reviseBookType(){
	if(confirm("Sure to revise it?")){
		var typeId = document.getElementById("reviseTypeId").value;
		var typeName = document.getElementById("reviseTypeName").value;
		location.href="reviseBookType?bookType.typeId="+typeId+"&bookType.typeName="+typeName;
	}
}