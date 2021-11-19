
<%--
  Created by IntelliJ IDEA.
  User: loveYJ
  Date: 2021/10/13
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
  <meta charset="utf-8">
  <title>欢颐游戏商城</title>

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
      max-width: 1920px;
      min-width: 1200px;
      margin: 0 auto;
      background-color: rgb(249,249,240);
    }
    div {

      white-space: nowrap;

    }

    #main-panel{
      margin: 0 auto;width:70%;height: 2250px;margin-top: 30px;
    }

    #person-info{
    width: 20%;height: 400px;float: right;background-color: white;border-radius: 10px;border: 1px solid white;
    }

    .twentyH-games	 {
      border: 1px solid red;width: 30%;height: 200px;display: inline-block; margin-left: 2.5%;overflow: hidden;
    }



    #todayWorthBuy{
     height: 500px;width: 30%;float: left;box-sizing: border-box;overflow: hidden;

    }

    #todayWorthBuy-title p,#personLikePlay-title p,#salesRank-title p,#couponCenter-title p{
    font-size: 25px;font-weight: bold;float: left;  margin-left: 10px ; display: inline-block;  overflow: hidden;
    }
    #todayWorthBuy-title ,#personLikePlay-title ,#salesRank-title ,#couponCenter-title {
      height: 30px;margin-bottom: 10px;
    }
    #todayWorthBuy-title i,#personLikePlay-title i,#salesRank-title i,#couponCenter-title i{
     display: inline-block;width: 10px;border-radius: 10px;background-color: orange;float: left;line-height: 30px
    }

    #todayWorthBuy-title a,#personLikePlay-title a,#salesRank-title a,#couponCenter-title a{
      display: inline-block;font-size: 16px;color: gray;float: right;line-height: 30px;
    }
    .todayWrothBuy-list-big{
      width: 45%;display: inline-block;height: 250px;text-align: center;box-sizing: border-box;border-radius: 10px;
      overflow: hidden;background-size: cover;
    }
    .todayWrothBuy-list-big:nth-child(1){
      float: left;
      margin-left: 2%;
    }
    .todayWrothBuy-list-big:nth-child(2){
      float: right;      margin-right: 2%;
    }

    .todayWrothBuy-list-sm{
      width: 45%;display: inline-block;height: 130px;margin-top:20px;overflow: hidden;box-sizing: border-box;
    }

    .todayWrothBuy-list-sm:nth-child(3){
      float: left;
      margin-left: 2%;
    }

    .todayWrothBuy-list-sm:nth-child(4){
      float: right;
      margin-right: 2%;
    }

    /*.personLikePlay-list-sm-top{*/
    /*  border: 1px solid red;width: 45%;display: inline-block;height: 130px;overflow: hidden;box-sizing: border-box;*/
    /*}*/

    .personLikePlay-list-sm:nth-child(1){
      margin-top: 0px;
      float: left;
      margin-left: 2%;
    }

    .personLikePlay-list-sm:nth-child(2){
      margin-top: 0px;
      float: right;
      margin-right: 2%;
    }

    .personLikePlay-list-sm{
    width: 45%;display: inline-block;height: 130px;margin-top: 20px;overflow: hidden;box-sizing: border-box;border-radius: 10px;
    }

    .personLikePlay-list-sm:nth-child(odd){
      float: left;
      margin-left: 2%;
    }
    .personLikePlay-list-sm:nth-child(even){
      float: right;
      margin-right: 2%;
    }

    #todayWrothBuy-list,#personLikePlay-list,#salesRank-list{
    height: 430px;padding-top: 20px;background-color: white;border-radius: 10px;border: 1px solid white;
    }

    .rank-child{
      height:80px;float:left;position: relative;width: 95%;margin-bottom: 7px;padding-left: 10px;
    }

    .coupon-child{
      float: left;height: 120px;width: 17%;margin-left: 2.35%;margin-top: 20px;background: url("../img/coupon.png") no-repeat center ;background-size:contain;
    }
    .layui-col-lg2{

      display: inline-block;
      box-sizing: border-box;
      overflow: hidden;
      min-width: 16.66666667%;
      font-size: 18px;
    }
    #indexGame-tab a{
      padding-left: 30px;
      width: 100%;display: inline-block;height: 60px;

    }

    #indexGame-tab a:hover{
      color: black;
      /*font-size: 23px;*/
      /*font-weight: bold;*/
    }
    .indexGame-child{
      display: block;width: 100%;height: 70px;margin-bottom: 15px;border-radius: 10px;background-color: rgba(238,238,238,1);
    }
    .indexGame-child:hover{
      background-color: white;box-shadow: -1px 1px 5px 2px lightgray
    }

    .show-person-on-index{
    height: 80px;width: 90%;margin-top:20px;margin-left: 10px;
    }

    #person-info-login{
      border-radius: 20px;display: inline-block;width: 120px;height: 30px;background-color: orange;text-align: center;line-height: 30px;margin-top: 20px
    }

