<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/31
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <title>欢颐游戏商城</title>
    <link rel="shortcut icon" href="../../../img/shortcut.png" />

    <script src="../../../js/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="http://lib.h-ui.net/jquery.cookie/1.4.1/jquery.cookie.js"></script>
    <script src="../../../layui/layui/layui.js"></script>
    <script src="../../js/header.js"></script>
    <link href="../../../layui/layui/css/layui.css" rel="stylesheet" />
    <link   rel="stylesheet" href="../../../css/header.css"/>
    <link rel="stylesheet" href="../../../css/footer.css">
    <link rel="stylesheet" href="../../css/font.css">
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

        #ListHead a {
            width: auto;
            height: 54px;
            line-height: 54px;
            margin: 0 25px;
            font-size: 18px;
        }

        /*#ListHead a:active {*/
        /*	position: relative;*/
        /*	font-weight: bold;*/
        /*	color: #fa4d00;*/
        /*	position: relative;*/
        /*}*/

        .games-tab::before {
            content: '';
            position: absolute;
            width: 1.25rem;
            height: 0.1875rem;
            background: #FF6D3F;
            border-radius: 2px;
            bottom: -1rem;
            left: 0;
            right: 0;
            margin: auto;
        }

        #ListHead a{

            padding:0px  20px;
            cursor: pointer;
            margin-right: 10px;
            background: none;
            outline: none;
            border: none;
            font-size: 16px;
            font-weight: 400;
            height: 50px;
            line-height: 50px;
            position: relative;

        }
        #ListHead a{

            color: black;

        }
        button.active{
            color: #FF6900;
        }

        .games{
            border: 1px solid red; height: 100px;width: 100%;display:block;margin-bottom: 10px;
        }
        #typeList{
            padding: 5px 20px;

        }
        #typeList a{
            box-sizing: border-box;
            float: left;
            border: 1px solid lightgray;
            width:40%;
            height: 35px;
            line-height: 35px;
            padding-left: 10px;
            border-radius: 10px;
            margin-top: 15px;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        #typeList a:hover{
            color: black;
        }
        #typeList a:nth-child(even){

            margin-left: 20px;
        }
        #typeList a span{
            font-size: 13px;
            padding-left: 5px;

        }
        #typeList a i{
            font-size: 18px;
        }

        .Game-child{
            display: block;width: 100%;height: 70px;margin-bottom: 15px;border-radius: 10px;background-color: rgba(238,238,238,1);
        }
        .Game-child:hover{
            background-color: white;box-shadow: -1px 1px 5px 2px lightgray
        }
        .list-img{
            height: 70px;width: 20%;display: inline-block;overflow:hidden;float: left;border-radius: 10px;
        }
        .list-GameName{
            font-size:19px;text-overflow: ellipsis;overflow:hidden;font-family: '微软雅黑';font-weight: bold;overflow: hidden;  text-overflow: ellipsis;
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
            display: inline-block; width: 45% ;height: 70px;box-sizing: border-box;overflow: hidden;float: left;line-height:35px;text-indent: 20px;
        }
    </style>

    <script>
        $(function () {
           $('#discount').addClass("games-tab");

            $('#PriceSlider').mousedown(function () {
                $('#PriceSlider').mousemove(function () {

                    console.log($('#PriceSlider').text())
                    location.href='/games/discount?price='+$('#PriceSlider').text()+'&type=${type}&pageNum=1&pageSize=13'


                })

            })

            search();
        })


        layui.use('slider', function(){
            var slider = layui.slider;
            var sli=  slider.render({
                elem: '#PriceSlider'
                ,max:200
                ,step:25
                ,change: function(value){
                    let sliderval;
                    switch (value){
                        case 0:sliderval='任意数值';break;
                        case value:sliderval='低于￥'+value;break;
                    }
                    $('#PriceSliderVal').text(sliderval)

                }
            });
            sli.setValue(${price})
        });

        layui.use('laypage', function(){
            var laypage = layui.laypage;

            //执行一个laypage实例
            laypage.render({
                elem: 'page'
                ,count:${total}
                ,limit:13
                ,curr:${curr}
                ,jump: function(obj, first){
                    //obj包含了当前分页的所有参数，比如：

                    //首次不执行
                    if(!first){
                        location.href='/games/discount?price=${price}<c:if test="${type != null}">&type=${type}</c:if>'+'&pageNum='+obj.curr+'&pageSize='+obj.limit
                    }
                }


            });
        });
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



