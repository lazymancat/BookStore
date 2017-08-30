var opened_ddmi = 0;
			
function menuOpen(id){	
	if(opened_ddmi) opened_ddmi.style.visibility = 'hidden';

	opened_ddmi = document.getElementById(id);
	opened_ddmi.style.visibility = 'visible';
}
function menuClose(){
	if(opened_ddmi) opened_ddmi.style.visibility = 'hidden';
}

function jumpToSelf(){
	location.href = location.href;
}

document.onclick = menuClose; 