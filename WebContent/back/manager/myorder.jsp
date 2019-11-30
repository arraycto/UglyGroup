<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="../../css/resetorder.css">
 <link rel="stylesheet" href="../../css/main.css">
 <link rel="stylesheet" href="../../css/order.css">
 
 	<link rel="stylesheet" type="text/css" href="../../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../../css/public.css">
	<link rel="stylesheet" type="text/css" href="../../css/mycenter.css">
	<link rel="shortcut icon" href="favicon.ico" /> 
	<link rel="stylesheet" href="../../css/notiflix-1.3.0.min.css">
	<link rel="stylesheet" href="../../css/responsive.css">
	<script type="text/javascript" src="../../js/jquery-1.12.2.min.js"></script>
	<script type="text/javascript" src="../../js/menu.js"></script>
	<script src="../../js/notiflix-1.3.0.min.js" type="text/javascript"></script>
	
<title>我的订单</title>
</head>
<body>
	<header>
		<div class="inner">
			<div class="logo" style="margin:0px 0px 0px 0px">
				<h1><a href="#">丑团外卖</a></h1>
			</div>
			<div class="login">
				<a href="menu.html">返回</a>
				<div class="username">
					 <a href="#">${user.uname}</a>
					<ul id="userMenu" class="userMenu">
						<li><a href="#">我的资料</a></li>
						<li><a href="#">我的订单</a></li>
						<li><a href="../index.html">退出登陆</a></li>
					</ul>
					<span class="triangle_icon"></span>
					
				</div>
			</div>
		</div>
	</header>
	<div class="kefu"></div>
   
	<section class="main inner clearfix">
 		<!-- 收货地址 -->
		<div class="common_list_con clearfix">
			<dl id="myorder_ressadd">
				<dt>寄送到：</dt>
				<dd ><input value="arid" type="radio" name="area" checked="">
				<select class = "noborder"  id="myorder_area_select" class="foods_ipt"  name ="address"  disabled="disabled">
				<option value ='area_id' >蒸湘区</option>
				</select>
				<input   id="aradd"  class = "noborder" type="text" name="address" readonly="readonly" value="南华大学">
				<input  id="arname"  class = "noborder" type="text" name="address" readonly="readonly" value="唐俊彦">（收）
				<input id="artel"  class = "noborder" type="text" name="address" readonly="readonly" value="15226380133">
				</dd>
			</dl>
			<a href="#" id="tj" class="edit_site" onclick="addresstj()">提交</a>
			<a href="#" id="xg" class="edit_site" onclick="addressxg()">修改收货地址</a>
		</div>
    
   		<!-- 支付方式 -->	
   	 	<h3 class="common_title">支付方式</h3>	
		<div class="common_list_con clearfix">
		<div class="pay_style_con clearfix">
			<input type="radio" name="pay_style" checked>
			<label class="cash">货到付款</label>
			<input type="radio" name="pay_style">
			<label class="weixin">微信支付</label>
			<input type="radio" name="pay_style">
			<label class="zhifubao"></label>
			<input type="radio" name="pay_style">
			<label class="bank">银行卡支付</label>
		</div>
	</div>
    
   	<!-- 商品列表 -->
    <h3 class="common_title">商品列表</h3>
	<div class="common_list_con clearfix">
		<ul class="goods_list_th clearfix">
			<li class="col01">商品名称</li>
			<li class="col02">商品单位</li>
			<li class="col03">商品价格</li>
			<li class="col04">数量</li>
			<li class="col05">小计</li>		
		</ul>
		<ul class="goods_list_td clearfix">
			<li class="col01">1</li>			
			<li class="col02"><img src="images/goods/goods012.jpg"></li>
			<li class="col03">奇异果</li>
			<li class="col04">500g</li>
			<li class="col05">25.80元</li>
			<li class="col06">1</li>
			<li class="col07">25.80元</li>
		</ul>
		<ul class="goods_list_td clearfix">
			<li class="col01">2</li>			
			<li class="col02"><img src="images/goods/goods003.jpg"></li>
			<li class="col03">大兴大棚草莓</li>
			<li class="col04">500g</li>
			<li class="col05">16.80元</li>
			<li class="col06">1</li>
			<li class="col07">16.80元</li>	
		</ul>
	</div>
     
    <!-- 金额结算 -->	
    <h3 class="common_title">总金额结算</h3>
	<div class="common_list_con clearfix">
		<div class="settle_con">
			<div class="total_goods_count">共<em>2</em>件商品，总金额<b>42.60元</b></div>
			<div class="transit">折扣减免：<b>10元</b></div>
			<div class="total_pay">实付款：<b>52.60元</b></div>
		</div>
	</div>
	<div class="order_submit clearfix">
		<a href="javascript:void(0)" id="order_btn" onclick="getarid()">提交订单</a>
	</div>	
    
    <div class="popup_con">	
		<div class="popup">
			<p>订单提交成功！</p>
		</div>
		
		<div class="mask"></div>
	</div>    
