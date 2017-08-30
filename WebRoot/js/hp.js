var count = 0;

function leftboxmove(){
	if(count == 0){
		var leftbox = document.getElementById("left-box");
		leftbox.style.left = 0+"%";
		count = 1;
	}else{
		var leftbox = document.getElementById("left-box");
		leftbox.style.left = -20+"%";
		count = 0;
	}
}

    $(function(){
    $("#myTab a").click(function(e){
        e.preventDefault();
        $(this).tab("show");
    });
})

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
		temp = 1;
	
	if(temp == 0)
		temp = 1;
	
	return temp;
}

function add(id){
	var t = document.getElementById(id);
	if(t.value < 9999)
		t.value++;
	
	if(t.value > 9999)
		t.value = 9999;
}

function reduce(id){
	var t = document.getElementById(id);
	if(t.value != 0)
		t.value--;
	
	if(t.value <= 0)
		t.value = 1;
}

function getQuantity(){
	return document.getElementById("number").value;
}

function jumpToAddShopping(id){
	location.href = "http://localhost:8080/BookStore/AddShoppingAction?bookId=" + id + "&quantity=" + getQuantity();
}