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
    <title>欢颐游戏商城</title>

    <link rel="shortcut icon" href="../../img/shortcut.png" />


    <script src="../../js/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="http://lib.h-ui.net/jquery.cookie/1.4.1/jquery.cookie.js"></script>
    <script src="../../layui/layui/layui.js"></script>
    <script src="../../js/header.js"></script>
    <script src="https://unpkg.com/mathjs@7.1.0/dist/math.js"  type="text/javascript"></script>
    <link href="../../layui/layui/css/layui.css" rel="stylesheet" />
    <link   rel="stylesheet" href="../../css/header.css"/>
    <link rel="stylesheet" href="../../css/footer.css">

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
            display: block;width: 100%;height: 70px;margin-bottom: 15px;border-radius: 10px;background-color: rgba(238,238,238,1);
        }
        .Game-child:hover{
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

    </style>

    <script>

        var price1 =0.00;
        var checked=[];
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

        function price() {
            let index ;

            $('.cb').change(function () {
                // if (price<0){
                //     $('#allprice').text('0.00')
                // }
                index = $('.cb').index(this);
                if ($('.cb:eq('+index+')').prop('checked')==true){
                    price1 = accAdd(price1,parseFloat($('.list-price:eq('+index+')').text().substr(1)));
                    $('#allprice').text(price1)
                    checked.push($('.gid:eq('+index+')').val())
                }else
                {
                    price1=  accSub(price1,parseFloat(($('.list-price:eq('+index+')').text().substr(1))))
                    $('#allprice').text(price1)
                    checked.forEach(function(item, index2, arr) {

                        if(item == $('.gid:eq('+index+')').val()) {

                            arr.splice(index2, 1);

                         }

                    });
                }


            })
            $('#pay').click(function () {

                if (price1==0){
                    layer.msg("请选择要付款的商品", {time: 2000, icon: 2,offset: '300px'});
                }else {

                    console.log(checked.toString())
                    $.ajax({
                        url:'/buy/getOrderInfo'
                        ,data: {'checked':checked,'price':price1}
                        ,dataType: 'text'
                        ,success:function (data) {
                            if (data=='ok'){

                                location.href='/buy'
                            }
                        }
                    })
                }
            })
        }

        function allPick(){


            $('#allPick').change(function () {
                if ($('#allPick').prop('checked')==true)
                {
                    $('.cb').prop('checked',true);

                    price1=0

                    for (let i = 0; i < $('.list-price').length ; i++) {
                        checked.push($('.gid:eq('+i+')').val())
                        price1 = accAdd(price1,parseFloat($('.list-price:eq('+i+')').text().substr(1)));
                        $('#allprice').text(price1)
                    }

                }else {
                    $('.cb').prop('checked',false);
                    // for (let i = 0; i < $('.list-price').length ; i++) {
                    //     price1 =  accSub(price1,parseFloat(($('.list-price:eq('+i+')').text().substr(1))))
                    //     $('#allprice').text(price1)
                    // }
                    price1='0.00'
                    $('#allprice').text(price1)
                }

            })
        }

        function deleteInShopcar(){
            let index ;
            $('.delete').click(function () {
                index=$('.delete').index(this);

                $.ajax({
                    url:'/shopCar/deleteGameInShopCar'
                    ,data:{'gid':$('.gid:eq('+index+')').val()}
                    ,dataType:'text'
                    ,success:function (data) {
                        if(data=="ok"){
                            layer.msg("删除成功", {time: 2000, icon: 1,offset: '300px'});
                            $('.Game-child:eq('+index+')').remove()
                        }
                    }
                })

            })
        }
        $(function () {

             price1 =0.00;
            $('#allPick').prop('checked',false);
            $('.cb').prop('checked',false);

            price();
            
        deleteInShopcar();

        allPick();
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

        <div style="font-size: 22px;">购物车</div>
<c:choose>
    <c:when test="${shopCarList.size() eq 0}">

        <div style="height: 300px;text-align: center;line-height: 300px">这里空空如也,请前往<a style="color: orangered" href="/games">游戏商城</a>购买</div>


    </c:when>

    <c:otherwise>
        <div id="title" style="font-size: 20px;margin-top: 20px;box-sizing: border-box" class="layui-row">
            <div class="layui-col-lg2" style="text-align: center;display: inline-block;overflow:hidden;">游戏</div>
            <div class="layui-col-lg8" style="text-align: center;display: inline-block;overflow:hidden;">商品价格</div>
            <div class="layui-col-lg2" style="display: inline-block;overflow:hidden;">操作</div>
        </div>

        <div id="shopcar-main" style="margin-top: 30px;">


          <c:forEach items="${shopCarList}" var="i">
              <a  class="Game-child " style="width: 100%;">
                    <input class="gid" value="${i.games.id}" type="hidden">
                  <div  style="float: left;padding-top: 30px;height: 40px;margin-right: 10px;display: inline-block;">

                      <input type="checkbox" lay-skin="primary" class="cb" >

                  </div>
                  <img class="list-img" src="../../img/gamesImg/${i.games.gamesImg.imgUrl}">
                  <div class="list-gameInfoBox">
                      <p class="list-GameName" >${i.games.gameName}</p>
                  </div>

                  <div class="list-gamePriceBox">
                          <%--                    <p style="display: inline-block;overflow: hidden">￥<p class="list-price"  >${i.games.discountPrice}</p></p>--%>
                      <p class="list-price"  >￥${i.games.discountPrice}</p>
                  </div>

                  <div class="list-ToolBox">
                      <p style="font-size: 16px" class="delete">删除</p>
                  </div>
              </a>
          </c:forEach>

            <div><input type="checkbox" id="allPick">全选</div>
        </div>

        <div style="clear: both;height: 100px;box-sizing: border-box;">


            <div style="text-align: right;font-size: 20px;overflow: hidden;">总金额:￥<span style="color: orangered;font-size: 28px;" id="allprice">0.00</span></div>


            <div style="text-align: right;overflow: hidden;">
                <div style="height: 40px;line-height: 40px;text-align: center;width: 200px;float: right;border-radius: 8px;background:linear-gradient(rgb(250,86,0) ,rgb(255,158,0) );" id="pay">支付订单</div>
            </div>
        </div>
          </c:otherwise>
      </c:choose>

    </div>

</div>
</body>
</html>
