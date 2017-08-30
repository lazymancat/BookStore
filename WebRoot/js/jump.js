/* 跳转至先前页面，若传入值为空，默认跳转回首页*/
function jumpPreLocation(preLocation){
	if(preLocation != "null"){
		location.href = preLocation;
	}else{
		location.href = "http://localhost:8080/BookStore/HomePage.jsp";
	}
}

/*跳转至登录处理*/
function jumpToLogin(){
		location.href="jumpToLogin?locationHref=" + location.href;
}
/*跳转至注销处理*/
function jumpToLogoff(){
	location.href="jumpToLogoff?locationHref=" + location.href;
}
/*跳转至注册处理*/
function jumpToRegister(){
	location.href="jumpToRegister?locationHref=" + location.href;
}
/*跳转至修改资料处理*/
function jumpToReviseData(){
	location.href="jumpToReviseData?locationHref=" + location.href;
}
/*跳转至管理收货地址处理*/
function jumpToManageConsignmentAddress(){
	location.href="jumpToManageConsignmentAddress?locationHref=" + location.href;
}
/*跳转至修改密码处理*/
function jumpToRevisePassword(){
	location.href="jumpToRevisePassword?locationHref=" + location.href;
}
/*跳转至修改收货地址处理*/
function jumpToReviseConsignmentAddress(id){
	location.href = "jumpToReviseConsignmentAddress?locationHref=" + location.href + "&consignmentAddressId=" + id;
}
/*跳转至删除收货地址处理*/
function jumpToDeleteConsignmentAddress(id){
	location.href = "jumpToDeleteConsignmentAddress?locationHref=" + location.href + "&consignmentAddressId=" + id;
}
/*跳转至添加收货地址处理*/
function jumpToAddConsignmentAddress(){
	location.href = "jumpToAddConsignmentAddress?locationHref=" + location.href;
}
/*跳转至删除用户处理*/
function jumpToDeleteCustomer(id){
	location.href = "jumpToDeleteCustomer?cusId=" + id;
}
/*跳转至修改用户资料处理*/
function jumpToReviseCustomer(id){
	location.href = "jumpToReviseCustomer?locationHref=" + location.href +"&cusId=" + id;
}
/*跳转至管理员登录处理*/
function jumpToAdministratorLogoff(){
	location.href = "jumpToAdministratorLogoff";
}
/*获取购书数量*/
function getQuantity(){
	return document.getElementById("number").value;
}
/*跳转至加入购物车处理*/
function jumpToAddShopping(id){
	location.href = "http://localhost:8080/BookStore/AddShoppingAction?bookId=" + id + "&quantity=" + getQuantity();
}
