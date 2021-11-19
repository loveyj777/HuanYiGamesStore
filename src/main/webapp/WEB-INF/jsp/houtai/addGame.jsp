<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/11/4
  Time: 23:29
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
    <link rel="stylesheet" href="../../../css/public.css" media="all">
    <link href="../../../layui/layui/css/layui.css" rel="stylesheet" />
    <link rel="stylesheet" href="../../css/font.css">



    <style>
        .layui-form-select dl{

            top: auto;

            bottom: -10px;

        }
        /*.layui-upload-img{*/
        /*    width: 200px;*/
        /*    height: 100px;*/
        /*    overflow: hidden;*/
        /*}*/
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">



        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>添加游戏</legend>
        </fieldset>

        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">游戏名称</label>
                <div class="layui-input-block">
                    <input type="text" name="gameName" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">英文名称</label>
                <div class="layui-input-block">
                    <input type="text" name="engGameName" lay-verify="required"  placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">单价</label>
                    <div class="layui-input-inline">
                        <input type="text" name="price" lay-verify="required|number" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">发行日期</label>
                    <div class="layui-input-inline">
                        <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>


            <div class="layui-form-item" style="margin-top: 30px">
                <label class="layui-form-label" >游戏类型</label>
                <div class="layui-input-block">
                    <select name="type" lay-filter="type" lay-verify="required">
                        <option value=""></option>
                        <option value="1">动作</option>
                        <option value="2" >冒险</option>
                        <option value="3">角色扮演</option>
                        <option value="4">射击</option>
                        <option value="5">大型多人在线</option>
                        <option value="6">策略</option>
                        <option value="7">模拟</option>
                        <option value="8">体育</option>
                        <option value="9">休闲</option>
                        <option value="10">独立</option>
                        <option value="11">竞速</option>
                    </select>
                </div>
            </div>

                <div class="layui-upload" >
                    <button type="button" class="layui-btn" id="test1">上传主图</button>
                    <div class="layui-upload-list"  >

                        <img class="layui-upload-img" id="demo1">
                    </div>
                </div>

<%--                <div class="layui-upload">--%>
<%--                    <button type="button" class="layui-btn" id="test2">上传详情图</button>--%>
<%--                    <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">--%>
<%--                        预览图：--%>
<%--                        <div class="layui-upload-list" id="demo2"></div>--%>
<%--                    </blockquote>--%>
<%--                </div>--%>


                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>游戏介绍</legend>
            </fieldset>
                <div id="editor" style="margin: 50px 0 50px 0">

                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="submit" id="submit">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </div>

        </form>
    </div>
</div>
<script src="../../js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script type="text/javascript">

    layui.use(['layer','wangEditor'], function () {

        var $ = layui.jquery,
            layer = layui.layer,
            wangEditor = layui.wangEditor;

        var editor = new wangEditor('#editor');
        editor.customConfig.uploadImgServer = "";
        editor.customConfig.uploadFileName = 'image';
        editor.customConfig.pasteFilterStyle = false;
        editor.customConfig.uploadImgMaxLength = 5;
        editor.customConfig.uploadImgHooks = {
            // 上传超时
            timeout: function (xhr, editor) {
                layer.msg('上传超时！')
            },
        };
        editor.customConfig.customAlert = function (info) {
            layer.msg(info);
        };
        editor.create();





        layui.use('upload', function(){
            var upload = layui.upload;

            //执行实例
            upload.render({
                elem: '#test1'
                ,url: '/admin/addGame/mstImgFile'
                ,field: "masterImg"


                , acceptMime:'image/*'
                ,before: function(obj){
                    obj.preview(function(index, file, result){
                        $('#demo1').attr('src', result);

                    });
                }
            });




        });

        function inserIMG(id) {
            layui.use('upload', function(){
                var upload = layui.upload;

            upload.render({
                elem: '#test2'
                ,url: '/admin/addGame/dilImgFile?id='+id
                ,multiple: true
                ,field: "detailImg"
                ,number:4
                , acceptMime:'image/*'
                ,before: function(obj){

                    obj.preview(function(index, file, result){
                        $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
                    })
                    }
                ,allDone: function(obj) { //当文件全部被提交后，才触发
                    layer.msg("添加成功", {time: 2000, icon: 1}, function () {
                        location.href = '/admin/addGame'
                    });


                }

            });
            });
            layer.open({
                title:'添加详情图片',
                type:1
                ,content: '  <div class="layui-upload" style="width: 1000px;height: 600px">' +
                    '' +
                    '<button type="button" class="layui-btn" id="test2">上传详情图</button>' +
                    '<blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">' +
                    ' 预览图：' +
                    '   <div class="layui-upload-list" id="demo2"></div>' +
                    ' </blockquote>' +
                    '</div>'
                ,offset: '50px'

            })
        }
        layui.use(['form', 'laydate'], function () {
            var form = layui.form
                , layer = layui.layer
                , laydate = layui.laydate;

            //日期
            laydate.render({
                elem: '#date'
            });
            laydate.render({
                elem: '#date1'
            });


            //监听提交
            form.on('submit(submit)', function (data) {


                $.ajax({
                    url:'/admin/addGame/insertGame'
                    ,data:{'gameName':data.field.gameName,'engGameName':data.field.engGameName,'price':data.field.price,'publishTime':data.field.date,'type':data
                    .field.type,'gameInfo':editor.txt.html()}
                    ,success:function (data) {
                        inserIMG(data);

                    }
                })
                return false;
            });



        });

    });
</script>


</body>
</html>