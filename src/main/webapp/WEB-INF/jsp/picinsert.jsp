<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/29
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢颐游戏商城</title>
    <script src="../../js/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="../../layui/layui/layui.js"></script>
    <link href="../../layui/layui/css/layui.css" rel="stylesheet" />
</head>
<body>



<input type="text" id="id">
<button type="button" id="go">go</button>

</body>
<script>

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

                    });


                }

            });
        });
        layer.open({
            title:'添加详情图片',
            type:1
            ,content: ' ' +
                '<div class="layui-upload" style="width: 1000px;height: 600px">' +
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

$('#go').click(function () {
    inserIMG($('#id').val());
})
    
   // $ .ajax({
   //      url:'/toolImg'
   //      ,data:{'id':$('#id').val(),'isMaster':'1'}
   //      ,success : function (data) {
   //         
   //      }
   //  })

    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        upload.render({
            elem: '#test1'
            ,url: '/toolImg' //此处配置你自己的上传接口即可

            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
                });
            }
            ,done: function(res){
                //上传完毕
            }

        });
    });

</script>
</html>
