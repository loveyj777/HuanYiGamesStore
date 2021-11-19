<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/11/2
  Time: 16:09
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
        body {

            box-sizing: border-box;
            background-color: rgb(249,249,240);
            max-width: 1920px;
            min-width: 1200px;
            margin: 0 auto;

        }

        div {

            white-space: nowrap;

        }

        #game-introduction-img{
            height: 500px;float: left;width:60%;margin-top: 20px;border-radius: 10px;
        }
        .img-sm-border{
            width: 20%;height: 90px;display: inline-block;box-sizing: border-box;margin-left:20px;margin-top: 10px;border-radius: 10px;position: relative
        }
        .img-sm-div{
            width: 100%;float: left;box-sizing: border-box;height: 110px;overflow: hidden;
        }
        #game-introduction-buy{
            height: 460px;float: right;width: 38%;margin-top: 20px;border-radius: 10px;
        }
        #intro-img{
            width: 40%;height: 110px;display: inline-block;float: left;border-radius: 10px;
        }
        #price{
            font-size: 40px;color: orangered;font-weight: bold;display: inline-block;overflow: hidden;
        }
        #Oprice{
            font-size:20px;color: gray;display: inline-block;overflow: hidden;height: 55px;line-height: 55px;text-decoration: line-through;margin-left: 20px;margin-right: 20px;
        }
        #discount{
            height: 30px;line-height: 30px;width:80px;border-radius: 8px;background-color: rgb(110,196,73);text-align: center;margin-top: 13px;color: white;font-size: 18px;font-weight: bold;
        }
        #buyNow{
            border: 1px solid orangered;width: 50%;height:50px;text-align: center;line-height:50px;border-radius: 8px;background:linear-gradient(rgb(250,86,0) ,rgb(255,158,0) );color: white;font-size: 20px;font-weight: bold;margin-top: 20px;display: inline-block;overflow: hidden;
        }
        #hasGame{
            border: 1px solid orangered; color: orangered;height: 50px;width: 100%;line-height: 50px;text-align: center;display: inline-block;overflow: hidden;border-radius: 8px;font-size: 20px;
        }
        #addShopcar{
            border: 1px solid orangered; color: orangered;width: 45%;height: 50px;line-height: 50px;text-align: center;display: inline-block;overflow: hidden;border-radius: 8px;font-size: 20px;
        }

        #game-introduction-text{
          float: left;width:60%;margin-top: 0px;background: white;border-radius: 8px;
        }
        #intro-text{
        white-space: normal;width: 100%;padding:10px 20px;box-sizing: border-box;line-height: 25px;
        }
        .sortup{
      background: url(../../img/sort-up.png);position: absolute;z-index: 100;top: -20px;left: 50px;display: inline-block;width: 32px;height: 19px;display: none;
        }
        .border-color{
         border:2px solid rgb(250,77,0);
        }
    </style>

    
    <script>

        $(function () {
            var index=0;
            var time =3500;
            $('.img-sm').click(function () {
                $('.img-sm-border').removeClass('border-color')
                $('.sortup').hide();
                index= $('.img-sm').index(this);
                $('.img-sm-border:eq('+index+')').addClass('border-color')
                $('.img-big').attr('src',$('.img-sm:eq('+index+')').attr('src'))
                $('.sortup:eq('+index+')').show();
            })

            $('.img-sm-border:eq('+index+')').addClass('border-color')
            $('.img-big').attr('src',$('.img-sm:eq('+index+')').attr('src'))
            $('.sortup:eq('+index+')').show();

            setInterval(function () {
                $('.img-sm-border').removeClass('border-color')
                $('.sortup').hide();
                $('.sortup:eq('+index+')').show();
                $('.img-sm-border:eq('+index+')').addClass('border-color')
                $('.img-big').attr('src',$('.img-sm:eq('+index+')').attr('src'))
                index++
                if (index==4){
                    index=0
                }
            },time)

            addToShopCar();
search();

            $('#buyNow').click(function () {
                if ('${sessionScope.user.id}'==0){
                    location.href='/login'
                    }
                else{
                    var checked =['${game.id}'];
                    checked.push();
                    $.ajax({
                        url:'/buy/getOrderInfo'
                        ,data: {'checked':checked,'price':'${game.discountPrice}'}
                        ,dataType: 'text'
                        ,success:function (data) {
                            if (data=='ok'){

                                location.href='/buy'
                            }
                        }
                    })
                }



            })
        })

        function addToShopCar(){
            let addShopcar = $('#addShopcar');
            
            addShopcar.click(function () {
        if ('${sessionScope.user.id}'==0){
            location.href='/login'
        }else {
            $.ajax({
                url:'/shopCar/selectShopCarIfExistByUid'
                ,data: {'uid':'${sessionScope.user.id}','gid':'${game.id}'}
                ,dataType: 'text'
                ,success:function (data) {
                    if (data=='ok'){


                        $.ajax({
                            url:'/shopCar/addToShopCar'
                            ,data:{'uid':'${sessionScope.user.id}','gid':'${game.id}','price':'${game.discountPrice}'}
                            ,dataType:'text'
                            ,success:function (data) {
                                if (data=='ok'){
                                    layer.msg("添加成功", {time: 2000, icon: 1,offset: '300px'});
                                }
                            }
                        })

                    }else{
                        layer.msg("该游戏购物车已存在", {time: 2000, icon: 2,offset: '300px'});
                    }
                }
            })
        }


            })
        }
    </script>
