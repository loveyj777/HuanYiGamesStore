/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2021-11-24 07:37:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.houtai;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class controGame_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>layui</title>\n");
      out.write("    <link rel=\"shortcut icon\"  type=\"images/x-icon\" href=\"http://119.91.193.63:8080/HuanYiGamesStore/shortcut.png\" />\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("    <script src=\"http://119.91.193.63:8080/HuanYiGamesStore/js/jquery-3.5.1.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"https://www.layuicdn.com/layui/layui.js\"></script>\n");
      out.write("    <link href=\"https://www.layuicdn.com/layui/css/layui.css\" rel=\"stylesheet\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://119.91.193.63:8080/HuanYiGamesStore/css/font.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"layuimini-container\">\n");
      out.write("    <div class=\"layuimini-main\">\n");
      out.write("\n");
      out.write("        <fieldset class=\"table-search-fieldset\">\n");
      out.write("            <legend>搜索信息</legend>\n");
      out.write("            <div style=\"margin: 10px 10px 10px 10px\">\n");
      out.write("                <form class=\"layui-form layui-form-pane\" action=\"\">\n");
      out.write("                    <div class=\"layui-form-item\">\n");
      out.write("                        <div class=\"layui-inline\">\n");
      out.write("                            <label class=\"layui-form-label\">游戏名称</label>\n");
      out.write("                            <div class=\"layui-input-inline\">\n");
      out.write("                                <input type=\"text\" name=\"gameName\" autocomplete=\"off\" class=\"layui-input\" id=\"gameName\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"layui-inline\">\n");
      out.write("                            <button type=\"button\" class=\"layui-btn layui-btn-primary\" id=\"search\" lay-submit lay-filter=\"data-search-btn\"><i class=\"layui-icon\"></i> 搜 索</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </fieldset>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table class=\"layui-hide\"  id=\"currentTableId\" lay-filter=\"currentTableFilter\"></table>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/html\" id=\"currentTableBar\">\n");
      out.write("    {{#  if(d.status ==1){ }}\n");
      out.write("\n");
      out.write("\n");
      out.write("                <a class=\"layui-btn layui-btn-xs layui-btn-danger data-count-up\" lay-event=\"delete\">下架</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("    {{#  } }}\n");
      out.write("    {{#  if(d.status !=\"1\"){ }}\n");
      out.write("\n");
      out.write("\n");
      out.write("    <a class=\"layui-btn layui-btn-xs layui-btn-danger data-count-delete\" lay-event=\"up\">上架</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("    {{#  } }}\n");
      out.write("</script>\n");
      out.write("<script>\n");
      out.write("    layui.use(['form', 'table'], function () {\n");
      out.write("        var $ = layui.jquery,\n");
      out.write("            form = layui.form,\n");
      out.write("            table = layui.table;\n");
      out.write("\n");
      out.write("     var tableIns =   table.render({\n");
      out.write("            elem: '#currentTableId',\n");
      out.write("            url: '/admin/controlGame/getAllGames',\n");
      out.write("            toolbar: '#toolbarDemo',\n");
      out.write("            defaultToolbar: ['filter', 'exports', 'print', {\n");
      out.write("                title: '提示',\n");
      out.write("                layEvent: 'LAYTABLE_TIPS',\n");
      out.write("                icon: 'layui-icon-tips'\n");
      out.write("            }],\n");
      out.write("            parseData: function(res) {\n");
      out.write("                console.log(res)\n");
      out.write("                var result;\n");
      out.write("                if (this.page.curr) {\n");
      out.write("                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);\n");
      out.write("                } else {\n");
      out.write("                    result = res.data.slice(0, this.limit);\n");
      out.write("                }\n");
      out.write("                return {\n");
      out.write("                    \"code\": res.code,\n");
      out.write("                    \"msg\": res.msg,\n");
      out.write("                    \"count\": res.count,\n");
      out.write("                    \"data\":result\n");
      out.write("                };\n");
      out.write("            },\n");
      out.write("            cols: [[\n");
      out.write("                {type: \"checkbox\", },\n");
      out.write("                {\n");
      out.write("                    field: 'gamesImg',\n");
      out.write("                    templet: function (d) {\n");
      out.write("                        return '<img src=\"http://119.91.193.63:8080/HuanYiGamesStore/img/gamesImg/'+d.gamesImg.imgUrl+'\" ' + '>';\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                {field: 'gameName',  title: '游戏名称'},\n");
      out.write("                {field: 'engGameName', title: '英文名称'},\n");
      out.write("                {field: 'publishTime', title: '发行时间'},\n");
      out.write("                {field: 'price',  title: '单价' , sort: true ,\n");
      out.write("                    templet: function (d) {\n");
      out.write("                        return d.price?'￥'+d.price:''\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                {field: 'discount', title: '折扣', sort: true,edit:'currentTableFilter',\n");
      out.write("                    \"templet\": function (d) {\n");
      out.write("                        return d.gamesDiscount?d.gamesDiscount.discount:''\n");
      out.write("                    }},\n");
      out.write("                {field: 'discountPrice', title: '折后价',\n");
      out.write("                    templet: function (d) {\n");
      out.write("                        return d.discountPrice?'￥'+d.discountPrice:''\n");
      out.write("                    }},\n");
      out.write("                {field: 'gamesType', title: '类型',\n");
      out.write("                    templet: function (d) {\n");
      out.write("                        return d.gamesType?d.gamesType.typeName:''\n");
      out.write("                    }},\n");
      out.write("                {field: 'statusName', title: '状态',},\n");
      out.write("                {title: '操作',toolbar: '#currentTableBar', align: \"center\"}\n");
      out.write("            ]],\n");
      out.write("            limits: [10, 15, 20, 25, 50, 100],\n");
      out.write("            limit: 15,\n");
      out.write("            page: true,\n");
      out.write("            skin: 'line'\n");
      out.write("\n");
      out.write("         ,id:'tid'\n");
      out.write("\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        // 执行搜索，表格重载\n");
      out.write("        $('#search').on('click', function () {\n");
      out.write("            // 搜索条件\n");
      out.write("            var gameName = $('#gameName').val();\n");
      out.write("\n");
      out.write("            table.reload('tid', {\n");
      out.write("                method: 'get'\n");
      out.write("                , where: {\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    'gameName': gameName\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                , page: {\n");
      out.write("                    curr: 1\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        //监听表格复选框选择\n");
      out.write("        table.on('checkbox(currentTableFilter)', function (obj) {\n");
      out.write("            console.log(obj)\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        table.on('edit(currentTableFilter)', function(obj){\n");
      out.write("\n");
      out.write("            console.log(obj.value); //得到修改后的值\n");
      out.write("            $.ajax({\n");
      out.write("                url:'/admin/controlGame/changeGameDiscount'\n");
      out.write("                ,data:{'id':obj.data.id,'discount':obj.value}\n");
      out.write("                ,success:function (data) {\n");
      out.write("                    if (data=='ok'){\n");
      out.write("                        layer.msg('修改成功', {icon: 1,time:2000});\n");
      out.write("                        tableIns.reload()\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            })\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        table.on('tool(currentTableFilter)', function (obj) {\n");
      out.write("            var data = obj.data;\n");
      out.write("            if (obj.event === 'edit') {\n");
      out.write("\n");
      out.write("                var index = layer.open({\n");
      out.write("                    title: '编辑用户',\n");
      out.write("                    type: 2,\n");
      out.write("                    shade: 0.2,\n");
      out.write("                    maxmin:true,\n");
      out.write("                    shadeClose: true,\n");
      out.write("                    area: ['100%', '100%'],\n");
      out.write("                    content: '/page/table/edit.html',\n");
      out.write("                });\n");
      out.write("                $(window).on(\"resize\", function () {\n");
      out.write("                    layer.full(index);\n");
      out.write("                });\n");
      out.write("                return false;\n");
      out.write("            } else if (obj.event === 'delete') {\n");
      out.write("\n");
      out.write("                console.log(obj.title)\n");
      out.write("                $.ajax({\n");
      out.write("\n");
      out.write("                    url: '/admin/controlGame/changeGameStatus'\n");
      out.write("                    ,data:{'id':obj.data.id,'status':'0'}\n");
      out.write("                    ,success:function (data) {\n");
      out.write("                        if (data=='ok'){\n");
      out.write("                            layer.msg('下架成功', {icon: 1,time:2000});\n");
      out.write("                            tableIns.reload()\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                })\n");
      out.write("            }else if (obj.event === 'up') {\n");
      out.write("\n");
      out.write("\n");
      out.write("                $.ajax({\n");
      out.write("\n");
      out.write("                    url: '/admin/controlGame/changeGameStatus'\n");
      out.write("                    ,data:{'id':obj.data.id,'status':'1'}\n");
      out.write("                    ,success:function (data) {\n");
      out.write("                        if (data=='ok'){\n");
      out.write("                            layer.msg('上架成功', {icon: 1,time:2000})\n");
      out.write("\n");
      out.write("                            tableIns.reload()\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                })\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
