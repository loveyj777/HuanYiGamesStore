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
            $('#flushImg').html('<img   src="http://119.91.193.63:8080/HuanYiGamesStore/img/userHeadImg/'+data+'"     class="person-icon"></img>')
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
            parseData: function(res) { //???????????????????????? table ???????????????????????????res??????url???get????????????
                console.log(res)
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //??????????????????
                    "msg": res.msg, //??????????????????
                    "count": res.count, //??????????????????
                    "data":result //??????????????????
                };
            },
            skin:'nob',
            even:true,
            size:'lg',

            cols: [
                [{
                    field: 'orderDetail',minWidth:235,
                    templet: function (d) {
                        return '<img src="http://119.91.193.63:8080/HuanYiGamesStore/img/gamesImg/'+d.orderDetail.productImg+'" ' + '>';
                    }
                }, {

                    field: 'orderDetail', title: '????????????',
                    templet: function (d) {
                        return d.orderDetail ? d.orderDetail.productName:' ';

                    }
                },{
                    field: 'orderDetail', title: '??????',width: 90,
                    templet: function (d) {
                        return  d.orderDetail ?'???'+ d.orderDetail.productPrice:' ';
                    }
                },
                    {
                        field:'createTime',title: '????????????'
                    },{
                    field:'statusName',title: '????????????',width: 90
                },{
                    field:'payTime',title: '????????????'
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
                        return '<img src="http://119.91.193.63:8080/HuanYiGamesStore/img/gamesImg/'+d.orderDetail.productImg+'" ' + '>';
                    }
                }, {
                    field: 'orderDetail', title: '????????????',
                    templet: function (d) {
                        return d.orderDetail ? d.orderDetail.productName:' ';

                    }
                },{
                    field: 'orderDetail', title: '??????',width: 90,
                    templet: function (d) {
                        return d.orderDetail ?'???'+d.orderDetail.productPrice:' ';
                    }
                },
                    {
                        field:'createTime',title: '????????????',
                    },{
                    field:'statusName',title: '????????????',width: 90,
                },{
                    fixed: 'right', width: 180, align:'center', toolbar: '#colTool',title: '??????'
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
                layer.confirm('????????????????????????', function(index){
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
            parseData: function(res) { //???????????????????????? table ???????????????????????????res??????url???get????????????
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //??????????????????
                    "msg": res.msg, //??????????????????
                    "count": res.count, //??????????????????
                    "data":result //??????????????????
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'orderDetail',minWidth:235,
                    templet: function (d) {
                        return '<img src="http://119.91.193.63:8080/HuanYiGamesStore/img/gamesImg/'+d.orderDetail.productImg+'" ' + '>';
                    }
                }, {
                    field: 'orderDetail', title: '????????????',
                    templet: function (d) {
                        return d.orderDetail ? d.orderDetail.productName:' ';
                    }
                },{
                    field: 'orderDetail', title: '??????',
                    templet: function (d) {
                        return d.orderDetail ?"???"+ d.orderDetail.productPrice:' ';
                    }
                },
                    {
                        field:'createTime',title: '????????????'
                    },{
                    field:'payTime',title: '????????????'
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
            parseData: function(res) { //???????????????????????? table ???????????????????????????res??????url???get????????????
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //??????????????????
                    "msg": res.msg, //??????????????????
                    "count": res.count, //??????????????????
                    "data":result //??????????????????
                };
            },
            skin:'nob',
            even:true,
            size:'lg',

            cols: [
                [{
                    field: 'gImg',title:'????????????',width:235,
                    templet: function (d) {
                        return '<img src="http://119.91.193.63:8080/HuanYiGamesStore/img/gamesImg/'+d.gImg+'" ' + '  >';
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
            parseData: function(res) { //???????????????????????? table ???????????????????????????res??????url???get????????????
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //??????????????????
                    "msg": res.msg, //??????????????????
                    "count": res.count, //??????????????????
                    "data":result //??????????????????
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'couponName',title:'???????????????'
                },{
                    field: 'userCoupon',title: '????????????',
                    templet: function (d) {
                        return d.userCoupon ? d.userCoupon.getTime : ' ';
                    }
                }
                    ,{
                    field: 'endTime',title: '????????????'
                },{
                    field: 'condition',title: '????????????'
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
            parseData: function(res) { //???????????????????????? table ???????????????????????????res??????url???get????????????
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //??????????????????
                    "msg": res.msg, //??????????????????
                    "count": res.count, //??????????????????
                    "data":result //??????????????????
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'couponName',title:'???????????????',
                },{
                    field: 'userCoupon',title: '????????????',
                    templet: function (d) {
                        return d.userCoupon ?d.userCoupon.useTime : ' ';
                    }
                }
                    ,{
                    field: 'condition',title: '????????????'
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
            parseData: function(res) { //???????????????????????? table ???????????????????????????res??????url???get????????????
                var result;
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //??????????????????
                    "msg": res.msg, //??????????????????
                    "count": res.count, //??????????????????
                    "data":result //??????????????????
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'couponName',title:'???????????????'
                },{
                    field: 'endTime',title: '????????????',
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
                    "code": res.code, //??????????????????
                    "msg": res.msg, //??????????????????
                    "count": res.count, //??????????????????
                    "data":result //??????????????????
                };
            },
            skin:'nob',
            even:true,
            size:'lg',
            cols: [
                [{
                    field: 'typeName',title:'??????'
                },{
                    field: 'time',title: '??????',
                },{
                    field: 'changePoints',title: '????????????',
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
    //????????????
    upload.render({
        elem: '#imgUpload' //????????????
        ,url: '/user/setting/getHeadImgFile' //????????????
        , field: "fileUp"
        , acceptMime:'image/*'
        ,before: function(obj){
            obj.preview(function(index, file, result){
                $('#person-img').attr('src', result);
            });

        }
        ,done: function(res){
            //??????????????????
            console.log(res)
        }
        ,error: function(){
            //??????????????????
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
                form.val("infoForm", { //formTest ??? class="layui-form" ?????????????????? lay-filter="" ????????????
                    "username": data.userName // "name": "value"
                });
                uPhone=data.phone;
                $('<img  src="http://119.91.193.63:8080/HuanYiGamesStore/img/userHeadImg/'+data.headImg+'" id="person-img" />').appendTo($('#person-img-div'));
                $('#phone-div').html('<p id="person-phone" style="font-size: 15px;display: inline-block;">'+data.phone+'</p><a href="javascript:updatePhone()" style="display: inline-block; margin-left: 20px;width: 80px"> ????????????</a>')
                $('#person-introduce').text(data.introduce)
            }
        })

    });

}

layui.use('form', function(){
    var form = layui.form;
    form.verify({
        username: function(value, item) {
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s??]+$").test(value)) {
                return '??????????????????????????????';
            }
        }
    });
    //????????????
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
                    layer.msg("???????????????" ,{time: 1500 ,icon:1});

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
            sendIdentifyingCode.html('('+a+")??????????????????");
            sendIdentifyingCode.css({"cursor":"not-allowed","pointer-events":"none"});
            a-=1;
        }else{
            clearInterval(timer);
            sendIdentifyingCode.html("???????????????");
            sendIdentifyingCode.css({"cursor":"pointer","pointer-events":"unset"});
        }
    }, 1000)
}
function sendCode() {
    var phone =$('#newPhone').val()
    if(!/^1[3456789]\d{9}$/.test(phone)) {
        layer.msg("?????????????????????", {time: 1500, icon: 2});
    }else{
        $.ajax({
            url: "/sendIdentifyingCode",
            dataType: 'text',
            data: {'phone':phone},
            success:function (data){
                resetCode();
                layer.msg("??????????????????", {time: 1500, icon: 1});
                IdentifyingCode=data;
                console.log(IdentifyingCode);
            }
        });
    }

}

function updatePhone(){

    index=	layer.open({

        title:'????????????',
        type:1
        ,content: '<div class="layui-row" style="padding:20px 10px;width: 300px">' +
            '' +
            '<div id="aPage" style="line-height: 30px;display: unset" >' +
            '<span class="layui-col-lg3">????????????</span>' +
            '<input class="layui-col-lg7" id="newPhone">' +
            '<input type="text" class="layui-col-lg3" id="getIdCode" style="margin-top: 20px;padding: 5px 0px">' +
            '<div class="layui-col-lg5" style="background-color: orange;text-align: center;cursor: pointer;margin-top: 20px;" id="sendIdentifyingCode" onclick="sendCode()">???????????????</div>' +
            '<span  class="layui-col-lg7" style="margin-top: 20px;">&nbsp;</span>' +
            '<button onclick="uppnum ()" class="layui-col-lg4" id="phoneRight" style="margin-top: 20px">??????</button>' +
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
                                layer.msg("????????????", {time: 1500, icon: 1});
                                setTimeout(function () {
                                    layer.close(index);
                                    loadUseInfo();
                                },2000)


                            }
                        }
                    })
                }else {
                    layer.msg("???????????????", {time: 1500, icon: 2});
                }
            }else {
                layer.msg("????????????????????????", {time: 1500, icon: 2});
            }
        }
    })
}

