
<%--
Created by IntelliJ IDEA.
User: LoveYJ
Date: 2021/10/8
Time: 9:13
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">

	<title>欢颐游戏商城-登录</title>

	<link rel="shortcut icon" href="../../img/shortcut.png" />


	<script src="../../js/jquery-3.5.1.js" type="text/javascript"></script>
	<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
	<script src="https://ciphertrick.com/demo/jquerysession/js/jquerysession.js"></script>
	<script src="../../layui/layui/layui.js"></script>
	<link href="../../layui/layui/css/layui.css" rel="stylesheet" />
	<link rel="stylesheet" href="../../css/font.css">

	<script>
		$(function() {
			btn_HoverLine();
			btn_Switch();
		})


		var flag = 0;

		function changeLine_Last_Enter() {
			$('.LoginUnderLine:last').css({
				'width': '0%',
				'display': 'block'
			})
			$('.LoginUnderLine:last').animate({
				width: '100%'
			}, 'fast', function() {
				$('.LoginUnderLine:last').css('width', '100%')
			})
		}

		function changeLine_Last_Leave() {
			switch (flag) {
				case 0:
					$('.LoginUnderLine:last').animate({
								width: '0%'
							},
							'fast'
					);
					break;
				case 1:
					$('.LoginUnderLine:last').animate({
								width: '50%'
							},
							'fast',
							function() {
								$('.LoginUnderLine:last').css('width', '50%');

							});

					break;
			}
		}


		function changeLine_First_Enter() {
			$('.LoginUnderLine:first').css({
				'display': 'block',
				'width': '0%'
			})
			$('.LoginUnderLine:first').animate({
				width: '100%'
			}, 'fast', function() {
				$('.LoginUnderLine:first').css('width', '100%')
			})
		}

		function changeLine_First_Leave() {
			switch (flag) {
				case 0:
					$('.LoginUnderLine:first').animate({
								width: '50%'
							},
							'fast',
							function() {
								$('.LoginUnderLine:first').css('width', '50%');
							});

					$('.LoginUnderLine:last').css('display', 'none');
					break;
				case 1:
					$('.LoginUnderLine:first').animate({
								width: '0%'
							},
							'fast'
					);
					break;

			}
		}

		function btn_HoverLine() {


			$('#btn_UserLogin').bind({

				mouseenter: function() {
					changeLine_Last_Enter();
				},
				mouseleave: function() {


					changeLine_Last_Leave();
				}

			});




			$('#btn_PhoneLogin').bind({
				mouseenter: function() {
					changeLine_First_Enter();
				},
				mouseleave: function() {

					changeLine_First_Leave();

				}

			});
		}

		function btn_Switch() {

			$('#btn_UserLogin').click(function() {

				$('.LoginUnderLine:first').css('display', 'none');

				let form_PhoneLogin = $('#form_PhoneLogin');

				form_PhoneLogin.css('display', 'none')

				let form_UserLogin = $('#form_UserLogin');

				form_UserLogin.css('display', 'block')

				flag = 1;

			})

			$('#btn_PhoneLogin').click(function() {

				$('.LoginUnderLine:last').css('display', 'none');

				let form_UserLogin = $('#form_UserLogin');

				let form_PhoneLogin = $('#form_PhoneLogin');

				form_UserLogin.css('display', 'none')

				form_PhoneLogin.css('display', 'block')

				flag = 0;

			})
		}
	</script>
	<style>
		.form-margin {
			margin: 0 auto;
		}

		body {

			box-sizing: border-box;
			max-width: 1920px;
			min-width: 1500px;
			margin: 0 auto;

		}

		#section {
			overflow: hidden;
		}

		.div-btn {

			text-align: center;
			font-weight: 700;
			height: 30px;
			font-size: 16px;
			box-sizing: border-box;
			margin: 0 auto;
			cursor: pointer;
			overflow: hidden;

		}

		#header {
			border-bottom: 2px solid orange;
			padding: 5px 0px 15px 0px;
		}

		div {

			white-space: nowrap;

		}

		#form_UserLogin {
			display: none;

		}


		.LoginUnderLine {

			display: block;
			width: 50%;
			height: 10%;
			background-color: red;
			margin: 5px auto;

		}


		.login-fogetPwd {
			text-align: right;
			margin-top: 10px;
			box-sizing: border-box;
			overflow: hidden;
		}

		a {
			cursor: pointer;
		}

		.layui-form-item {
			margin-bottom: 0px;
		}

		.msgbox {

			height: 18px;

		}

		.loginpanel {
			width: 330px;
			height: 350px;
			position: absolute;
			right: 10%;
			top: 5%;
			border-radius: 10px;
			padding: 40px;
			padding-top: 50px;
			border: 1px solid white;
		}

		.form-bitem {

			padding-top: 15px;
		}

		.btn_Login {
			cursor: pointer;
		}

		#btn_PhoneLogin {
			width: 65%;
		}

		#btn_UserLogin {
			width: 40%;
		}


	</style>

