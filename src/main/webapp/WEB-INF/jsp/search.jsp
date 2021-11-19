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

    <title>欢颐游戏商城</title>

    <link rel="shortcut icon" href="../../img/shortcut.png" />


    <script src="../../js/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="http://lib.h-ui.net/jquery.cookie/1.4.1/jquery.cookie.js"></script>
    <script src="../../layui/layui/layui.js"></script>
    <script src="../../js/header.js"></script>
    <link href="../../layui/layui/css/layui.css" rel="stylesheet" />
    <link   rel="stylesheet" href="../../css/header.css"/>
    <link rel="stylesheet" href="../../css/footer.css">
    <link rel="stylesheet" href="../../css/font.css">
    <link rel="stylesheet" href="../../css/footer.css">


    <style>
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
          search();
        })


        layui.use('laypage', function(){
            var laypage = layui.laypage;

            laypage.render({
                elem: 'page'
                ,count:${total}
                ,limit:13
                ,curr:${curr}
                ,jump: function(obj, first){
                    //obj包含了当前分页的所有参数，比如：

                    //首次不执行
                    if(!first){
                        location.href='/games/search?pageNum='+obj.curr+'&pageSize='+obj.limit
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
                    <div style=" display: inline-block;"><input type="text" placeholder="请输入关键词" class="search-input" id="searchText"/>
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



<div style="  width: 100%;height: 1300px">


    <div style=" width: 60%;margin: 0 auto;">

        <div id="title" style="width: 100%;font-size: 20px;color: gray;margin-top: 20px;">关于"<span style="color: black;"><c:if test="${name != null}">${name}</c:if><c:if test="${engName != null}">${engName}</c:if></span>"的搜索结果</div>


        <div id="Game-list-NewGames" style="width:100%;margin-top:20px;position: relative;">

            <c:if test="${total eq 0}">
                <div style="width: 100%;height:100px;text-align: center;line-height: 100px">暂无相关数据</div>
            </c:if>

            <c:forEach items="${search}" var="i" >

                <a class="Game-child" href="/gameDetails/${i.id}"  style="width: 100%;">

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

            </c:forEach>
        </div>

        <!-- 分页 -->
        <div id="page" style="height: 50px;margin-top: 30px;"></div>
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