</section>
	<script type="text/javascript">
	var id;
	var uid = 101;
	$(function(){
		Notiflix.Notify.Init();
		//userid();
		findressreceipt();
		
	});
	//获取id
	function userid(){
		$.post("../../admin", {
			op : "userid"
		}, function(data) {
			if(data != null){
				uid = data;//获取uid
			}else{
				Notiflix.Notify.Warning('请先登陆');
				location.href = "../index.html";
			}
		}, "json");
	}
	//input[type=text]自适应长度 
	function resizeInput() {
	    $(this).attr('size', ($(this).val().length)+1);
	}
	//获取收货地址编号
	function getarid(){
		id  = $('input:radio:checked').val();
	}
	//查找所有的收货地址
 	function findressreceipt(){
		$.post("../../ressreceipt", {
			op : "findress",
			uid :uid
		}, function(data) {
			var length = data.length;
			if(length >= 10){
				$("#addrows").attr("disabled",true).css("pointer-events","none")
			}
			if(data == null){
				return;
			}
			//先清空
			 $("#myorder_ressadd").html("");
			 var str = "<dt>寄送到：</dt>";	
			 $("#myorder_ressadd").append($(str));
			//循环添加查出来的收货地址
			$.each(data, function(index, item) {
				str = '<dd ><input  value="'+item.arid+'" type="radio" name="area" checked=""><select class = "noborder"  id="myorder_area_select'+item.arid+'" class="foods_ipt"  name ="address"  disabled="disabled"><option vlaue= "'+item.aid+'" >'+ item.aname+ '</option></select><input   id="aradd'+item.arid+'"  class = "noborder" type="text" name="address" readonly="readonly" value="'+item.aradd+'"><input  id="arname'+item.arid+'" class = "noborder" type="text" name="address" readonly="readonly" value="'+item.arname+'">（收）<input id="artel'+item.arid+'"  class = "noborder" type="text" name="address" readonly="readonly" value="'+item.artel+'">'
				$("#myorder_ressadd").append($(str));
			})
		}, "json");
		$('input[type="text"]').each(resizeInput);
	}
	//修改收货地址
	function addressxg(){
		$("#tj").show();
		$("#xg").hide();
		getarid();//获取选中的收货地址
		$("#arname"+id).removeAttr("readonly");
		$("#aradd"+id).removeAttr("readonly");
		$("#artel"+id).removeAttr("readonly");
		$.post("../../ressreceipt", {
			op : "findarea",
		}, function(data) {
			var str1 = "";
			$.each(data, function(index, item) {
				str1 += "<option value = '" + item.aid + "'>"
						+ item.aname + "</option>";
			})
			$("#myorder_area_select"+id).html("");
			$("#myorder_area_select"+id).append($(str1));
		}, "json");
		$("#myorder_area_select"+id).removeAttr("disabled");
	}
	//提交修改后的收货地址
	function addresstj(){
		getarid();//获取选中的收货地址
		var arname = $("#arname"+id).val();//名字
		var aradd= $("#aradd"+id).val();//详细地址
		var artel= $("#artel"+id).val();//电话
		var aid  =$("#myorder_area_select"+id+" option:selected").val();//区域编号
		$("#xg").show();
		$("#tj").hide();
		$.post("../../ressreceipt", {
			op : "addressup",
			arname:arname,
			aradd:aradd,
			artel:artel,
			aid:aid,
			arid:id
		}, function(data) {
			if(data>0){
				Notiflix.Notify.Success('修改成功');

				$("#arname"+id).attr("readonly","readonly");
				$("#aradd"+id).attr("readonly","readonly");
				$("#artel"+id).attr("readonly","readonly");
				$("#myorder_area_select"+id).attr("disabled","disabled");
			}else{
				Notiflix.Notify.Failure('遇到未知错误，修改失败');
			}
		}, "json");
		$('input[type="text"]').each(resizeInput);
	}
	</script>
        
    <!-- 版权所有 -->
	<div class="footer">
    	<div class="foot_link">
    		<a href="#">关于我们</a> <span> | </span>
            <a href="#">联系我么</a> <span> | </span>
            <a href="#">招聘人才</a> <span> | </span>
            <a href="#">友情链接</a> 
    	</div>
    	<p>CcpyRight &copy; 2019 衡阳市源辰信息科技有限公司 All Rights Reserverd</p>
        <p>电话：0734-8355998 湘ICP备16015987号</p>
    </div>
    
    <script src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    //提交订单
    /**
		$('#order_btn').click(function() {
			localStorage.setItem('order_finish',2);

			$('.popup_con').fadeIn('fast', function() {

				setTimeout(function(){
					$('.popup_con').fadeOut('fast',function(){
						window.location.href = 'index.html';
					});	
				},3000)
				
			});
		});**/
 	</script>
</body>
</html>