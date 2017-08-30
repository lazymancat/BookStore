var opened_ddmi = 0;
			
		function menuOpen(id){	
			if(opened_ddmi) opened_ddmi.style.visibility = 'hidden';
		
			opened_ddmi = document.getElementById(id);
			opened_ddmi.style.visibility = 'visible';
		}
		function menuClose()
		{
			if(opened_ddmi) opened_ddmi.style.visibility = 'hidden';
		}
		
		document.onclick = menuClose; 
		 		
		
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
		
		function add(id){
			var t = document.getElementById(id);
			if(t.value < 9999)
				t.value++;
		}
		
		function reduce(id){
			var t = document.getElementById(id);
			if(t.value != 0)
				t.value--;
		}
		function jumpToSelf(){
			location.href = location.href;
		}