</head>
<body class="layui-layout-body">

<div id="header">
	<div class=" layui-row ">
		<div class="layui-col-lg  layui-col-lg-offset1">
			<img src="../../img/logo.png" style="width: 220px;" />
		</div>
	</div>
</div>


<div id="section" class=" layui-fluid "
	 style=" height: 900px;background: url(../../img/a.png) no-repeat ;background-size: cover; background-color: rgb(39,39,39);">

	<div class="loginpanel" style="background-color: white;">
		<div class="layui-row   ">

			<div class="layui-col-lg6  ">
				<div class="  div-btn  " id="btn_PhoneLogin" >

					手机登录/注册
					<i class="LoginUnderLine"></i>
				</div>

			</div>

			<div class="layui-col-lg6   ">
				<div class=" div-btn  " id="btn_UserLogin">

					密码登入
					<i class="LoginUnderLine" style="display: none;"></i>
				</div>

			</div>


		</div>


		<form class="layui-form" action="${pageContext.request.contextPath}/login/userLogin" method="post" style="margin-top: 20px; " id="form_UserLogin" lay-filter="userForm"
			  novalidate="novalidate">

			<div class="layui-row">
				<div class="layui-form-item layui-col-lg">
					<div class="layui-input-block  form-margin">
						<input type="text" name="username" required lay-verify="required|username"
							   placeholder="用户名" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-col-lg msgbox"><span id="userCheckMsg"></span></div>
			</div>

			<div class="layui-row  ">
				<div class="layui-form-item layui-col-lg">
					<div class="layui-input-block form-margin">
						<input type="password" name="password" required lay-verify="required|password"
							   placeholder="密码" autocomplete="off" class="layui-input">
					</div>

				</div>
				<div class="layui-col-lg msgbox"><span id="nouseID"></span></div>
			</div>

			<div class="layui-row  ">
				<div class="layui-form-item layui-col-lg">
					<div class="layui-input-block form-margin">
						<button class="submit-btn btn_Login layui-bg-orange layui-input" lay-submit  lay-filter="userLogin" >登入</button>
					</div>
				</div>

				<div class="layui-row form-bitem">
					<div class="layui-form-item layui-col-lg6 " pane>
						<div class="layui-input-block form-margin" style="margin: 0px;padding: 0px;">
							<input type="checkbox" name=rememberPwd" title="记住密码" class="layui-input " lay-filter="rememberPwd" id="rememberPwd"
								   lay-skin="primary">
						</div>
					</div>
				</div>
			</div>
		</form>




	<form class="layui-form" action="" style="margin-top: 20px;" id="form_PhoneLogin" method=""  lay-filter="phoneForm" novalidate="novalidate">

		<div class="layui-row">
			<div class="layui-form-item layui-col-lg" pane>
				<div class="layui-input-block  form-margin">
					<input type="text" name="phone" required lay-verify="required|phone" placeholder="电话号码" id="phone"
						   autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-col-lg msgbox"><span id="phoneCheckMsg"></span></div>
		</div>

		<div class="layui-row  ">
			<div class="layui-form-item layui-col-lg7" pane>
				<div class="layui-input-inline form-margin">
					<input type="text" name="idCode" required lay-verify="required " id="idCode"
						   placeholder="验证码" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-col-lg5 " >
				<div id="sendIdentifyingCode"     class="layui-input layui-bg-black" style="cursor: pointer;line-height: 38px;text-align: center;" >
					获取验证码
				</div>
			</div>

			<div class="layui-col-lg12 msgbox "><span id="pwdCheckMsg"></span></div>
		</div>

		<div class="layui-row">
			<div class="layui-col-lg12 " style="margin: 3px 0px 20px 0px; color:darkorange; box-sizing: border-box; overflow: hidden; font-weight: bold;">
				未注册的手机号登录后会直接注册为新的账号
			</div>
			<div class="layui-form-item layui-col-lg">
				<div class="layui-input-block form-margin">
					<button class="submit-btn btn_Login layui-bg-orange layui-input" lay-submit  lay-filter="phoneLogin" >登入</button>
				</div>

			</div>

		</div>
		</form>
	</div>
