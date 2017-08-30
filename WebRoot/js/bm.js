//根据bookId获取寻找对应的书本
function reviseBook(bookId){
	location.href="queryBook?bookId="+bookId;
}

function deleteBook(bookId){
	if(confirm("你确定要删除这本书吗?")){
		location.href="deleteBook?id="+bookId;
	}
}
