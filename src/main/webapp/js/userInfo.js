var myOrderA;
var myGamesA;
var myCouponA;
var myPointsA;
var myInfoA;
var myOrder_items ;
var myGames_items ;
var myCoupon_items ;
var myPoints_items ;
var myInfo_items;
var IdentifyingCode;
var uPhone;
var index;
var originalName;


function flushImg() {
    $.ajax({
        url:'/user/setting/returnSession',
        type:'post',
        success:function (data) {
            console.log(data);
            $('#flushImg').html('<img   src="../img/userHeadImg/'+data+'"     class="person-icon"></img>')
        }
    })
}



function myOrder(){

    let allorder =$('#allorder');
    let finishorder =$('#finishorder');
    let nopay =$('#nopay');
    let allorderT =$('.orderTables:eq(0)');
    let finishorderT=$('.orderTables:eq(1)');
    let nopayT =$('.orderTables:eq(2)');
    finishorderT.hide();
    nopayT.hide();
    allorder.addClass("person-order");
    allOrder();

    allorder.click(function() {
        finishorder.removeClass('person-order');
        nopay.removeClass('person-order');
        allorder.addClass("person-order");
        finishorderT.hide();
        nopayT.hide();
        allorderT.show();
        allOrder();
    });

    finishorder.click(function() {
        nopay.removeClass('person-order');
        allorder.removeClass('person-order');
        finishorder.addClass("person-order");
        allorderT.hide();
        nopayT.hide();
        finishorderT.show();
        finishOrder();
    })

    nopay.click(function() {
        allorder.removeClass('person-order');
        finishorder.removeClass('person-order');
        nopay.addClass("person-order");
        allorderT.hide();
        nopayT.show();
        finishorderT.hide();
        noPay();
    })
}

function allOrder() {

    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#allOrderTable',
            url: '/user/order/allOrder',
            page: {
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']

                ,first: false
                ,last: false
                ,  limit:10
            },
            limit:10,
            parseData: function(res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                console.log(res)
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data":result //解析数据列表
                };
            },
            skin:'nob',
            even:true,
            size:'lg',

            cols: [
                [{
                    field: 'orderDetail',minWidth:235,
                    templet: function (d) {
                        return '<img src="../img/gamesImg/'+d.orderDetail.productImg+'" ' + '>';
                    }
                }, {

                    field: 'orderDetail', title: '游戏名称',
                    templet: function (d) {
                        return d.orderDetail ? d.orderDetail.productName:' ';

                    }
                },{
                    field: 'orderDetail', title: '价格',width: 90,
                    templet: function (d) {
                        return  d.orderDetail ?'￥'+ d.orderDetail.productPrice:' ';
                    }
                },
                    {
                        field:'createTime',title: '下单时间'
                    },{
                    field:'statusName',title: '订单状态',width: 90
                },{
                    field:'payTime',title: '支付时间'
                }
                ]
            ],
        });
    });
}

function noPay() {
    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#noPayTable',
            url: '/user/order/noPayOrder',
            page: {
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']

                ,first: false
                ,last: false
                ,  limit:10
            },
            limit:10,
            parseData: function(res) {
                var result;
                console.log(res)
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code,
                    "msg": res.msg,
                    "count": res.count,
                    "data":result
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'orderDetail',minWidth:235,
                    templet: function (d) {
                        return '<img src="../img/gamesImg/'+d.orderDetail.productImg+'" ' + '>';
                    }
                }, {
                    field: 'orderDetail', title: '游戏名称',
                    templet: function (d) {
                        return d.orderDetail ? d.orderDetail.productName:' ';

                    }
                },{
                    field: 'orderDetail', title: '价格',width: 90,
                    templet: function (d) {
                        return d.orderDetail ?'￥'+d.orderDetail.productPrice:' ';
                    }
                },
                    {
                        field:'createTime',title: '下单时间',
                    },{
                    field:'statusName',title: '订单状态',width: 90,
                },{
                    fixed: 'right', width: 180, align:'center', toolbar: '#colTool',title: '操作'
                }
                ]
            ],
        });
        table.on('tool(noPayTable)', function(obj){
            var data = obj.data
                ,layEvent = obj.event;
            if(layEvent === 'pay'){

                var checked =[data.orderDetail.gid];

                $.ajax({
                    url:'/buy/continueBuy'
                    ,data: {'checked':checked,'price':data.orderDetail.productPrice,'oid':data.id}
                    ,dataType: 'text'
                    ,success:function (data) {
                        if (data=='ok'){

                            location.href='/buy'
                        }
                    }
                })

            } else if(layEvent === 'delete'){
                layer.confirm('确定取消此订单？', function(index){
                    $.ajax({
                        url:'/user/order/cancelOrder',
                        data:{'id':data.id},
                        dataType:'text',
                        success:function (data) {
                            layer.msg(data, {time: 1500, icon: 1});
                            noPay();
                        }
                    })

                    layer.close(index);
                });



            }
        });
    });
}