.user_card{
  padding: 10px;margin-left: 14px;margin-top: 35px;margin-bottom: 25px;
  box-sizing: border-box;
  display: inline-block;
  overflow: hidden;

}
.card_text{
  padding-top: 10px;font-size: 20px
}

.user_menu{
  box-sizing: border-box;
  overflow: hidden;
  display: inline-block;
  text-align: center;
  height:80px;
  float: left;
  width:33%;
}

/*.user_menu:nth-child(1){*/
/* border-top: 1px solid lightgray;*/
/*  border-bottom:  1px solid lightgray;*/
/*}*/
/*    .user_menu:nth-child(2){*/
/*      border: 1px solid lightgray;*/
/*    }*/
/*    .user_menu:nth-child(3){*/
/*      border-top: 1px solid lightgray;*/
/*      border-bottom: 1px solid lightgray;*/
/*    }*/
/*    .user_menu:nth-child(4){*/

/*      border-bottom: 1px solid lightgray;*/
/*    }*/
/*    .user_menu:nth-child(5){*/
/*      border: 1px solid lightgray;*/
/*    }*/
/*    .user_menu:nth-child(6){*/

/*      border-bottom: 1px solid lightgray;*/
/*    }*/


.user_menu img{
  width: 30px ;
  height: 30px;
  margin-top: 10px;
  padding-bottom: 10px;
}

#person-info a:hover{
  color: black;
}
    #main-panel-l3 a{
      color: black;
    }
#main-panel-l3 a:hover{
  color: black;
}

.todayWrothBuy-list-big-name{
  font-size: 22px;margin-top: 15px;margin-bottom: 5px;color: black;font-weight: bold;
}
.todayWrothBuy-list-big-ljqg{
 border-radius: 20px;background-color: orange;width: 108px;height: 32px;line-height: 32px;margin: 0 auto;margin-top: 20px
}

.big-discount{
  margin-top:70px;font-size:40px;color: green;font-weight: bold;
}