<div class="layui-fluid" style=" height: 1400px;">

    <div id="gameList-panel" style="float: left;width: 45%;margin-left: 20%;margin-top: 50px;box-sizing: border-box;overflow: hidden;">


        <div id="ListHead" style="height: 50px;border-radius: 10px;background-color: white">
            <a href="/games/hotSale?pageNum=1&pageSize=13" id="hotSale">畅销</a>
            <a href="/games/discount?pageNum=1&pageSize=13" id="discount">折扣</a>
            <a href="/games/new?pageNum=1&pageSize=13" id="thenew">最新</a>
            <a href="/games/priceUp?pageNum=1&pageSize=13" id="pricesort" class="sort-price">价格<i class=" layui-icon layui-icon-up up" style="position:  relative; top: -5px;font-size: 15px;left: 5px;"></i><i class="layui-icon layui-icon-down down" style="position:  relative; top:8px;left: -10px;font-size: 15px;"></i></a>
        </div>



        <div id="Game-list-Discount" style="width:100%;margin-top:10px;position: relative;">
            <c:if test="${total eq 0}">
                <div style="width: 100%;height:100px;text-align: center;line-height: 100px">暂无相关数据</div>
            </c:if>


            <c:forEach items="${discount}" var="i"  end="15">
                <input type="hidden" value="${i.id}" class="id">
                <a class="Game-child"  style="width: 100%;"href="/gameDetails/${i.id}"  >
                    <img class="list-img" src="../img/gamesImg/${i.gamesImg.imgUrl}"/>
                    <div class="list-gameInfoBox">
                        <p class="list-GameName" >${i.gameName}</p>
                        <p class="list-PublishTime">${i.publishTime}&nbsp;&nbsp;|&nbsp;&nbsp;${i.gamesType.typeName}</p>
                    </div>
                    <p class="list-discount">-${fn:substring(100- ( i.gamesDiscount.discount *100 ),0, 2)}%</p>
                    <div class="list-gamePriceBox">
                        <c:if test="${i.discountPrice != 0.0}"><p class="list-price"  >￥${i.discountPrice}</p><p class="list-Oprice"  >￥${i.price}</p> </c:if>
                        <c:if test="${i.discountPrice == 0.0}"><p class="list-priceOnly"  >￥${i.price}</p> </c:if>
                    </div>
                </a>
            </c:forEach>
        </div>





        <!-- 分页 -->
        <div id="page" style="height: 50px;margin-top: 30px;"></div>
    </div>

    <div class="ListRight" style="float: left;width:16%; height: auto;	margin-top: 50px;	margin-left: 30px; background-color: #ffffff;    border-radius: 10px; overflow: hidden;">

        <div id="ToPrice" style="width: 100%;height:100px;">
            <div class="text" style="line-height:35px;width: 100%;height:35px;border-radius: 10px 10px 0px 0px;text-indent:10px;box-sizing: border-box;
			                background-color: rgb(239,239,239);color:gray">按价格</div>
            <div id="PriceSlider" style="width: 80%;margin: 20px auto 0px;" ></div>
            <div id="PriceSliderVal" style="width: 100%;text-align: center;margin-top: 10px">任意数值</div>
        </div>


        <div id="ToType" style="width: 100%;height:380px;border-radius: 10px">
            <div class="text" style="line-height:35px;width: 100%;height:35px;text-indent:10px;box-sizing: border-box;
			                background-color: rgb(239,239,239);color:gray">按类型</div>

            <div id="typeList" style="width: 100%;height:380px;">
                <c:choose >
                    <c:when  test="${type eq 1}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>动作</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>动作</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=1&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>动作</span></a>
                    </c:otherwise>
                </c:choose>

                <c:choose >
                    <c:when  test="${type eq 2}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>冒险</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>冒险</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=2&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>冒险</span></a>
                    </c:otherwise>
                </c:choose>

                <c:choose >
                    <c:when  test="${type eq 3}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>角色扮演</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>角色扮演</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=3&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>角色扮演</span></a>
                    </c:otherwise>
                </c:choose>

                <c:choose >
                    <c:when  test="${type eq 4}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>射击</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>射击</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=4&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>射击</span></a>
                    </c:otherwise>
                </c:choose>

                <c:choose >
                    <c:when  test="${type eq 5}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>大型多人在线</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>大型多人在线</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=5&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>大型多人在线</span></a>
                    </c:otherwise>
                </c:choose>


                <c:choose >
                    <c:when  test="${type eq 6}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>策略</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>策略</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=6&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>策略</span></a>
                    </c:otherwise>
                </c:choose>


                <c:choose >
                    <c:when  test="${type eq 7}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>模拟</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>模拟</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=7&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>模拟</span></a>
                    </c:otherwise>
                </c:choose>

                <c:choose >
                    <c:when  test="${type eq 8}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>体育</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>体育</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=8&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>体育</span></a>
                    </c:otherwise>
                </c:choose>


                <c:choose >
                    <c:when  test="${type eq 9}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>独立</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>独立</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=9&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>独立</span></a>
                    </c:otherwise>
                </c:choose>


                <c:choose >
                    <c:when  test="${type eq 10}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>休闲</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>休闲</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=10&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>休闲</span></a>
                    </c:otherwise>
                </c:choose>


                <c:choose >
                    <c:when  test="${type eq 11}">
                        <c:if test="${price != null}"><a href="/games/discount?price=${price * 25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-radio "></i><span>竞速</span></a></c:if>
                        <c:if test="${price eq null}"><a href="/games/discount?pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>竞速</span></a></c:if>
                    </c:when>
                    <c:otherwise>
                        <a href="/games/discount?type=11&price=${price *25}&pageNum=1&pageSize=13" ><i class="layui-icon layui-icon-circle "></i><span>竞速</span></a>
                    </c:otherwise>
                </c:choose>

            </div>
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
        <p>COPYRIGHT @ 2021- 2021 LoveYJ.ALL RIGHTS RESERVED.</p>
        <p>LoveYJ版权所有</p>
    </div>

</div>
</body>
</html>