function finishOrder() {
    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#finishOrderTable',
            url: '/user/order/finishOrder',
            page: {
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']

                ,first: false
                ,last: false
                ,  limit:10
            },
            limit:10,
            parseData: function(res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data":result //解析数据列表
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'orderDetail',minWidth:235,
                    templet: function (d) {
                        return '<img src="../img/gamesImg/'+d.orderDetail.productImg+'" ' + '>';
                    }
                }, {
                    field: 'orderDetail', title: '游戏名称',
                    templet: function (d) {
                        return d.orderDetail ? d.orderDetail.productName:' ';
                    }
                },{
                    field: 'orderDetail', title: '价格',
                    templet: function (d) {
                        return d.orderDetail ?"￥"+ d.orderDetail.productPrice:' ';
                    }
                },
                    {
                        field:'createTime',title: '下单时间'
                    },{
                    field:'payTime',title: '支付时间'
                }
                ]
            ],
        });
    });
}


function myGamesTable() {
    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#myGames',
            url: '/user/games/uGames',
            page: {
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']

                ,first: false
                ,last: false
                ,  limit:10
            },
            limit:10,
            parseData: function(res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data":result //解析数据列表
                };
            },
            skin:'nob',
            even:true,
            size:'lg',

            cols: [
                [{
                    field: 'gImg',title:'我的游戏',width:235,
                    templet: function (d) {
                        return '<img src="../img/gamesImg/'+d.gImg+'" ' + '  >';
                    }
                }, {
                    field: 'gName',align:'left',
                }
                ]
            ],
        });
    });
}

function myGames() {
    myGamesTable();
}

function notUse() {
    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#notuseTable',
            url: '/user/coupon/notUseCoupon',
            page: {
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']

                ,first: false
                ,last: false
                ,  limit:10
            },
            limit:10,
            parseData: function(res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data":result //解析数据列表
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'couponName',title:'优惠卷名称'
                },{
                    field: 'userCoupon',title: '获取时间',
                    templet: function (d) {
                        return d.userCoupon ? d.userCoupon.getTime : ' ';
                    }
                }
                    ,{
                    field: 'endTime',title: '过期时间'
                },{
                    field: 'condition',title: '使用范围'
                }
                ]
            ],
        });
    });
}

function usedCoupon() {
    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#usedTable',
            url: '/user/coupon/usedCoupon',
            page: {
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']

                ,first: false
                ,last: false
                ,  limit:10
            },
            limit:10,
            parseData: function(res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data":result //解析数据列表
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'couponName',title:'优惠卷名称',
                },{
                    field: 'userCoupon',title: '使用时间',
                    templet: function (d) {
                        return d.userCoupon ?d.userCoupon.useTime : ' ';
                    }
                }
                    ,{
                    field: 'condition',title: '使用范围'
                }
                ]
            ],
        });
    });
}

function overdueCoupon() {
    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#overdueTable',
            url: '/user/coupon/overdueCoupon',
            page: {
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']

                ,first: false
                ,last: false
                ,  limit:10
            },
            limit:10,
            parseData: function(res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data":result //解析数据列表
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'couponName',title:'优惠卷名称'
                },{
                    field: 'endTime',title: '过期时间',
                }
                ]
            ],
        });
    });
}