.smBox-discount{
  width:35%;height: 35px;background-color: rgb(110,196,73);color: white;border-radius: 5px;text-align: center;line-height: 35px;margin-top: 9px;float: left;display: inline-block;font-size: 18px;
}

  .smBox-price{
    color: orangered;font-weight: bold;font-size: 18px;
  }


  .smBox-oPrice{
    font-size: 12px;text-decoration: line-through;color: gray

  }
  .smBox-oPriceNoDiscount{
    color: orangered;font-weight: bold;font-size: 18px; margin-top: 10px;
  }

  .rank-child-img{
   width: 40%;height: 100%;display: inline-block;float: left;
    overflow: hidden;border-radius: 10px;
  }
  .rank-child-gameInfo{
    display: inline-block;margin-top: 0px;margin-left: 10px;float: left;box-sizing: border-box;width: 55%;height: 80px;line-height: 40px;
    overflow: hidden;text-overflow: ellipsis;
  }
  .rank-child-id{
   height: 20px;width: 20px;border-radius: 5px;background-color:lightgray;position: absolute;left: 17px;top: 5px;line-height: 20px;text-align: center;
  }
  .getCoupon{
    display: inline-block;width: 20%;height: 80px;float: right;margin: 20px 10px 0px 0px;white-space: normal;word-wrap: break-word;box-sizing: border-box;
  ;color: white;text-align: center ;overflow:hidden;padding: 0px 10px;padding-top: 15px;cursor: pointer;
  }
  .coupon-text{
    width: 60%;margin:20px 0px 0px 13px;line-height: 40px;height: 80px;box-sizing: border-box;overflow:hidden;float: left;display: inline-block
  }
    .getCoupon:hover{
      color: white;
    }
    .games-tab::after {
      content: ' ';
      position: absolute;
      width: 1.25rem;
      height: 0.1875rem;
      background: #FF6D3F;
      border-radius: 2px;
      bottom: 0.5rem;
      left: 0;
      right: 62%;
      margin: auto;
    }
    .list-GameName{
      font-size: 16px;text-overflow: ellipsis;overflow:hidden;
    }
    .list-PublishTime{
      font-size: 12px;
    }
    .list-discount{
      width:10%;height: 35px;background-color: rgb(110,196,73);color: white;
      border-radius: 5px;text-align: center;line-height: 35px;margin-top: 9px;float: left;display: inline-block;float: left;margin-top: 15px
    }
    .list-gamePriceBox{
      display: inline-block;float: right;height: 70px;box-sizing: border-box;padding-top: 11px;width: 19.5%;margin-left: 10px;text-indent: 20%;
    }
    .list-price{
      color: orangered;font-size:20px;font-weight: bold;width: 100%;
    }
    .list-priceOnly{
      color: orangered;font-size:20px;font-weight: bold;width: 100%;margin-top: 10px;
    }
    .list-Oprice{
      font-size: 12px;text-decoration: line-through;
    }
    .list-gameInfoBox{
      display: inline-block; width: 36% ;height: 70px;box-sizing: border-box;overflow: hidden;float: left;line-height:35px;text-indent: 20px;
    }
    .list-img{
      height: 70px;width: 30%;display: inline-block;overflow:hidden;float: left;border-radius: 10px;
    }
    .indexGame-info-imgs::-webkit-scrollbar{
      display:none;
    }

.todayWrothBuy-list-big:hover img{
 transform: scale(1.5);
  transition: all inherit 1s;

}

.gameName-down{
  width: 100%;height: 80px;border-radius: 10px;position: absolute;top: 0;background:rgba(0,0,0,0.8);display: none;
}

.gameName-down-data{
  width: 100%;color: white;text-align: center;line-height: 40px;font-weight: bold;font-family: '微软雅黑'
}

