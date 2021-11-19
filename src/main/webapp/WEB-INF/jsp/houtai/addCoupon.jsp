<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/11/5
  Time: 4:44
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

</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">



        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>添加优惠卷</legend>
        </fieldset>

        <form class="layui-form" action="" lay-filter="couponF" >
            <div class="layui-form-item">
                <label class="layui-form-label">优惠卷名称</label>
                <div class="layui-input-block">
                    <input type="text" name="couponName"  lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">使用条件</label>
                <div class="layui-input-block">
                    <input type="text" name="condition" lay-verify="required"  placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">优惠卷阈值</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="threshold" lay-verify="required|number" autocomplete="off" class="layui-input">
                    </div>
                </div>


                    <div class="layui-inline">
                        <label class="layui-form-label">优惠卷面值</label>
                        <div class="layui-input-inline" style="width: 100px;">
                            <input type="text" name="couponPrice" placeholder="￥" lay-verify="number|required"  autocomplete="off" class="layui-input">
                        </div>
                    </div>


                <div class="layui-inline">
                    <label class="layui-form-label">需要积分</label>
                    <div class="layui-input-inline">
                        <input type="text" name="needPoints" lay-verify="number|required" autocomplete="off" class="layui-input" placeholder=">0则为积分兑换">
                    </div>
                </div>
            </div>


                <div class="layui-inline" >
                    <label class="layui-form-label">结束日期</label>
                    <div class="layui-input-inline">
                        <input type="text" name="endTime" id="endTime" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>




            <div class="layui-form-item" style="margin-top: 30px">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>


        </form>
    </div>
</div>


<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#endTime'
        });



        //监听提交
        form.on('submit(demo1)', function (data) {

            console.log(form.val('couponF'))
            $.ajax({
                url:'/admin/coupon/addCoupon'
                ,data:form.val('couponF')
                ,success:function (data) {
                    if (data=='ok'){
                        layer.msg("添加成功", {time: 2000, icon: 1}, function () {
                            location.href='/admin/coupon'
                        });

                    }
                }
            })
            return false;
        });




    });
</script>

</body>
</html>