// JavaScript Document
//商品数量的添加
function add(e){
	var str = e.id;
	var fid = str.substring(3,str.length);//截取fid
	//获取购物车中点击的商品数量
	var num =$("#num"+fid).val();
	num++;
	
			//数量写入标签中
			$("#num"+fid).val(num);	
			//获取单价
			var fprice = $("#buy_fprice_"+fid).html();
			//获取小计
			var total = num*fprice*1.00;
			//获取小计标签
			var $subtotal = $("#buy_price_"+fid);
			//小计价钱写入标签中
			$subtotal.text(total.toFixed(2));
			productCount();
}

//保留两位小数的方位
function returnFloat(value){
	//Math js中的静态的数学对象  round四舍五入
	 var value=Math.round(value*100)/100;
	//转换成字符串并以.分割成数组
	 var xsd=value.toString().split(".");
	//判断数组长度
	 if(xsd.length==1){ //整数
	 	value=value.toString()+".00";//拼接
		return value;
	 }
	 if(xsd.length>1){ //带小数
	 	if(xsd[1].length<2){
	 		value=value.toString()+"0";
	 	}
		 return value;
	}
}

//删除商品
function delGoods(e){
	//温馨提示
	var result = confirm("您确定要删除购物车中当前商品吗？");

	if (!result) {
		return;
	}
	//获取id
	var str = e.id;
	var fid = str.substring(3,str.length);
	$("#ul_" + fid).remove();
	productCount();
}

//全选和全不选
$("#all").click(function(){
	//获取全选是否被选中
	//prop 获取标签的固有属性  attr 自动义的属性
	var flag = $(this).prop("checked");
	//判断    
	$(".cart_list_td ul .col01 input").prop("checked",flag);
});

//商品数量的减法
function lost(e){
	var str = e.id;//获取id
	var fid = str.substring(4,str.length);//截取fid
	//获取购物车中点击的商品数量
	var num =$("#num"+fid).val();
	//判断此商品的数量是否大于1
	if( num <= 1){
		return; 
	}
	num--;
	
			//数量写入标签中
			$("#num"+fid).val(num);	
			//获取单价
			var fprice = $("#buy_fprice_"+fid).html();
			//获取小计
			var total = num*fprice*1.00;
			//获取小计标签
			var $subtotal = $("#buy_price_"+fid);
			//小计价钱写入标签中
			$subtotal.text(total.toFixed(2));
			productCount();
}

function menberLogin() {
	 localStorage.setItem("targetUrl", location.href);
	 location.href="login.html";
} 


$(function(){
	$.post("../menber/check", null, function(data) {
	 	var str = "";
	 	if(data.mno) {
			str += '<div class="login_btn fl"><a href="#">欢迎您 &nbsp;['+data.nickName+']</a><span> | </span>';
			str += '<a href="javascript:menberLogin()">注销</a><span> | </span><a href="register.html">注册</a></div>';
		} else {
			str += '<div class="login_btn fl">';
			str += '<a href="javascript:menberLogin()">登录</a><span> | </span><a href="register.html">注册</a></div>';
		}
		str += '<div class="user_link fl"><span> | </span><a href="#">用户中心</a><span> | </span>';
		str += '<a href="front/cart.html">我的购物车</a><span> | </span><a href="#">我的订单</a></div> ';
		$("#head_info").append($(str));
	}, "json");
})

//计算商品总额的方法
function productCount(){
	var total=0;  //总价
	var price;//每一行的市场价
	var number;//每一行的数量
	var numbers=0;//总数量
	var myul=$(".cart_list_td ul");

	for(var i=0;i<myul.length;i++){//循环每一行
		if ($(myul[i]).find("input[type='checkbox']").prop("checked") ){
			price=$(".cart_list_td  ul:eq("+i+")").find(".col05").html();
			number=$(".cart_list_td  ul:eq("+i+")").find(".col06 input").val();
			total+=price*number;
			numbers+= number*1.0;
		}
	}
	alert("总价和数量改变")
	$("#totalPrices").html(total.toFixed(2));//总价格
	$("#totalNumbers").html(numbers);//总数量
}