.indexGame-info{
 width: 40%;top: 0px;height:700px;position: absolute;right: 10px;display: none;background-color: white
;border-radius: 10px;box-shadow: -1px 1px 5px 2px lightgray;
}


  </style>


  <script>


    $(function (){
      getPointsAndOrders();
      $('.rank-child-id:eq(0)').css('background-color','orangered')
      $('.rank-child-id:eq(1)').css('background-color','orange')
      $('.rank-child-id:eq(2)').css('background-color','blue')

      var NewGameList = $('#indexGame-list-NewGames').hide()
      var discountGameList = $('#indexGame-list-Discount').hide()

      ListChange();
      tabClassCange();
      $('.indexGame-info:eq(0)').show();
      $('.indexGame-child').bind({
        mouseenter:function () {

          $('.indexGame-info').hide();

      var  index = $('.indexGame-child').index(this);
          $('.indexGame-info:eq('+index+')').show();
        },
        mouseleave:function () {

        }


      })


      $('.todayWrothBuy-list-sm').bind({
        mouseenter:function () {
          var  index = $('.todayWrothBuy-list-sm').index(this);

          $('.gameName-down:eq('+index+')').show();
        },
        mouseleave:function () {

            $('.gameName-down').hide()

        }
      })


      $('.personLikePlay-list-sm').bind({
        mouseenter:function () {

          var  index = $('.personLikePlay-list-sm').index(this);
          $('.gameName-down:eq('+(index+2)+')').show();

        },
        mouseleave:function () {

            $('.gameName-down').hide()

        }
      })

      search()



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

    function tabClassCange(){
      var hotSale = $('#hotSale');
      var newGames =$('#newGames');
      var discount =$('#discount');
      hotSale.addClass("games-tab");
      hotSale.click(function () {
        hotSale.addClass("games-tab");
        newGames.removeClass("games-tab");
        discount.removeClass("games-tab");
      })

      newGames.click(function () {
        newGames.addClass("games-tab");
        hotSale.removeClass("games-tab");
        discount.removeClass("games-tab");
      })

      discount.click(function () {
        discount.addClass("games-tab");
        newGames.removeClass("games-tab");
        hotSale.removeClass("games-tab");
      })
    }

    function signInPoints() {

      $.ajax({
        url:'/index/signInPoints'
        ,dataType:'text',
        success:function (data) {
          if (data=="ok"){
            layer.msg("签到成功", {time: 1000, icon: 1,offset: '300px'});
            getPointsAndOrders();
          }else{
            layer.msg("今日已签到，不可重复签到", {time: 1000, icon: 2,offset: '300px'});
          }
        }
      })
    }

    function getPointsAndOrders() {

      $.ajax({
          url:"/index/getPointsAndOrders",
        dataType: 'json',
        success:function (data) {
  if (data!="false"){
    $('#pointsText').text(data.points);

    $('#orderText').text(data.orders);
  }

        }
      })
    }

    layui.use(function(){
      var layer = layui.layer
      var carousel = layui.carousel;

      carousel.render({
        elem: '#roll'
        ,width: '78%' //设置容器宽度
        ,height:'400'
        ,arrow: 'hover' //始终显示箭头
      });

    });

    function ListChange() {
      var HotSale =$('#hotSale');
      var NewGame = $('#newGames');
      var discountGame = $('#discount');
      var HotSaleList = $('#indexGame-list-HotSale');
      var NewGameList = $('#indexGame-list-NewGames');
      var discountGameList = $('#indexGame-list-Discount');

      HotSale.click(function () {
        HotSaleList.show();
        NewGameList.hide();
        discountGameList.hide();
      })

      NewGame.click(function () {
        NewGameList.show();
        HotSaleList.hide();
        discountGameList.hide();
      })

      discountGame.click(function () {
        discountGameList.show();
        HotSaleList.hide();
        NewGameList.hide();
      })
    }

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
          <a href="/user/order" id="flushImg" target="_blank">
                <img   src="../img/userHeadImg/${sessionScope.user.headImg}" class="person-icon"></img>
            </a>
        </div>
    </div>
  </c:when>
</c:choose>
  </div>
</div>


<div class="layui-fluid" style="box-sizing: border-box ">

  <div  id="main-panel">

    <div id="mian-panel-c1" style="height: 440px;box-sizing: border-box;overflow: hidden;">
      <div id="roll" style="width: 78%;height: 400px;float: left;box-sizing: border-box;"class="layui-carousel">
        <div carousel-item id="carousel-item">
          <c:forEach items="${rollImg}" var="i">
           <a href="/gameDetails/${i.gid}" style="background: url(../img/rollImg/${i.imgFile}) no-repeat center top;background-size: cover" ></a>
          </c:forEach>
        </div>

      </div>

      <div id="person-info"  >
        <c:choose>
          <c:when test="${sessionScope.user == null}">
              <div style="width: 100%">
                <div class="show-person-on-index" style="text-align: center" >
                  <img   src="../img/userHeadImg/default.png" class="person-icon-nologin" style="height: 80px;width: 80px;"></img></div>

                  <div style="text-align: center;margin-top: 20px">立即注册享受最新优惠福利</div>

                <div style="text-align: center"><a href="/login" id="person-info-login">登录</a></div>
              </div>
          </c:when>
          <c:when test="${ sessionScope.user.userName != null}">
            <div style="width: 100%;box-sizing: border-box;overflow:hidden;" class="layui-row ">
              <div class="show-person-on-index  "style="position:relative;">
                <img   src="../img/userHeadImg/${sessionScope.user.headImg}" class="person-icon" style="height:80px;width: 80px;display: inline-block"></img>

                <div style="display: inline-block;position:absolute;top:10px;left: 40%;width:60%;overflow: hidden;text-overflow: ellipsis; word-break: break-all; ">
                 ${sessionScope.user.userName}
                </div>
                <div style="position: absolute;display: inline-block;top: 40px;left: 40%;background-color: orange;border-radius: 20px;height:30px;width: 80px;text-align: center;line-height: 30px" ><a href="javascript:signInPoints()" >签到领积分</a></div>
              </div>


                <a href="/user/points" class="layui-col-lg5 user_card" ><p>积分</p> <p id="pointsText"class="card_text" ></p> </a>
              <a href="/user/order" class="layui-col-lg5 user_card" >订单 <p id="orderText" class="card_text"></p></a>
            </div>

              <div  style="box-sizing: border-box;overflow:hidden;width: 100%">
                <a href="/user/games" class="user_menu" target="_blank"><img src="../img/user_menuImg/game.png"/><p>我的游戏</p></a>
                <a href="/user/order" class="user_menu" target="_blank"><img src="../img/user_menuImg/order.png"/><p>我的订单</p></a>
                <a href="/user/coupon" class="user_menu" target="_blank"><img src="../img/user_menuImg/coupon.png"/><p>我的优惠卷</p></a>
                <a href="/user/points" class="user_menu" target="_blank"><img src="../img/user_menuImg/points.png"/><p>我的积分</p></a>
                <a href="/user/setting" class="user_menu" target="_blank"><img src="../img/user_menuImg/userInfo.png"/><p>账号管理</p></a>
                <a href="/index/quit" class="user_menu"><img src="../img/user_menuImg/quit.png"  /><p>退出登录</p></a>
              </div>

          </c:when>
        </c:choose>
      </div>
    </div>





    <div id="main-panel-l3"  style="height:550px;min-height: 500px;box-sizing: border-box;overflow: hidden;">

      <div id="todayWorthBuy" style="box-sizing: border-box;overflow: hidden;" >
        <div id="todayWorthBuy-title" ><i >&nbsp;</i><p >今日值得买</p>
          <a href="/games/discount?pageNum=1&pageSize=13">MORE+</a>
        </div>
        <div id="todayWrothBuy-list" >
      <c:forEach items="${discountGame}" var="w" begin="0" end="1">
        <div class="todayWrothBuy-list-big" style="position: relative">
          <img style="position: absolute;width: 100%;height: 250px;left: 0;z-index: 1 ;opacity: 0.4;" src="../img/gamesImg/${w.gamesImg.imgUrl}" >
          <a style=" display: block;width: 100%;height:250px;z-index: 100 ;position: relative;" href="/gameDetails/${w.id}">
              <p class="todayWrothBuy-list-big-name" >${w.gameName}</p>
              <p style="margin-top: 10px;color: black">${w.engGameName}</p>
              <p class="big-discount">-${fn:substring(100- ( w.gamesDiscount.discount *100 ),0, 2)}%</p>
              <p class="timer"></p>
              <p class="todayWrothBuy-list-big-ljqg" >立即抢购</p>
          </a>
        </div>
      </c:forEach>


    <c:forEach items="${discountGame}" var="w" begin="2" end="3">
          <a class="todayWrothBuy-list-sm" style="position: relative" href="/gameDetails/${w.id}">
            <img  style=" width: 98%;height: 80px;border-radius: 10px;" src="../img/gamesImg/${w.gamesImg.imgUrl}">
            <div class="gameName-down" >
              <div class="gameName-down-data">
                <p style="overflow: hidden;text-overflow: ellipsis">${w.gameName}</p>
                <p style="overflow: hidden;text-overflow: ellipsis">${w.engGameName}</p>
              </div>
            </div>
            <p class="smBox-discount" >-${fn:substring(100- ( w.gamesDiscount.discount *100 ),0, 2)}%</p>
            <div style="display: inline-block;float: right;margin-top: 5px;">
              <p class="smBox-price"  >￥${w.discountPrice}</p>
              <p class="smBox-oPrice">￥${w.price}</p>
            </div>
          </a>
    </c:forEach>
        </div>
      </div>


      <div id="personLikePlay" style="height: 500px;width: 30%;float: left;margin-left:5%;box-sizing: border-box;overflow: hidden;">
        <div id="personLikePlay-title"><i >&nbsp;</i><p >大家都在玩</p>
          <a href="/games/hotSale?pageNum=1&pageSize=13">MORE+</a></div>

        <div id="personLikePlay-list" >
      <c:forEach items="${newGames}" var="i" begin="0" end="6">

          <a class="personLikePlay-list-sm" style="position: relative"  href="/gameDetails/${i.id}" >
            <img  style="width: 100%;height: 80px;border-radius: 10px; "src="../img/gamesImg/${i.gamesImg.imgUrl}">
            <div class="gameName-down"  >
              <div class="gameName-down-data" >
                <p style="overflow: hidden;text-overflow: ellipsis">${i.gameName}</p>
                <p style="overflow: hidden;text-overflow: ellipsis">${i.engGameName}</p>
              </div>
            </div>
              <c:if test="${i.gamesDiscount.discount != 1.00}">
                <p class="smBox-discount" >-${fn:substring(100- ( i.gamesDiscount.discount *100 ),0, 2)}%</p>
              </c:if>


            <div style="display: inline-block;float: right;margin-top: 5px;">
              <c:if test="${i.discountPrice != i.price}"><p class="smBox-price"  >￥${i.discountPrice}</p><p class="smBox-oPrice">￥${i.price}</p></c:if>
              <c:if test="${i.discountPrice == i.price}"><p class="smBox-oPriceNoDiscount"  >￥${i.price}</p> </c:if>

            </div>

          </a>


      </c:forEach>
        </div>
      </div>

      <div id="salesRank" style="height: 500px;width: 30%;float: right;box-sizing: border-box;overflow: hidden;">
        <div id="salesRank-title"><i >&nbsp;</i><p >游戏销量榜</p>
        </div>

        <div id="salesRank-list" >
          <c:forEach items="${hotSale}" var="i" begin="0" end="4" varStatus="Status">
          <a class="rank-child" href="/gameDetails/${i.id}" >
            <span class="rank-child-id" >${Status.index+1}</span>
            <img class="rank-child-img" src="../img/gamesImg/${i.orderDetail.productImg}" >
            <div class="rank-child-gameInfo" >
              <p class="list-GameName" >${i.gameName}</p>
              <p class="list-PublishTime">发行于：${i.publishTime}</p>
            </div>
          </a>
          </c:forEach>

        </div>
      </div>
    </div>



    <div id="main-panel-l4-coupon" style="height: 200px; box-sizing: border-box;overflow: hidden;">
      <div id="couponCenter-title"> <i >&nbsp;</i><p >领卷中心</p>
        <a href="/coupon">MORE+</a></div>
      <div id="coupon-list" style="height: 200px">


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


    <div id="main-panel-l5-indexGame" style="height: 980px; box-sizing: border-box;overflow: hidden">
      <div id="indexGame-tab" style="height: 60px;line-height: 60px;">

        <div class="layui-row" style="height: 60px;box-sizing: border-box;overflow: hidden;">
          <div class="layui-col-lg2" ><a style="position: relative" id="hotSale" >热销</a></div>
          <div class="layui-col-lg2" ><a style="position: relative"  id="newGames"  >新品</a></div>
          <div class="layui-col-lg2" ><a  style="position: relative" id="discount"  >折扣</a></div>
        </div>

      </div>

      <div id="indexGame-list-HotSale" style="float: left;width:100%;height: 880px;margin-top:10px;position: relative;">
        <c:forEach items="${hotSale}" var="i"  end="9" begin="0">

        <a class="indexGame-child" href="/gameDetails/${i.id}"  style="width: 55%;">


          <img class="list-img" src="../img/gamesImg/${i.orderDetail.productImg}"/>
          <div class="list-gameInfoBox">
            <p class="list-GameName" >${i.gameName}</p>
            <p class="list-PublishTime">${i.publishTime}&nbsp;&nbsp;|&nbsp;&nbsp;${i.gamesType.typeName}</p>
          </div>
        <c:if test="${i.gamesDiscount.discount != 1.00}"><p class="list-discount">-${fn:substring(100- ( i.gamesDiscount.discount *100 ),0, 2)}%</p></c:if>
          <div class="list-gamePriceBox">
            <c:if test="${i.discountPrice != i.price}"><p class="list-price"  >￥${i.discountPrice}</p><p class="list-Oprice">￥${i.price}</p> </c:if>
            <c:if test="${i.discountPrice == i.price}"><p class="list-priceOnly" >￥${i.price}</p></c:if>
          </div>
        </a>

          <div class="indexGame-info" >
            <div style="line-height: 27px;padding: 20px">
              <p style="font-size: 22px;">${i.gameName}</p>
              <p style="color:gray;">${i.engGameName}</p>
            </div>

            <div style="width: 100%; height: 600px;overflow: scroll;" class="indexGame-info-imgs">
              <c:forEach  items="${i.gamesImgs}" var="z">
                <img  src="../img/gamesImg/${z.imgUrl}"  style="  height: 250px;width: 93%;margin: 5px 20px;display: block;border-radius: 10px;" >
              </c:forEach>
            </div>
          </div>

        </c:forEach>
      </div>


      <div id="indexGame-list-NewGames" style="float: left;width:100%;height: 880px;margin-top:10px;position: relative;"  >
        <c:forEach items="${newGames}" var="i"  end="9" begin="0">
          <a class="indexGame-child" style="width: 55%;"   href="/gameDetails/${i.id}">
            <img class="list-img" src="../img/gamesImg/${i.gamesImg.imgUrl}"/>
            <div class="list-gameInfoBox">
              <p class="list-GameName" >${i.gameName}</p>
              <p class="list-PublishTime">${i.publishTime}&nbsp;&nbsp;|&nbsp;&nbsp;${i.gamesType.typeName}</p>
            </div>
            <c:if test="${i.gamesDiscount.discount != 1.00}"><p class="list-discount">-${fn:substring(100- ( i.gamesDiscount.discount *100 ),0, 2)}%</p></c:if>
            <div class="list-gamePriceBox">
              <c:if test="${i.discountPrice != i.price}"><p class="list-price"  >￥${i.discountPrice}</p><p class="list-Oprice"  >￥${i.price}</p> </c:if>
              <c:if test="${i.discountPrice == i.price}"><p class="list-priceOnly"  >￥${i.price}</p> </c:if>
            </div>
          </a>

          <div class="indexGame-info" >
            <div style="line-height: 27px;padding: 20px">
              <p style="font-size: 22px;">${i.gameName}</p>
              <p style="color:gray;">${i.engGameName}</p>
            </div>
            <div style="width: 100%; height: 600px;overflow: scroll;" class="indexGame-info-imgs">
            <c:forEach  items="${i.gamesImgs}" var="z">
              <img  src="../img/gamesImg/${z.imgUrl}"  style=" height: 250px;width: 93%;margin: 5px 20px;display: block;border-radius: 10px;" >
            </c:forEach>
            </div>
          </div>
        </c:forEach>

      </div>


      <div id="indexGame-list-Discount" style="float: left;width:100%;height: 900px;margin-top:10px;position: relative;"   >
        <c:forEach items="${discountGame}" var="i"  end="9" begin="0">
          <input type="hidden" value="${i.id}" class="id">
              <a class="indexGame-child"  style="width: 55%;"   href="/gameDetails/${i.id}">
          <img class="list-img" src="../img/gamesImg/${i.gamesImg.imgUrl}"/>
          <div class="list-gameInfoBox">
            <p class="list-GameName" >${i.gameName}</p>
            <p class="list-PublishTime">${i.publishTime}&nbsp;&nbsp;|&nbsp;&nbsp;${i.gamesType.typeName}</p>
          </div>
                <c:if test="${i.gamesDiscount.discount != 1.00}"><p class="list-discount">-${fn:substring(100- ( i.gamesDiscount.discount *100 ),0, 2)}%</p></c:if>
          <div class="list-gamePriceBox">
            <c:if test="${i.discountPrice != i.price}"><p class="list-price"  >￥${i.discountPrice}</p><p class="list-Oprice"  >￥${i.price}</p> </c:if>
            <c:if test="${i.discountPrice == i.price}"><p class="list-priceOnly"  >￥${i.price}</p> </c:if>
          </div>
      </a>

          <div class="indexGame-info" >
            <div style="line-height: 27px;padding: 20px">
              <p style="font-size: 22px;">${i.gameName}</p>
              <p style="color:gray;">${i.engGameName}</p>
            </div>
            <div style="width: 100%; height: 600px;overflow: scroll;" class="indexGame-info-imgs">
              <c:forEach  items="${i.gamesImgs}" var="z">
                <img  src="../img/gamesImg/${z.imgUrl}"  style=" height: 250px;width: 93%;margin: 5px 20px;display: block;border-radius: 10px;" >
              </c:forEach>
            </div>
          </div>
        </c:forEach>


      </div>


    </div>
  </div>


  <div id="footer" style="width: 100%;height: 300px;background-color: rgb(71,71,71);position: relative">

      <div id="download">
        <p>下载客户端:</p>
        <div id="pc">
          <span>PC端</span>
          <div class="yuan">
          </div>
        </div>
      </div>

      <div id="official">
        <p>官方渠道:</p>
        <div id="qvdao1">
          <span>微博</span>
          <div class="yuan1">
          </div>
        </div>
        <div id="qvdao2">
          <span>微信</span>
          <div class="yuan2">
          </div>
        </div>
      </div>

      <div id="friend">
        <p id="p">友情连接:</p>
        <div id="ftxt">
          <a id="p1" href="">凤凰游戏</a>
          <a href="" id="p2">杉果游戏</a>
          <a id="p3" href="">WeGame</a>
          <a href="" id="p4">Steam</a>
        </div>
      </div>

      <div id="bqtxt">
        <p>关于我们| AboutWe|服务条款│软件许可及服务协议│隐私保护指引|儿童隐私保护指引侵权通知|广告服务│客服中心│网站导航</p>
        <p>COPYRIGHT @ 2021- 2021 LoveYJ❤GHY.ALL RIGHTS RESERVED.</p>
        <p>LoveYJ版权所有</p>
      </div>

  </div>


</div>


</body>
</html>
