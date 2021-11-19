<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/11/2
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>欢颐游戏</title>

    <link rel="shortcut icon" href="../../img/shortcut.png" />


    <script src="../../js/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="http://lib.h-ui.net/jquery.cookie/1.4.1/jquery.cookie.js"></script>
    <script src="../../layui/layui/layui.js"></script>
    <script src="../../js/header.js"></script>
    <script src="https://unpkg.com/mathjs@7.1.0/dist/math.js"  type="text/javascript"></script>
    <link href="../../layui/layui/css/layui.css" rel="stylesheet" />
    <link   rel="stylesheet" href="../../css/header.css"/>

    <link rel="stylesheet" href="../../css/font.css">

    <style>

        body {
            box-sizing: border-box;
            max-width: 1920px;
            min-width: 1200px;
            margin: 0 auto;
        }
        div{
            white-space: nowrap;
        }
        .Game-child{
            display: block;width: 100%;height: 70px;margin-bottom: 15px;border-radius: 10px;background-color: rgba(238,238,238,1); color: black;
        }
        .Game-child :hover{
          color: black;
        }


        .list-img{
            height: 70px;width: 15%;display: inline-block;overflow:hidden;float: left;border-radius: 10px;
        }
        .list-GameName{
            font-size:19px;text-overflow: ellipsis;overflow:hidden;font-family: '微软雅黑';font-weight: bold;overflow: hidden;  text-overflow: ellipsis;
        }

        .list-gamePriceBox{
            display: inline-block;float: left;height: 70px;box-sizing: border-box;width: 19.5%;margin-left: 10px;text-indent: 20%;
            line-height: 70px;
        }
        .list-ToolBox{
            display: inline-block;float: right;height: 70px;box-sizing: border-box;width: 19.5%;margin-left: 10px;text-indent: 10%;
            line-height: 70px;
        }
        .list-price{
            color: orangered;font-size:20px;font-weight: bold;width: 100%;display: inline-block;
            overflow: hidden;
        }

        .list-gameInfoBox{
            display: inline-block; width:25% ;height: 70px;box-sizing: border-box;overflow: hidden;float: left;line-height:35px;text-indent: 20px;
            line-height: 70px;
        }
        .coupon-child{
           height: 120px;width:180px;margin-left: 2.35%;background: url("../img/coupon.png") no-repeat center ;background-size:contain;border: 2px dashed grey;float:left;

        }
        .coupon-text{
            width: 60%;margin:20px 0px 0px 13px;line-height: 40px;height: 80px;box-sizing: border-box;overflow:hidden;float: left;display: inline-block;
        }
        .on{
            border: 2px dashed orangered;cursor: pointer;
        }
        .off{
            border: 2px dashed grey;cursor: pointer;
        }
    </style>

    <script>


        function accAdd(arg1, arg2) {
            var r1, r2, m, c, n;
            try {
                r1 = arg1.toString().split(".")[1].length;
            }
            catch (e) {
                r1 = 0;
            }
            try {
                r2 = arg2.toString().split(".")[1].length;
            }
            catch (e) {
                r2 = 0;
            }
            c = Math.abs(r1 - r2);
            m = Math.pow(10, Math.max(r1, r2));
            if (c > 0) {
                var cm = Math.pow(10, c);
                if (r1 > r2) {
                    arg1 = Number(arg1.toString().replace(".", ""));
                    arg2 = Number(arg2.toString().replace(".", "")) * cm;
                } else {
                    arg1 = Number(arg1.toString().replace(".", "")) * cm;
                    arg2 = Number(arg2.toString().replace(".", ""));
                }
            } else {
                arg1 = Number(arg1.toString().replace(".", ""));
                arg2 = Number(arg2.toString().replace(".", ""));
            }

            n = (r1 >= r2) ? r1 : r2;
            return ((arg1 + arg2) / m).toFixed(n);
        }

        function accSub(arg1, arg2) {
            var r1, r2, m, n;
            try {
                r1 = arg1.toString().split(".")[1].length;
            }
            catch (e) {
                r1 = 0;
            }
            try {
                r2 = arg2.toString().split(".")[1].length;
            }
            catch (e) {
                r2 = 0;
            }
            m = Math.pow(10, Math.max(r1, r2)); //last modify by deeka //动态控制精度长度
            n = (r1 >= r2) ? r1 : r2;
            return ((arg1 * m - arg2 * m) / m).toFixed(n);
        }

        $(function () {

            var couponId;
            $('.coupon-child').addClass('off');

            $(".coupon-child").click(function () {



                var index ;
                index =  $('.coupon-child').index(this);
                $('#couponPrice').text($('.cprice:eq('+index+')').val())

                couponId=$('.cid:eq('+index+')').val();

                $('#allprice').text(accSub('${allPrice}', $('#couponPrice').text()))
                if ( 0> $('#allprice').text()){
                    $('#allprice').text('0.00')
                }

                $(this).siblings('.coupon-child').removeClass('on').addClass('off');
                $(this).toggleClass('off');
                $(this).toggleClass('on');
                if ($(this).hasClass('off')){
                    $('#couponPrice').text('0.00')
                    $('#allprice').text(${allPrice})
                    couponId=0;
                }

                console.log(couponId)
            })

            $('#pay').click(function () {
                var gameName=[];
                var Gid=[];
                var productImg=[];
                var productPrice=[];

                $('.list-GameName').each(function () {
                    gameName.push($(this).text())
                })
                $('.Gid').each(function () {
                    Gid.push($(this).val())
                })
                $('.productPrice').each(function () {
                    productPrice.push($(this).val())
                })
                $('.productImg').each(function () {
                    productImg.push($(this).val())
                })



                $.ajax({
                    url:'/buy/insertOrder'
                    ,data:{'gameName':gameName,'finalPrice':$('#allprice').text(),'Gid':Gid,'productPrice':productPrice,'productImg':productImg,'couponID':couponId}
                    ,dataType:'text'
                    ,success:function (data) {
                        if (data=="ok"){
                            location.href='/buy/aliPay'
                        }
                    }
                })
            })





        })




    </script>
