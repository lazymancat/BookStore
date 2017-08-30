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