</div>


</body>

<script>

	layui.use('form', function() {

		var form = layui.form;
		var IdentifyingCode;

		form.on('checkbox(rememberPwd)', function(data){
			$.cookie("flag",data.elem.checked ,{ expires: 7, path: '/' })
		});
		if ($.cookie("flag")==='true')
		{

				form.val("userForm", {
					"username":$.cookie("username")
					,"password": $.cookie("password")
				});
			$("#rememberPwd").prop("checked",true)
			form.render();
		}else{
			form.val("userForm", {
				"username":$.cookie("username")
			});

			form.render();
		}


		form.on('submit(userLogin)', function(data){
			userLogin();
			return false;
		});

		function userLogin(){
			$.ajax({
				method:'post',
				url:"${pageContext.request.contextPath}/userLogin",
				dataType:'text',
				data:form.val("userForm"),
				success:function (data){

					if(data=="error")
					{
						layer.msg("登陆失败" ,{time: 1500 ,icon:2});
						$.cookie("flag","false")
					}
					else{

						if($.cookie("flag")==="true")
						{
							$.cookie("username",form.val("userForm").username, { expires: 7, path: '/' });
							$.cookie("password",form.val("userForm").password, { expires: 7, path: '/' });
						}
						else {

							$.removeCookie("password",{ expires: 7, path: '/' });
						}
						location.href = data;
					}

				}
			})
		};

	});

	function  resetCode(){
	let 	a=60;
		let sendIdentifyingCode=$("#sendIdentifyingCode");
		let timer=null
	 timer =	setInterval(function () {

			if (a>0){
				sendIdentifyingCode.html('('+a+")秒后重新发送");
				sendIdentifyingCode.css({"cursor":"not-allowed","pointer-events":"none"});
				a-=1;
			}else{
				clearInterval(timer);
				sendIdentifyingCode.html("获取验证码");
				sendIdentifyingCode.css({"cursor":"pointer","pointer-events":"unset"});
			}
		}, 1000)
	}


	layui.use('form',function (){

	var	form = layui.form;

	var IdentifyingCode;

	var reg=/^1[3456789]\d{9}$/;
		var sendIdentifyingCode=$("#sendIdentifyingCode");

		sendIdentifyingCode.click(function () {

			var phoneNum =$("#phone").val()

			if(reg.test(phoneNum)){

				$.ajax({
					url: "${pageContext.request.contextPath}/sendIdentifyingCode",
					dataType: 'text',
					data: form.val('phoneForm'),
					success:function (data){
						resetCode();
						layer.msg("验证码已发送", {time: 1500, icon: 1});
						IdentifyingCode=data;
						console.log(IdentifyingCode);
					}
				});
			}else{

				layer.msg("请输入正确的手机号", {time: 1500, icon: 2});
			}
		});
		form.on('submit(phoneLogin)', function(data){
			console.log(IdentifyingCode)
			var idCode=$("#idCode").val();
			if(idCode == IdentifyingCode)
			{
				phoneLogin()
			}
			else {
				layer.msg("验证码错误" ,{time: 1500 ,icon:2});
			}
			return false;
		});


		function phoneLogin(){
			$.ajax({
				method:'post',
				url:"${pageContext.request.contextPath}/phoneLogin",
				dataType:'text',
				data:form.val("phoneForm"),
				success:function (data){

						location.href = data;


				}
			})
		};

	});


</script>
</html>
