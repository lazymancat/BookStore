//JS判定图书页数是否为空和是否为整数
function check(str){
	var temp = "";
	for(var i = 0; i < str.length; i++){
		if(str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57)
			temp += str.charAt(i);
	}
	temp = parseInt(temp);
	
	if(temp > 9999)
		temp = 9999;
		
	if(isNaN(temp))
		temp = 0;
	return temp;
}

//检查图书价格是否为正数
function checkFloat(str){
	var temp = "";
	var k = 0;
	for(var i = 0; i < str.length; i++){
		if(str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57){
			temp += str.charAt(i);
		}else if(str.charCodeAt(i)==46&&k<=0){
			temp +=str.charAt(i);
			k++;
		}
	}
	temp = parseFloat(temp);
	
	if(temp > 9999)
		temp = 9999;
		
	if(isNaN(temp))
		temp = 0;
	return temp;
}

//JS判定图书页数是否为空和是否为整数
function checkBookWordCount(){
	var bookWordCount = document.getElementById("BookWordCount").value;
	var $checkBookWordCountInfo = $("#checkBookWordCountInfo");
	$checkBookWordCountInfo.html("");
	if (bookWordCount=='') 
	{
		$checkBookWordCountInfo.html("*不能为空").css('color','#FF5151');
	}else if(bookWordCount%1!=0){
		$checkBookWordCountInfo.html("*必须为整数").css('color','#FF5151');
	}else if(bookWordCount.indexOf('.')>-1){
		$checkBookWordCountInfo.html("*请输入完整的整数").css('color','#FF5151');
		
	}
}

//JS判定修改内容是否为空
function checkEmpty(name){
	var book = document.getElementById(name).value;
	var $checkInfo = $("#check"+name+"Info");
	$checkInfo.html("");
	if (book=='') 
	{
// alert("username is required");
		$checkInfo.html("*不能为空").css('color','#FF5151');
// document.getElementById("submit").disabled = true;
	}
}

//判定选择的文件是否为图片
function changeImage(img){
	var url = img.value; 
    var fileext=url.substring(url.lastIndexOf("."),url.length);      
    fileext=fileext.toLowerCase()
    
    if((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp')&&fileext!=null){   
        alert("Wrong Image!");
        document.applyForm.upload.focus();
    }else{
    	var element = document.getElementById('bookImage');
    	var imgPath = window.URL.createObjectURL(img.files[0]); 
    	element.src = imgPath; 
    }
}

//重置按钮
function resetBook(){
	location.href="AddNewBook.jsp";
}

//取消按钮
function cancel(){
	location.href="manageBook.action";
}