function myCoupon() {
    let notUseI = $('#notUse');
    let used=$('#used');
    let overdue = $('#overdue');
    let notUseT =$('.couponTables:eq(0)');
    let usedT=$('.couponTables:eq(1)');
    let overdueT =$('.couponTables:eq(2)');
    notUseI.addClass('person-coupon');
    notUse();
    usedT.hide();
    overdueT.hide();
    notUseI.click(function (){
        notUse();
        notUseI.addClass('person-coupon');
        used.removeClass();
        overdue.removeClass();
        notUseT.show();
        usedT.hide();
        overdueT.hide();
    })

    used.click(function () {
        usedCoupon();
        used.addClass('person-coupon');
        notUseI.removeClass();
        overdue.removeClass();
        usedT.show();
        overdueT.hide();
        notUseT.hide();
    })

    overdue.click(function () {
        overdueCoupon();
        overdue.addClass('person-coupon');
        notUseI.removeClass();
        used.removeClass();
        overdueT.show();
        notUseT.hide();
        usedT.hide();
    })


}


function getUserPoints(){
    $.ajax({
        url:'/user/points/returnUserPoints',
        dataType:'text',
        success:function (data) {
            $('#now-points-div').html('<p id="now-points">'+data+'</p>')
        }
    });


    layui.use('table', function() {
        var table = layui.table;
        table.render({
            elem: '#pointsTable',
            url: '/user/points/returnUserPointsDetails',
            page: {
                layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']

                ,first: false
                ,last: false
                ,  limit:10
            },

            parseData: function(res) {
                console.log(res)
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data":result //解析数据列表
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'typeName',title:'名称'
                },{
                    field: 'time',title: '时间',
                },{
                    field: 'changePoints',title: '积分变动',
                    templet: function (d) {
                        return d.changePoints ?d.flag + d.changePoints : ' ';
                    }
                }
                ]
            ],
        });
    });

}


function myPoints() {

    getUserPoints();

}

function myInfo() {

    loadUseInfo();



}




layui.use('upload', function(){
    var upload = layui.upload;
    //执行实例
    upload.render({
        elem: '#imgUpload' //绑定元素
        ,url: '/user/setting/getHeadImgFile' //上传接口
        , field: "fileUp"
        , acceptMime:'image/*'
        ,before: function(obj){
            obj.preview(function(index, file, result){
                $('#person-img').attr('src', result);
            });

        }
        ,done: function(res){
            //上传完毕回调
            console.log(res)
        }
        ,error: function(){
            //请求异常回调
        }
    });
});


function loadUseInfo(){

    layui.use('form', function(){
        var form = layui.form;

        // <button  class="layui-btn file-upicon " id="imgUpload"><i class="layui-icon"  >&#xe67c;</i></button>
        $.ajax({
            url:'/user/setting/userInfoById',
            dataType: 'json',
            success:function (data) {
                originalName=data.userName
                $('#person-img').remove();
                form.val("infoForm", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                    "username": data.userName // "name": "value"
                });
                uPhone=data.phone;
                $('<img  src="../img/userHeadImg/'+data.headImg+'" id="person-img" />').appendTo($('#person-img-div'));
                $('#phone-div').html('<p id="person-phone" style="font-size: 15px;display: inline-block;">'+data.phone+'</p><a href="javascript:updatePhone()" style="display: inline-block; margin-left: 20px;width: 80px"> 修改手机</a>')
                $('#person-introduce').text(data.introduce)
            }
        })

    });

}

