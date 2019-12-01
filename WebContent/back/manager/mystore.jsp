<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的店铺</title>
<link rel="stylesheet" type="text/css" href="../../css/reset.css">
<link rel="stylesheet" type="text/css" href="../../css/public.css">
<link rel="stylesheet" type="text/css" href="../../css/mycenter.css">
<link rel="shortcut icon" href="../images/favicon.ico" />
<link rel="stylesheet" href="../../css/responsive.css">
<link rel="stylesheet" href="../../css/notiflix-1.3.0.min.css">
<link rel="stylesheet" href="../../css/dateTime.css">
<script type="text/javascript" src="../../js/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="../../js/dateTime.min.js"></script>
<script type="text/javascript" src="../../js/menu.js"></script>
<script type="text/javascript" src="../../js/ajaxfileupload.js"></script>
<script src="../../js/notiflix-1.3.0.min.js" type="text/javascript"></script>



<!--[if lt ie 9]>
		<script type="text/javascript" src="../../js/html5.js"></script>
	<![end if]-->
</head>
<body>
	<header>
	<div class="inner">
		<div class="logo">
			<h1>
				<a href="#">丑团外卖</a>
			</h1>
		</div>
		<div class="login">
			<a href="menu.html">返回</a>
			<div class="username">
				<a href="#">${user.uname}</a>
				<ul id="userMenu" class="userMenu">
					<li><a href="#">我的资料</a></li>
					<li><a href="#">我的订单</a></li>
					<li><a href="#">退出登陆</a></li>
				</ul>
				<span class="triangle_icon"></span>

			</div>
		</div>
	</div>
	</header>
	<div class="kefu"></div>

	<section class="main inner clearfix">
	<div class="main-left">
		<ul id="main-left-ul">
			<li><a href="#" class="active-li">查看店铺</a></li>
			<li><a href="#">添加美食类型</a></li>
			<li><a href="#">添加菜系</a></li>
			<li><a href="#">修改菜系</a></li>
			<li><a href="#">发布活动</a></li>
		</ul>
	</div>


	<div class="main-right" id="main-right-inner">
		<div class="main-right-inner mycenter clearfix active">
			<div class="information clearfix">
				<p class="clearfix">	
					<img src=${restaurant["rpic"]}>
					<span class="information-r-span1">${restaurant["rname"]}</span>
				</p>
				<p>公告</p>
				<div>
				${restaurant['rdisc']}
				</div>
			</div>
			<div class="table table-add">
				<div class="list">
					<table width="90%" align="center" border="1px" cellspacing="0xp"
						cellpadding="0px" role="all">
						<caption>商品信息</caption>
						<thead id= "foodinfo_foodshow">
							<tr >
								<th>图片</th>
								<th>名称</th>
								<th>类型</th>
								<th>价格</th>
							</tr>							
						</thead>
						<tbody align="center" id="types">
							<c:forEach items="${foods}" var="item">
								<tr>
									<td><img src="${item.pic}" width="50px" height="50px"></td>
									<td>${item.fname}</td>
									<td>${item.trtype}</td>
									<td>${item.fprice}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="main-right-inner base">
			<h2>添加美食类型</h2>
			<div class="list">
				<div class="list-inner">
					<form id="add_types_form">
						<ul>
							<li><label for="add_type_name">美食类型</label> <input
								type="text" name="trname" id="add_types_name"  class ="foods_ipt"/>
							</li>
							<li style="width: 100%; text-align: center"><input
								type="button" value="添加" onclick="addtypes()" class="mybtn" /></li>
						</ul>
					</form>
				</div>
			</div>
		</div>
		<div class="main-right-inner base">
			<h2>添加菜系</h2>
			<div class="list">
				<div class="list-inner">
					<form id="add_foods_form">
						<ul>
							<li><label>菜系类型：</label> <select id="add_foods_typeid"
								class="foods_ipt"></select></li>
							<li><label for="add_foods_name">菜系名称：</label> <input
								type="text" name="tname" id="add_foods_name" class="foods_ipt" />
							</li>
							<li><label for="add_foods_name">菜系价格：</label> <input
								type="text" name="price" id="add_foods_price" class="foods_ipt" />
							</li>
							<li><label for="add_foods_price">菜系图片：</label> <input
								type="file" name="pic" id="add_foods_pic" class="foods_ipt" /></li>
							<li style="width: 60%"><label for="add_foods_context">菜系描述：</label>
								<textarea name="context" id="add_foods_context" rows="3"
									cols="100"></textarea></li>
							<li style="width: 100%; text-align: center"><input
								type="button" value="添加" onclick="addfoods()" class="mybtn" /></li>
						</ul>
					</form>
				</div>
			</div>
		</div>
		<div class="main-right-inner send">
			<h2>修改菜单</h2>
			<div class="list">
				<div class="small-list list-top">
					<ul>
						<li class="li-first" style="width: 20%">菜系类型</li>
						<li style="width: 15%">名称</li>
						<li style="width: 10%">价格</li>
						<li style="width: 25%">操作</li>
					</ul>			
					<ul id="food-show_up">
					</ul>
				</div>
				<div class="small-list list-bottom" id = "mystore_update_foodsshows">
							
				</div>
			</div>
		</div>
		<div class="main-right-inner order">
			<form id="add_action_form">
				<table>
					<tr>
						<td>活动类型</td>
						<td><select id = "actype">
								<option value="0" selected>满减</option>
								<option value="1">打折</option>
						</select></td>
					</tr>
					<tr>
						<td>活 动 起 始 时 间:</td>
						<td><input type="text" placeholder="请选择日期和时间" id="datetime"></td>
					</tr>
					<tr>
						<td>活 动 结束 时 间:</td>
						<td><input type="text" placeholder="请选择日期和时间" id="enddatetime"></td>
					</tr>
					<tr>
						<td >折扣选择:</td>
						<td id ="zk"><select id= "discount">
								<option value="1">1折</option>
								<option value="2">2折</option>
								<option value="3">3折</option>
								<option value="4">4折</option>
								<option value="5">5折</option>
								<option value="6">6折</option>
								<option value="7">7折</option>
								<option value="8">8折</option>
								<option value="9">9折</option>
						</select>&nbsp;<span>数量</span><input type="text" id= "acnum" style="width: 50px"></td>
						<td id = "mj"><span class="jian">满</span><input type="text" id= "lowmin" style="width: 20px"> <span class="jian">减</span> <input type="text" id= "remoney" style="width: 20px">  </td>
					</tr>
					<tr>
						<td>活动菜系:</td>
						<td><input type="checkbox" id="oCheck"  value="0" name="oCheck">全选</td>
					</tr>
					<tr>
						<td id = "action_foodshow1"></td>
						<td id = "action_foodshow2"></td>
						<td id = "action_foodshow3"></td>
					</tr>
					<tr>
						<td><input type="button" value="发布" id="fb" onclick="addaction()"></td>
					</tr>
				</table>
			</form>
		</div>

		<script>
		var rid = 4;
		var id;
		$("#datetime").datetime({
			type:"datetime",
			value:[2019,11,1,15,30]
		})
		$("#enddatetime").datetime({
			type:"datetime",
			value:[2019,12,1,15,30]
		})
		
			$(function() {
				Notiflix.Notify.Init();
				findres();//查看商铺目前状态
				findAllTypes();//查询所有店铺美食类型
				findfoods();//分页查找美食(主界面)
				findfoodsup();//分页查找美食(修改界面)
				findAllfood();//查找店铺所有美食
				$("#zk").hide();
			})
			//获取当前元素的id	
   			function dianji(e) {
        		id = e.id;
    		}
			//查看商铺目前状态
			function findres(){
				$.post("../../resturant", {
					op : "findres"
				}, function(data) {
					if (data < -1) {
						Notiflix.Notify.Warning('您暂无商铺，请先注册');
						location.href = "../store/register.html";
					}else if(data == 2){
						Notiflix.Notify.Warning('您的商铺审核中请等待');
						location.href = "../manager/menu.html";					
					}else if(data == 3){
						Notiflix.Notify.Failure('您的商铺已注销');
						location.href = "../manager/menu.html";
					}else if(data == 4){
						Notiflix.Notify.Success('您的店铺未通过，请重新注册');
						setTimeout( location.href = "../store/register.html",2000);			
					}
				}, "json");
			}
			//查找店铺所有美食
			function findAllfood(){
				$.post("../../foods", {
					op : "findAllfood",
					rid : rid
				}, function(data) {
					var str1 = "";
					var str2 = "";
					var str3 = "";//活动界面

					var count = 1;
					$.each(data, function(index, item) {
						if(count%3 == 0){
							str3 +='<li><input type="checkbox" value="'+item.fid+'" name="check" >'+item.fname+'</li>'
						} else if(count%3 == 1) {
							str1 +='<li><input type="checkbox" value="'+item.fid+'" name="check" >'+item.fname+'</li>'
						} else {
							str2 +='<li><input type="checkbox" value="'+item.fid+'" name="check" >'+item.fname+'</li>'
						}
						count ++ ;
					})
					
					$("#action_foodshow1").html("");
					$("#action_foodshow2").html("");
					$("#action_foodshow3").html("");
					$("#action_foodshow1").append($(str1));
					$("#action_foodshow2").append($(str2));
					$("#action_foodshow3").append($(str3));
				}, "json");
			}
			//分页查找美食（主界面）
			function findfoods(){
				$.post("../../foods", {
					op : "findfoods",
					rid : rid
				}, function(data) {
					var str = "";
					var str1="";
					$.each(data, function(index, item) {
						
						str += "<tr><th><img src ='../../"+item.fpic+"'></th><th>"+item.fname+"</th><th>"+item.trtype+"</th><th>"+item.fprice+"</th></tr>";
					})
					$("#foodinfo_foodshow").append($(str));
					$("#foodinfo_foodshow").append($(str1));
				}, "json");
			}
			//分页查找美食(修改界面)
			function findfoodsup(){
				$.post("../../foods", {
					op : "findfoods",
					rid : rid
				}, function(data) {
					var str ="";//修改界面
					$.each(data, function(index, item) {
						str +='<li class="li-first" id="'+item.fid+'" onmouseover="dianji(this)"><select id="mystore_foodup_select_'+item.fid+'"  class="foods_ipt"  name ="address"  disabled="disabled" style="width: 25%"><option value ="'+item.trid+'">'+item.trtype+'</option></select><input id="foodup_fname'+item.fid+'" style="width: 25%" type="text" name="address" readonly="readonly" value="'+item.fname+'" ><input id="foodup_fprice'+item.fid+'" style="width:10%" type="text" name="address" readonly="readonly" value="'+item.fprice+'"><a href="javascript:void(0)" onclick="foodinfoup()">修改</a><a href="javascript:void(0)" onclick="foodinfoop()">提交</a><a href="javascript:void(0)" onclick="foodinfodelete()">删除</a></li>'
					})
					$("#food-show_up").append($(str));
				}, "json");
			}
			//菜单修改——修改
			function foodinfoup(){
				$("#foodup_fname"+id+"").removeAttr("readonly");
				$("#foodup_fprice"+id+"").removeAttr("readonly");
				$.post("../../ResfoodtypeServlet", {
					op : "findAllTypes",
					rid : rid
				}, function(data) {
					var str1 = "";
					$.each(data, function(index, item) {
						$("#mystore_foodup_select_"+id+"").find("option").remove();//清空
						str1 += "<option value = '" + item.trid + "'>"
								+ item.trtype + "</option>";
					})
					$("#mystore_foodup_select_"+id+"").append($(str1));
				}, "json");
				$("#mystore_foodup_select_"+id+"").removeAttr("disabled");
			}
			//菜单修改——提交
			function foodinfoop(){
				var fname = $("#foodup_fname"+id+"").val();//美食名字
				var fprice= $("#foodup_fprice"+id+"").val();//美食价格
				var trid  =$("#mystore_foodup_select_"+id+" option:selected").val();//美食类型编号
				$.post("../../foods", {
					op : "foodup",
					fid:id,
					fname:fname,
					fprice:fprice,
					trid:trid,
				}, function(data) {
					if(data>0){
						Notiflix.Notify.Success('美食修改成功');
						//先清空
						 $("#food-show_up").html("");
						 $("#foodinfo_foodshow").html("");
						//重新查询(刷新)
						findfoods();
						findfoodsup();
					}else{
						Notiflix.Notify.Failure('遇到未知错误，美食修改失败');
					}
				}, "json");
			}
			//菜单修改——删除
			function foodinfodelete(){
				$.post("../../foods", {
					op : "fooddelete",
					fid:id,
				}, function(data) {
					if(data>0){
						Notiflix.Notify.Success('美食删除成功');
						//先清空
						 $("#food-show_up").html("");
						 $("#foodinfo_foodshow").html("");
						//重新查询(刷新)
						findfoods();
						findfoodsup();
					}else{
						Notiflix.Notify.Failure('遇到未知错误，美食删除失败');
					}
				}, "json");
			}
			//查询所有店铺美食类型
			function findAllTypes(){
				$.post("../../ResfoodtypeServlet", {
					op : "findAllTypes",
					rid : rid
				}, function(data) {
					var str = "";
					$.each(data, function(index, item) {
						str += "<option value = '" + item.trid + "'>"
								+ item.trtype + "</option>";
					})
					$("#add_foods_typeid").append($(str));
				}, "json");
			}
			
			//添加店铺美食类型
			function addtypes() {
				var trtype = $.trim($("#add_types_name").val());
				$.post("../../ResfoodtypeServlet", {
					op : "addTypes",
					rid : rid,
					trtype : trtype
				}, function(data) {
					if (data > 0) {
						Notiflix.Notify.Success("添加成功");
						$("#add_types_name").html("");
					} else {
						Notiflix.Notify.Failure("添加失败");
					}
					findAllTypes();
				}, "json");
			}

			//添加店铺美食
			function addfoods() {
				var trid = $.trim($("#add_foods_typeid").val());
				var fname = $.trim($("#add_foods_name").val());
				var fprice = $.trim($("#add_foods_price").val());
				var fdisc = $.trim($("#add_foods_context").val());
				if (trid == "" || fname == "" || fprice == "" 
						|| fdisc == "") {
					
					return -1;
				}
				$.ajaxFileUpload({
					url:"../../foods?op=addfoods",
					secureuri: false,
					fileElementId: ["add_foods_pic"],
					data: {rid:rid,trid:trid, fname:fname, fprice:fprice,fdisc:fdisc},
					dataType: "text",
					success: function(data, status) {
						data = parseInt($.trim(data));
						
						if (data == -1) {
							Notiflix.Notify.Failure("您输入的信息不完整请确认后重新输入22222...");
						} else if (data > 0) {
							Notiflix.Notify.Success("添加成功...");
							$("#add_foods_name").val("");
							$("#add_foods_price").val("");
							$("#add_foods_pic").val("");
							$("#add_foods_context").val("");
						} else {
							Notiflix.Notify.Info("添加失败...");
						}
					},
					error: function(data, status, e) {
						Notiflix.Notify.Failure("店铺注册失败...\n" + e);
					}
				})
				findAllfood();
			}
			//折扣类型改变
		    $("#actype").change(function() {
				var x = $("#actype").val();
				if(x == 0){
					$("#zk").hide();
					$("#mj").show();
				}else if(x == 1){
					$("#mj").hide();
					$("#zk").show();
				}
		    });
			//全选,取消
			$('#oCheck').click(function () {
            //获取复选框的状态 如果为true 为选中状态，false 为未选中状态
                var is_check = $('#oCheck').is(':checked');
                $("input:checkbox[name='check']:checkbox").each(function(){
    				$(this).prop("checked",is_check)
     			});
            });   
			//发布活动
			function addaction(){
				var actype = $("#actype").val();//折扣类型
				var discount = $("#discount option:selected").val();//折扣选择
				var lowmin  = $("#lowmin").val();//满减下限
				var remoney  = $("#remoney").val();//满减金额
				var acnum  = $("#acnum").val();//满减数量
				var datatime = $("#datetime").val();
				var enddatatime = $("#enddatetime").val();
				Notiflix.Notify.Success(datatime);
				Notiflix.Notify.Success(enddatatime);
				var fids = "";
				var count = 1;
				$("input[name='check']:checkbox").each(function() {  
				        var flag = $(this).is(':checked');  
				        if(flag){
				        	if(count == 1){
				        		fids = $(this).val();
				        	}else{
					        	fids += "/"+$(this).val();
				        	}
				        	count ++;
				        }  
				});
				if(actype == 0){//满减活动操作
					$.post("../../action", {
						op : "addmj",
						rid : rid,//店铺
						actype : actype,
						lowmin : lowmin,
						remoney : remoney,
						fids : fids,
						datatime:datatime,
						enddatatime:enddatatime
					}, function(data) {
						Notiflix.Notify.Success("满减活动设置成功，有"+data+"个菜系修改失败");
					}, "json");
				}else if(actype == 1){//打折活动操作
					$.post("../../action", {
						op : "adddz",
						rid : rid,//店铺
						actype : actype,
						discount:discount,
						acnum:acnum,
						fids : fids
					}, function(data) {
						Notiflix.Notify.Success("打折	活动设置成功，有"+data+"个菜系修改失败");
					}, "json");
				}
				findAllfood();
			}
			$("#main-left-ul li").click(
					function() {
						var index = $(this).index();
						$(this).find("a").addClass("active-li");
						$(this).siblings().find("a").removeClass("active-li");
						$("#main-right-inner>div").eq(index).addClass("active")
								.siblings().removeClass("active");  
						 
					})
					
		</script>
	</div>


	<div class="goTop"></div>
	</section>




	<footer>
	<div class="inner clearfix">
		<div class="footer-top clearfix">
			<nav>
			<ul class="clearfix">
				<li><a href="#">网站介绍</a></li>
				<li><a href="#">联系我们</a></li>
				<li><a href="#">常见问题</a></li>
				<li><a href="#">招贤纳士</a></li>
				<li><a href="#">网站地图</a></li>
				<li><a href="#">商家加盟</a></li>
			</ul>
			</nav>
			<div class="foot-kf">
				<a href="#"> <img src="../../images/foot-kf.jpg" alt="">
				</a>
				<div class="pt15">
					<span>关注我们:</span> <a href="#" class="sina"></a> <a href="#"
						class="wx"></a>
				</div>
			</div>
		</div>
		<div class="copyright">
			<p>
				© 2019 丑团 <a href="#">湘ICP备12042558号</a>
			</p>
			<div class="zjgs">
				<a href="#"> <img src="../../images/zjgs.png" alt="">
				</a>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>