function updatePwd() {
    index=	layer.open({

        title:'????????????',
        type:1
        ,content: '<div class="layui-row" style="padding:20px 0px 20px 50px;width:300px ">' +
            '' +
            '<div id="bPage" style="line-height: 30px;" >' +
            '<span class="layui-col-lg3">????????????</span>' +
            '<input class="layui-col-lg6" id="newPwd" type="password">' +
            '<div class="layui-col-lg12"></div>' +
            '<span class="layui-col-lg3">???????????????</span>' +
            '<input class="layui-col-lg6" id="isRightPwd" type="password">' +
            '<div class="layui-col-lg12"></div>' +
            '<button  class="layui-col-lg4" id="nextStep1" style="margin-top: 20px" onclick="uppwd()">??????</button>' +
            '</div>' +
            '</div>'

    })


}

function uppwd(a,b) {

    if ($('#newPwd').val()!=$('#isRightPwd').val()){

        layer.msg("2?????????????????????" ,{time: 1500 ,icon:2})

    }else {

        $.ajax({

            url:'/user/setting/updatePwd',
            data:{'pwd':$('#isRightPwd').val()},
            dataType:'text',
            type:'post',
            success:function (data) {
                if(data=='ok'){

                    layer.msg("???????????????" ,{time: 1500 ,icon:1},function (){
                        location.href='/login'
                    })
                }
            }
        })

    }

}