</head>
<body>
<div id="header">
    <div class=" layui-row ">

        <div class="layui-col-lg2 logo ">

            <img src="img/logo.png" style="width: 190px;height: 67px;" />

        </div>

        <div class=" layui-col-lg4   nav_list ">
            <ul>
                <li><a href="/index" style="color: white">首页</a></li>

                <li><a href="/games" style="color: white">商城</a></li>
                <li><a href="/pointsShop" style="color: white">积分商城</a></li>
            </ul>
        </div>




        <div class="layui-col-lg4 search"id="">

            <div style="  display: inline-block; padding: 14px 0px; ">
                <div class="search-border">
                    <div style=" display: inline-block;"><input type="text" id="searchText" placeholder="请输入关键词" class="search-input" />
                    </div>
                    <div class="search-icon">&nbsp;</div>
                </div>
            </div>
        </div>

        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <div class="layui-col-lg2 " id="header-right" style="height: 67px;  overflow: hidden;display: inline-block;">

                    <div style="padding: 14px 0px;">
                        <a href="/login" style="text-align: center;">
                            <span style="color: white;line-height: 35px;font-size: 12px;">登录</span>
                        </a>
                    </div>
                </div>
            </c:when>
            <c:when test="${ sessionScope.user.userName != null}">
                <div class="layui-col-lg2 " id="header-right" style="height: 67px;  overflow: hidden;display: inline-block;">

                    <div style="padding: 14px 0px;">
                        <a href="/shopCar">
                            <span class="shopcar">&nbsp;</span>
                        </a>
                        <a href="/user/order" id="flushImg">
                            <img   src="../img/userHeadImg/${sessionScope.user.headImg}" class="person-icon"></img>
                        </a>
                    </div>
                </div>
            </c:when>
        </c:choose>
    </div>
</div>


<div class="layui-fluid" style="">

    <div id="shopCar" style="width: 60%;margin: 0 auto;margin-top: 30px;">

        <div style="font-size: 22px;">确认订单信息</div>

        <div id="title" style="font-size: 16px;margin-top: 20px;box-sizing: border-box" class="layui-row">
            <div class="layui-col-lg6" style="text-align: left;display: inline-block;overflow:hidden;">游戏</div>
            <div class="layui-col-lg6" style="text-align: left;display: inline-block;overflow:hidden;">商品价格</div>
        </div>

        <div id="shopcar-main" style="margin-top: 30px;">


        <c:forEach items="${games}" var="i"  >
                <div  class="Game-child " style="width: 100%;" >

                    <input type="hidden" value="${i.id}" class="Gid">
                    <input type="hidden" value="${i.gamesImg.imgUrl}" class="productImg">
                    <input type="hidden" value="${i.discountPrice}" class="productPrice">
                    <img class="list-img" src="../../img/gamesImg/${i.gamesImg.imgUrl}">
                    <div class="list-gameInfoBox">
                        <p class="list-GameName" >${i.gameName}</p>
                    </div>

                    <div class="list-gamePriceBox">
                        <p class="list-price"  >￥${i.discountPrice}</p>
                    </div>

                </div>
            </c:forEach>

            <div style="font-size: 16px;text-align: right;height: 40px;line-height: 40px">共${count}款商品&nbsp;&nbsp;&nbsp;应付金额￥${allPrice}</div>
        </div>





            <div style="font-size: 22px;margin-bottom: 20px">使用优惠卷</div>



        <c:forEach items="${coupon}" var="i">
                <div class="coupon-child" >
                    <input type="hidden" class="cid" value="${i.id}">
                    <input type="hidden" class="cprice" value="${i.couponPrice}">
                    <div class="coupon-text" >
                        <p style="color: orangered;font-size: 30px">￥${i.couponPrice}</p>
                        <p style="color: gray;overflow: hidden;text-overflow: ellipsis;margin-left: 5px">${i.condition}</p>
                    </div>

                </div>
        </c:forEach>


        <div style="clear: both;height: 100px;box-sizing: border-box;line-height: 40px">

            <div style="text-align: right;font-size: 16px">优惠卷抵扣 ￥<span id="couponPrice">0.00</span></div>
            <div style="text-align: right;font-size: 20px;overflow: hidden;">实付金额:￥<span style="color: orangered;font-size: 28px;" id="allprice">${allPrice}</span></div>


            <div style="text-align: right;overflow: hidden;">
                <div style="height: 40px;line-height: 40px;text-align: center;width: 200px;float: right;border-radius: 8px;background:linear-gradient(rgb(250,86,0) ,rgb(255,158,0) );" id="pay">支付订单</div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
