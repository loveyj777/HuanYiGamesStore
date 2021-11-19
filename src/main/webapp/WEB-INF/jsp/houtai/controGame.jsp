<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/11/4
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="../../js/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="../../../layui/layui/layui.js"></script>
    <link href="../../../layui/layui/css/layui.css" rel="stylesheet" />
    <link rel="stylesheet" href="../../css/font.css">

</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">游戏名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="gameName" autocomplete="off" class="layui-input" id="gameName">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <button type="button" class="layui-btn layui-btn-primary" id="search" lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>


        <table class="layui-hide"  id="currentTableId" lay-filter="currentTableFilter"></table>

<%--        <script type="text/html" id="currentTableBar">--%>
<%--            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>--%>
<%--            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">下架</a>--%>
<%--        </script>--%>

<%--        <script type="text/html" id="currentTableBar2">--%>
<%--            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>--%>
<%--            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">上架</a>--%>
<%--        </script>--%>

    </div>
</div>
<script type="text/html" id="currentTableBar">
    {{#  if(d.status ==1){ }}


                <a class="layui-btn layui-btn-xs layui-btn-danger data-count-up" lay-event="delete">下架</a>


    {{#  } }}
    {{#  if(d.status !="1"){ }}


    <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="up">上架</a>


    {{#  } }}
</script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

     var tableIns =   table.render({
            elem: '#currentTableId',
            url: '/admin/controlGame/getAllGames',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            parseData: function(res) {
                console.log(res)
                var result;
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
            cols: [[
                {type: "checkbox", },
                {
                    field: 'gamesImg',
                    templet: function (d) {
                        return '<img src="../img/gamesImg/'+d.gamesImg.imgUrl+'" ' + '>';
                    }
                },
                {field: 'gameName',  title: '游戏名称'},
                {field: 'engGameName', title: '英文名称'},
                {field: 'publishTime', title: '发行时间'},
                {field: 'price',  title: '单价' , sort: true ,
                    templet: function (d) {
                        return d.price?'￥'+d.price:''
                    }
                },
                {field: 'discount', title: '折扣', sort: true,edit:'currentTableFilter',
                    "templet": function (d) {
                        return d.gamesDiscount?d.gamesDiscount.discount:''
                    }},
                {field: 'discountPrice', title: '折后价',
                    templet: function (d) {
                        return d.discountPrice?'￥'+d.discountPrice:''
                    }},
                {field: 'gamesType', title: '类型',
                    templet: function (d) {
                        return d.gamesType?d.gamesType.typeName:''
                    }},
                {field: 'statusName', title: '状态',},
                {title: '操作',toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'

         ,id:'tid'

        });

        // table.on('tool(currentTableBar)', function (obj) {
        //     window.tableData = obj.data;
        //     var data = obj.data;
        //     var handleEvent = obj.event;
        //
        //     switch (handleEvent) {
        //
        //         case 'edit':
        //             del(obj.data.id);
        //             break;
        //         case 'delete':
        //             if (obj.data.status == 1) {
        //                 editOlderInfo(obj.data.id);
        //             } else {
        //
        //
        //             }
        //
        //
        //
        //             break;
        //     }
        // })




        // 执行搜索，表格重载
        $('#search').on('click', function () {
            // 搜索条件
            var gameName = $('#gameName').val();

            table.reload('tid', {
                method: 'get'
                , where: {



                    'gameName': gameName

                }
                , page: {
                    curr: 1
                }
            });
        });



        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('edit(currentTableFilter)', function(obj){

            console.log(obj.value); //得到修改后的值
            $.ajax({
                url:'/admin/controlGame/changeGameDiscount'
                ,data:{'id':obj.data.id,'discount':obj.value}
                ,success:function (data) {
                    if (data=='ok'){
                        layer.msg('修改成功', {icon: 1,time:2000});
                        tableIns.reload()
                    }
                }
            })
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {

                var index = layer.open({
                    title: '编辑用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '../page/table/edit.html',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {

                console.log(obj.title)
                $.ajax({

                    url: '/admin/controlGame/changeGameStatus'
                    ,data:{'id':obj.data.id,'status':'0'}
                    ,success:function (data) {
                        if (data=='ok'){
                            layer.msg('下架成功', {icon: 1,time:2000});
                            tableIns.reload()

                        }
                    }

                })
            }else if (obj.event === 'up') {


                $.ajax({

                    url: '/admin/controlGame/changeGameStatus'
                    ,data:{'id':obj.data.id,'status':'1'}
                    ,success:function (data) {
                        if (data=='ok'){
                            layer.msg('上架成功', {icon: 1,time:2000})

                            tableIns.reload()
                        }
                    }

                })
            }
        });

    });
</script>



</body>
</html>