<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/11/1
  Time: 22:58
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
    <link href="../../layui/layui/css/layui.css" rel="stylesheet" />
    <link   rel="stylesheet" href="../../css/header.css"/>
    <link rel="stylesheet" href="../../css/footer.css">


    <style>
        .coupon-child{
            float: left;height: 120px;width: 17%;margin-left: 2.35%;margin-top: 20px;background: url("../img/coupon.png") no-repeat center ;background-size:contain;border: 2px dashed grey;
            padding: 20px;
        }
        .coupon-text{
            width: 60%;margin:20px 0px 0px 13px;line-height: 40px;height: 80px;box-sizing: border-box;overflow:hidden;float: left;display: inline-block;
        }
        .getCoupon:hover{
            color: white;
        }
        .getCoupon{
            display: inline-block;width: 20%;height: 80px;float: right;margin: 20px 0px 0px 0px;white-space: normal;word-wrap: break-word;box-sizing: border-box;
        ;color: white;text-align: center ;overflow:hidden;padding: 0px 10px;padding-top: 15px;cursor: pointer;
        }
    </style>

    <script>
        $(function () {
          search();


            $('.getCoupon').click(function () {

                var index;

                index =$('.getCoupon').index(this);




                $.ajax({
                    url:'/coupon/addCoupon'
                    ,data:{'uid':'${sessionScope.user.id}','cid':$('.cid:eq('+index+')').val()}
                    ,dataType:'text'
                    ,success:function (data) {
                        if (data=='ok')
                        {
                            layer.msg("领取成功", {time: 2000, icon: 1,offset: '300px'});
                            $('.coupon-child:eq('+index+')').remove();
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




<div style="  width: 100%;">


    <div style=" width: 60%;margin: 0 auto;">

        <div id="title" style="width: 100%;font-size: 22px;margin-top: 20px;">领卷中心</div>

        <c:choose>
            <c:when test="${sessionScope.user == null}">

                <c:forEach items="${coupons}" var="i" begin="0" end="6">
                    <div class="coupon-child" >
                        <div class="coupon-text" >
                            <p style="color: orangered;font-size: 30px">￥${i.couponPrice}</p>
                            <p style="color: gray;overflow: hidden;text-overflow: ellipsis;margin-left: 5px">${i.condition}</p>
                        </div>
                        <a class="getCoupon" href="/login">领取</a>
                    </div>
                </c:forEach>
            </c:when>

            <c:when test="${ sessionScope.user.userName != null}">

                <c:forEach items="${userCoupons}" var="i" begin="0" end="6">

                    <div class="coupon-child" >
                        <input type="hidden" class="cid" value="${i.id}">
                        <div class="coupon-text" >
                            <p style="color: orangered;font-size: 30px">￥${i.couponPrice}</p>
                            <p style="color: gray;overflow: hidden;text-overflow: ellipsis;margin-left: 5px">${i.condition}</p>
                        </div>
                        <a class="getCoupon" >领取</a>
                    </div>
                </c:forEach>

            </c:when>
        </c:choose>

    </div>
</div>
</body>
</html>