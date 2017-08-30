//鏍规嵁bookId鑾峰彇瀵绘壘瀵瑰簲鐨勪功鏈�
function reviseBook(bookId)
{
	location.href="queryBook?bookId="+bookId;
}

//鏍规嵁bookId鍒犻櫎瀵瑰簲鐨勪功鏈�
function deleteBook(bookId)
{
	if(confirm("浣犵‘瀹氳鍒犻櫎杩欐湰涔﹀悧锛"))
	{
		location.href="deleteBook?id="+bookId;
	}
}

function getBookImage(bookImage){
	location.href="reviseBook?book.Image="+bookImage;
}

//JS鍒ゅ畾鍥句功绫诲瀷鏄惁涓虹┖
//function checkBookType(){
//	var bookType = document.getElementById("bookType").value;
//	var $checkBookTypeInfo = $("#checkBookTypeInfo");
//	$checkBookTypeInfo.html("");
//	if (bookType=='0') 
//	{
//// alert("username is required");
//		$checkBookTypeInfo.html("*涓嶈兘涓虹┖").css('color','#FF5151');
//// document.getElementById("submit").disabled = true;
//	}
//	
//}

//JS鍒ゆ柇鍥句功浠锋牸鏄惁涓虹┖鑰屼笖鏄惁涓�
//function checkBookPrice(){
//	var bookPrice = document.getElementById("bookPrice").value;
//	var $checkBookPriceInfo = $("#checkBookPriceInfo");
//	$checkBookPriceInfo.html("");
//	if (bookPrice=='') 
//	{
//		$checkBookPriceInfo.html("*涓嶈兘涓虹┖").css('color','#FF5151');
//	}else if(isNaN(bookPrice)){
//		$checkBookPriceInfo.html("*蹇呴』涓烘暟瀛�).css('color','#FF5151');
//	}
//}

//JS鍒ゅ畾鍥句功椤垫暟鏄惁涓虹┖鍜屾槸鍚︿负鏁存暟
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

//妫�煡鍥句功浠锋牸鏄惁涓烘鏁�
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

//JS鍒ゅ畾鍥句功椤垫暟鏄惁涓虹┖鍜屾槸鍚︿负鏁存暟
function checkBookWordCount(){
	var bookWordCount = document.getElementById("BookWordCount").value;
	var $checkBookWordCountInfo = $("#checkBookWordCountInfo");
	$checkBookWordCountInfo.html("");
	if (bookWordCount=='') 
	{
		$checkBookWordCountInfo.html("*涓嶈兘涓虹┖").css('color','#FF5151');
	}else if(bookWordCount%1!=0){
		$checkBookWordCountInfo.html("*蹇呴』涓烘暣鏁").css('color','#FF5151');
	}else if(bookWordCount.indexOf('.')>-1){
		$checkBookWordCountInfo.html("*璇疯緭鍏ュ畬鏁寸殑鏁存暟").css('color','#FF5151');
		
	}
}

////JS鍒ゅ畾鍥句功浣滆�鏄惁涓虹┖
//function checkBookAuthor(){
//	var bookAuthor = document.getElementById("bookAuthor").value;
//	var $checkBookAuthorInfo = $("#checkBookAuthorInfo");
//	$checkBookAuthorInfo.html("");
//	if (bookAuthor=='') 
//	{
//// alert("username is required");
//		$checkBookAuthorInfo.html("*鍥句功浣滆�涓嶈兘涓虹┖").css('color','#FF5151');
//// document.getElementById("submit").disabled = true;
//	}
//	
//}

//JS鍒ゅ畾淇敼鍐呭鏄惁涓虹┖
function checkEmpty(name){
	var book = document.getElementById(name).value;
	var $checkInfo = $("#check"+name+"Info");
	$checkInfo.html("");
	if (book=='') 
	{
// alert("username is required");
		$checkInfo.html("*涓嶈兘涓虹┖").css('color','#FF5151');
// document.getElementById("submit").disabled = true;
	}
}

//鍒ゅ畾閫夋嫨鐨勬枃浠舵槸鍚︿负鍥剧墖
function changeImage(img){
	var url = img.value; 
    var fileext=url.substring(url.lastIndexOf("."),url.length);      
    fileext=fileext.toLowerCase()
    
    if((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp')&&fileext!=null){   
        alert("鏂囦欢鏍煎紡涓嶅锛岃閲嶆柊閫夋嫨鍥剧墖");
        document.applyForm.upload.focus();
    }else{
    	var element = document.getElementById('bookImage');
    	var imgPath = window.URL.createObjectURL(img.files[0]); 
    	element.src = imgPath; 
    }
}

//閲嶇疆鎸夐挳
function resetBook(bookId){
	location.href="queryBook?bookId="+bookId;;
}

//鍙栨秷鎸夐挳
function cancel(){
	location.href="manageBook.action";
}