</head>
<body>

<div id="header">
    <div class=" layui-row ">

        <div class="layui-col-lg2 logo ">

            <img src="../img/logo.png" style="width: 190px;height: 67px;" />

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

<div class="layui-fluid">
    <div id="details" style="width: 65%;margin: 0 auto;height: 1200px;">



        <div id="title" style="margin-top: 50px;">

            <h1 style="margin-bottom: 5px" >${game.gameName}</h1>
            <p>${game.engGameName}</p>

        </div>

        <div id="game-introduction-img" >
            <img  style="width: 100%;height: 350px;border-radius: 10px;"class="img-big" />

            <div class="img-sm-div">
                <c:forEach items="${imgs}" var="i" begin="0" end="5">

                <div class="img-sm-border"  >
                    <i  class="sortup"></i>
                    <img style="width: 100%;height: 86px;border-radius: 10px;" src="../../img/gamesImg/${i.gamesImg.imgUrl}" class="img-sm"/>
                </div>
                </c:forEach>
            </div>
        </div>


        <div id="game-introduction-buy" style="background: white ;">

            <div style="height: 110px;border-radius: 10px;margin: 15px;background-color: rgb(235,235,235)">
                <img id="intro-img"  src="../../img/gamesImg/${game.gamesImg.imgUrl}" />

                <div style="width: 57%;height: 110px;display: inline-block;float: right;line-height: 50px;">

                    <p style="font-size: 22px;">${game.gameName}</p>
                    <p style="font-size: 15px;">${game.engGameName}</p>
                </div>

            </div>



            <div style="margin:0 15px;height: 150px;margin-top: 160px;">

                <div style="height: 55px;box-sizing: border-box;overflow: hidden;">

                    <p id="price">￥${game.discountPrice}</p>
                    <c:if test="${game.discountPrice != game.price}">  <p id="Oprice">￥${game.price}</p></c:if>
                    <div style="display: inline-block;height: 55px;line-height: 55px;overflow: hidden;width: 30%;">
                        <c:if test="${game.discountPrice != game.price}"><p id="discount">-${fn:substring(100- ( game.gamesDiscount.discount *100 ),0, 2)}%</p></c:if>
                    </div>
                </div>

      <c:choose>
          <c:when test="${userGames !=null}">
                <div style="box-sizing: border-box;width: 100%;height: 100px;">
              <div id="hasGame">你已拥有此游戏</div>
                </div>
          </c:when>
          <c:otherwise>
              <div style="box-sizing: border-box;width: 100%;height: 100px;">
                  <div id="buyNow">立即购买</div>
                  <div id="addShopcar">加入购物车</div>
              </div>
          </c:otherwise>
      </c:choose>

            </div>
        </div>


        <div id="game-introduction-text" >
            <div  style="margin-left: 20px;font-size: 22px;font-weight: bold;font-family: '微软雅黑';">游戏介绍</div>
            <div id="intro-text">

                ${game.descript}



            </div>
        </div>
    </div>

</div>

</body>
</html>