layui.use('form', function(){
    var form = layui.form;
    form.verify({
        username: function(value, item) {
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '用户名不能有特殊字符';
            }
        }
    });
    //监听提交
    form.on('submit(personInfo)', function(data){
        // layer.msg(JSON.stringify(data.field));

        $.ajax({
            url:'/user/setting/updateUserInfo',
            type:'post',
            data:form.val('infoForm'),
            dataType:'text',
            success:function (data) {
                if (data=="false"){
                }else {
                    layer.msg("保存成功！" ,{time: 1500 ,icon:1});

                    flushImg();

                    form.render();
                    nameSpan.text(" ")
                    originalName=nameInput.val();

                }
            }
        })
        return false;
    })
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
function sendCode() {
    var phone =$('#newPhone').val()
    if(!/^1[3456789]\d{9}$/.test(phone)) {
        layer.msg("手机号输入有误", {time: 1500, icon: 2});
    }else{
        $.ajax({
            url: "/sendIdentifyingCode",
            dataType: 'text',
            data: {'phone':phone},
            success:function (data){
                resetCode();
                layer.msg("验证码已发送", {time: 1500, icon: 1});
                IdentifyingCode=data;
                console.log(IdentifyingCode);
            }
        });
    }

}

function updatePhone(){

    index=	layer.open({

        title:'修改手机',
        type:1
        ,content: '<div class="layui-row" style="padding:20px 10px;width: 300px">' +
            '' +
            '<div id="aPage" style="line-height: 30px;display: unset" >' +
            '<span class="layui-col-lg3">新手机：</span>' +
            '<input class="layui-col-lg7" id="newPhone">' +
            '<input type="text" class="layui-col-lg3" id="getIdCode" style="margin-top: 20px;padding: 5px 0px">' +
            '<div class="layui-col-lg5" style="background-color: orange;text-align: center;cursor: pointer;margin-top: 20px;" id="sendIdentifyingCode" onclick="sendCode()">发送验证码</div>' +
            '<span  class="layui-col-lg7" style="margin-top: 20px;">&nbsp;</span>' +
            '<button onclick="uppnum ()" class="layui-col-lg4" id="phoneRight" style="margin-top: 20px">确定</button>' +
            '</div>' +
            '</div>'


    })

}
function uppnum() {

    $.ajax({
        url:'/user/setting/checkUserNameAndPhone',
        data:{'userName':'','phone':$('#newPhone').val()},
        dataType:'text',
        type:'post',
        success:function (data) {
            if (data=="ok"){
                if ($("#getIdCode").val()==IdentifyingCode){
                    $.ajax({
                        url:'/user/setting/updatePhone',
                        data:{'phone':$('#newPhone').val()},
                        dataType:'text',
                        type:'post',
                        success:function (data) {
                            if (data=="ok"){
                                layer.msg("修改成功", {time: 1500, icon: 1});
                                setTimeout(function () {
                                    layer.close(index);
                                    loadUseInfo();
                                },2000)


                            }
                        }
                    })
                }else {
                    layer.msg("验证码错误", {time: 1500, icon: 2});
                }
            }else {
                layer.msg("该手机号码已存在", {time: 1500, icon: 2});
            }
        }
    })
}

function updatePwd() {
    index=	layer.open({

        title:'修改密码',
        type:1
        ,content: '<div class="layui-row" style="padding:20px 0px 20px 50px;width:300px ">' +
            '' +
            '<div id="bPage" style="line-height: 30px;" >' +
            '<span class="layui-col-lg3">新密码：</span>' +
            '<input class="layui-col-lg6" id="newPwd" type="password">' +
            '<div class="layui-col-lg12"></div>' +
            '<span class="layui-col-lg3">确认密码：</span>' +
            '<input class="layui-col-lg6" id="isRightPwd" type="password">' +
            '<div class="layui-col-lg12"></div>' +
            '<button  class="layui-col-lg4" id="nextStep1" style="margin-top: 20px" onclick="uppwd()">确定</button>' +
            '</div>' +
            '</div>'

    })


}

function uppwd(a,b) {

    if ($('#newPwd').val()!=$('#isRightPwd').val()){

        layer.msg("2次密码不一致！" ,{time: 1500 ,icon:2})

    }else {

        $.ajax({

            url:'/user/setting/updatePwd',
            data:{'pwd':$('#isRightPwd').val()},
            dataType:'text',
            type:'post',
            success:function (data) {
                if(data=='ok'){

                    layer.msg("修改成功！" ,{time: 1500 ,icon:1},function (){
                        location.href='/login'
                    })
                }
            }
        })

    }

}

