/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2021-11-10 02:58:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shopcar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>欢颐游戏商城</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../../img/shortcut.png\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"../../js/jquery-3.5.1.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"http://lib.h-ui.net/jquery.cookie/1.4.1/jquery.cookie.js\"></script>\r\n");
      out.write("    <script src=\"../../layui/layui/layui.js\"></script>\r\n");
      out.write("    <script src=\"../../js/header.js\"></script>\r\n");
      out.write("    <script src=\"https://unpkg.com/mathjs@7.1.0/dist/math.js\"  type=\"text/javascript\"></script>\r\n");
      out.write("    <link href=\"../../layui/layui/css/layui.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link   rel=\"stylesheet\" href=\"../../css/header.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../css/footer.css\">\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            max-width: 1920px;\r\n");
      out.write("            min-width: 1200px;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("        }\r\n");
      out.write("        div{\r\n");
      out.write("            white-space: nowrap;\r\n");
      out.write("        }\r\n");
      out.write("        .Game-child{\r\n");
      out.write("            display: block;width: 100%;height: 70px;margin-bottom: 15px;border-radius: 10px;background-color: rgba(238,238,238,1);\r\n");
      out.write("        }\r\n");
      out.write("        .Game-child:hover{\r\n");
      out.write("         color: black;\r\n");
      out.write("        }\r\n");
      out.write("        .list-img{\r\n");
      out.write("            height: 70px;width: 15%;display: inline-block;overflow:hidden;float: left;border-radius: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .list-GameName{\r\n");
      out.write("            font-size:19px;text-overflow: ellipsis;overflow:hidden;font-family: '微软雅黑';font-weight: bold;overflow: hidden;  text-overflow: ellipsis;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .list-gamePriceBox{\r\n");
      out.write("            display: inline-block;float: left;height: 70px;box-sizing: border-box;width: 19.5%;margin-left: 10px;text-indent: 20%;\r\n");
      out.write("            line-height: 70px;\r\n");
      out.write("        }\r\n");
      out.write("        .list-ToolBox{\r\n");
      out.write("            display: inline-block;float: right;height: 70px;box-sizing: border-box;width: 19.5%;margin-left: 10px;text-indent: 10%;\r\n");
      out.write("            line-height: 70px;\r\n");
      out.write("        }\r\n");
      out.write("        .list-price{\r\n");
      out.write("            color: orangered;font-size:20px;font-weight: bold;width: 100%;display: inline-block;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .list-gameInfoBox{\r\n");
      out.write("            display: inline-block; width:25% ;height: 70px;box-sizing: border-box;overflow: hidden;float: left;line-height:35px;text-indent: 20px;\r\n");
      out.write("            line-height: 70px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("\r\n");
      out.write("        var price1 =0.00;\r\n");
      out.write("        var checked=[];\r\n");
      out.write("        function accAdd(arg1, arg2) {\r\n");
      out.write("            var r1, r2, m, c, n;\r\n");
      out.write("            try {\r\n");
      out.write("                r1 = arg1.toString().split(\".\")[1].length;\r\n");
      out.write("            }\r\n");
      out.write("            catch (e) {\r\n");
      out.write("                r1 = 0;\r\n");
      out.write("            }\r\n");
      out.write("            try {\r\n");
      out.write("                r2 = arg2.toString().split(\".\")[1].length;\r\n");
      out.write("            }\r\n");
      out.write("            catch (e) {\r\n");
      out.write("                r2 = 0;\r\n");
      out.write("            }\r\n");
      out.write("            c = Math.abs(r1 - r2);\r\n");
      out.write("            m = Math.pow(10, Math.max(r1, r2));\r\n");
      out.write("            if (c > 0) {\r\n");
      out.write("                var cm = Math.pow(10, c);\r\n");
      out.write("                if (r1 > r2) {\r\n");
      out.write("                    arg1 = Number(arg1.toString().replace(\".\", \"\"));\r\n");
      out.write("                    arg2 = Number(arg2.toString().replace(\".\", \"\")) * cm;\r\n");
      out.write("                } else {\r\n");
      out.write("                    arg1 = Number(arg1.toString().replace(\".\", \"\")) * cm;\r\n");
      out.write("                    arg2 = Number(arg2.toString().replace(\".\", \"\"));\r\n");
      out.write("                }\r\n");
      out.write("            } else {\r\n");
      out.write("                arg1 = Number(arg1.toString().replace(\".\", \"\"));\r\n");
      out.write("                arg2 = Number(arg2.toString().replace(\".\", \"\"));\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            n = (r1 >= r2) ? r1 : r2;\r\n");
      out.write("            return ((arg1 + arg2) / m).toFixed(n);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function accSub(arg1, arg2) {\r\n");
      out.write("            var r1, r2, m, n;\r\n");
      out.write("            try {\r\n");
      out.write("                r1 = arg1.toString().split(\".\")[1].length;\r\n");
      out.write("            }\r\n");
      out.write("            catch (e) {\r\n");
      out.write("                r1 = 0;\r\n");
      out.write("            }\r\n");
      out.write("            try {\r\n");
      out.write("                r2 = arg2.toString().split(\".\")[1].length;\r\n");
      out.write("            }\r\n");
      out.write("            catch (e) {\r\n");
      out.write("                r2 = 0;\r\n");
      out.write("            }\r\n");
      out.write("            m = Math.pow(10, Math.max(r1, r2)); //last modify by deeka //动态控制精度长度\r\n");
      out.write("            n = (r1 >= r2) ? r1 : r2;\r\n");
      out.write("            return ((arg1 * m - arg2 * m) / m).toFixed(n);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function price() {\r\n");
      out.write("            let index ;\r\n");
      out.write("\r\n");
      out.write("            $('.cb').change(function () {\r\n");
      out.write("                // if (price<0){\r\n");
      out.write("                //     $('#allprice').text('0.00')\r\n");
      out.write("                // }\r\n");
      out.write("                index = $('.cb').index(this);\r\n");
      out.write("                if ($('.cb:eq('+index+')').prop('checked')==true){\r\n");
      out.write("                    price1 = accAdd(price1,parseFloat($('.list-price:eq('+index+')').text().substr(1)));\r\n");
      out.write("                    $('#allprice').text(price1)\r\n");
      out.write("                    checked.push($('.gid:eq('+index+')').val())\r\n");
      out.write("                }else\r\n");
      out.write("                {\r\n");
      out.write("                    price1=  accSub(price1,parseFloat(($('.list-price:eq('+index+')').text().substr(1))))\r\n");
      out.write("                    $('#allprice').text(price1)\r\n");
      out.write("                    checked.forEach(function(item, index2, arr) {\r\n");
      out.write("\r\n");
      out.write("                        if(item == $('.gid:eq('+index+')').val()) {\r\n");
      out.write("\r\n");
      out.write("                            arr.splice(index2, 1);\r\n");
      out.write("\r\n");
      out.write("                         }\r\n");
      out.write("\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            })\r\n");
      out.write("            $('#pay').click(function () {\r\n");
      out.write("\r\n");
      out.write("                if (price1==0){\r\n");
      out.write("                    layer.msg(\"请选择要付款的商品\", {time: 2000, icon: 2,offset: '300px'});\r\n");
      out.write("                }else {\r\n");
      out.write("\r\n");
      out.write("                    console.log(checked.toString())\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url:'/buy/getOrderInfo'\r\n");
      out.write("                        ,data: {'checked':checked,'price':price1}\r\n");
      out.write("                        ,dataType: 'text'\r\n");
      out.write("                        ,success:function (data) {\r\n");
      out.write("                            if (data=='ok'){\r\n");
      out.write("\r\n");
      out.write("                                location.href='/buy'\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function allPick(){\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            $('#allPick').change(function () {\r\n");
      out.write("                if ($('#allPick').prop('checked')==true)\r\n");
      out.write("                {\r\n");
      out.write("                    $('.cb').prop('checked',true);\r\n");
      out.write("\r\n");
      out.write("                    price1=0\r\n");
      out.write("\r\n");
      out.write("                    for (let i = 0; i < $('.list-price').length ; i++) {\r\n");
      out.write("                        checked.push($('.gid:eq('+i+')').val())\r\n");
      out.write("                        price1 = accAdd(price1,parseFloat($('.list-price:eq('+i+')').text().substr(1)));\r\n");
      out.write("                        $('#allprice').text(price1)\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                }else {\r\n");
      out.write("                    $('.cb').prop('checked',false);\r\n");
      out.write("                    // for (let i = 0; i < $('.list-price').length ; i++) {\r\n");
      out.write("                    //     price1 =  accSub(price1,parseFloat(($('.list-price:eq('+i+')').text().substr(1))))\r\n");
      out.write("                    //     $('#allprice').text(price1)\r\n");
      out.write("                    // }\r\n");
      out.write("                    price1='0.00'\r\n");
      out.write("                    $('#allprice').text(price1)\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function deleteInShopcar(){\r\n");
      out.write("            let index ;\r\n");
      out.write("            $('.delete').click(function () {\r\n");
      out.write("                index=$('.delete').index(this);\r\n");
      out.write("\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url:'/shopCar/deleteGameInShopCar'\r\n");
      out.write("                    ,data:{'gid':$('.gid:eq('+index+')').val()}\r\n");
      out.write("                    ,dataType:'text'\r\n");
      out.write("                    ,success:function (data) {\r\n");
      out.write("                        if(data==\"ok\"){\r\n");
      out.write("                            layer.msg(\"删除成功\", {time: 2000, icon: 1,offset: '300px'});\r\n");
      out.write("                            $('.Game-child:eq('+index+')').remove()\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("        $(function () {\r\n");
      out.write("\r\n");
      out.write("             price1 =0.00;\r\n");
      out.write("            $('#allPick').prop('checked',false);\r\n");
      out.write("            $('.cb').prop('checked',false);\r\n");
      out.write("\r\n");
      out.write("            price();\r\n");
      out.write("            \r\n");
      out.write("        deleteInShopcar();\r\n");
      out.write("\r\n");
      out.write("        allPick();\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("    <div class=\" layui-row \">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"layui-col-lg2 logo \">\r\n");
      out.write("\r\n");
      out.write("            <img src=\"img/logo.png\" style=\"width: 190px;height: 67px;\" />\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\" layui-col-lg4   nav_list \">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"/index\" style=\"color: white\">首页</a></li>\r\n");
      out.write("\r\n");
      out.write("                <li><a href=\"/games\" style=\"color: white\">商城</a></li>\r\n");
      out.write("                <li><a href=\"/pointsShop\" style=\"color: white\">积分商城</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"layui-col-lg4 search\"id=\"\">\r\n");
      out.write("\r\n");
      out.write("            <div style=\"  display: inline-block; padding: 14px 0px; \">\r\n");
      out.write("                <div class=\"search-border\">\r\n");
      out.write("                    <div style=\" display: inline-block;\"><input type=\"text\" id=\"searchText\" placeholder=\"请输入关键词\" class=\"search-input\" />\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"search-icon\">&nbsp;</div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"layui-fluid\" style=\"\">\r\n");
      out.write("\r\n");
      out.write("    <div id=\"shopCar\" style=\"width: 60%;margin: 0 auto;margin-top: 30px;\">\r\n");
      out.write("\r\n");
      out.write("        <div style=\"font-size: 22px;\">购物车</div>\r\n");
      if (_jspx_meth_c_005fchoose_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/jsp/shopcar.jsp(275,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user == null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <div class=\"layui-col-lg2 \" id=\"header-right\" style=\"height: 67px;  overflow: hidden;display: inline-block;\">\r\n");
        out.write("\r\n");
        out.write("                    <div style=\"padding: 14px 0px;\">\r\n");
        out.write("                        <a href=\"/login\" style=\"text-align: center;\">\r\n");
        out.write("                            <span style=\"color: white;line-height: 35px;font-size: 12px;\">登录</span>\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </div>\r\n");
        out.write("                </div>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/jsp/shopcar.jsp(285,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ sessionScope.user.userName != null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <div class=\"layui-col-lg2 \" id=\"header-right\" style=\"height: 67px;  overflow: hidden;display: inline-block;\">\r\n");
        out.write("\r\n");
        out.write("                    <div style=\"padding: 14px 0px;\">\r\n");
        out.write("                        <a href=\"/shopCar\">\r\n");
        out.write("                            <span class=\"shopcar\">&nbsp;</span>\r\n");
        out.write("                        </a>\r\n");
        out.write("                        <a href=\"/user/order\" id=\"flushImg\">\r\n");
        out.write("                            <img   src=\"../img/userHeadImg/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.headImg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" class=\"person-icon\"></img>\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </div>\r\n");
        out.write("                </div>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f1.setParent(null);
    int _jspx_eval_c_005fchoose_005f1 = _jspx_th_c_005fchoose_005f1.doStartTag();
    if (_jspx_eval_c_005fchoose_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fwhen_005f2(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("      ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
    // /WEB-INF/jsp/shopcar.jsp(309,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${shopCarList.size() eq 0}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f2 = _jspx_th_c_005fwhen_005f2.doStartTag();
    if (_jspx_eval_c_005fwhen_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\r\n");
        out.write("        <div style=\"height: 300px;text-align: center;line-height: 300px\">这里空空如也,请前往<a style=\"color: orangered\" href=\"/games\">游戏商城</a>购买</div>\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        <div id=\"title\" style=\"font-size: 20px;margin-top: 20px;box-sizing: border-box\" class=\"layui-row\">\r\n");
        out.write("            <div class=\"layui-col-lg2\" style=\"text-align: center;display: inline-block;overflow:hidden;\">游戏</div>\r\n");
        out.write("            <div class=\"layui-col-lg8\" style=\"text-align: center;display: inline-block;overflow:hidden;\">商品价格</div>\r\n");
        out.write("            <div class=\"layui-col-lg2\" style=\"display: inline-block;overflow:hidden;\">操作</div>\r\n");
        out.write("        </div>\r\n");
        out.write("\r\n");
        out.write("        <div id=\"shopcar-main\" style=\"margin-top: 30px;\">\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("          ");
        if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fotherwise_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\r\n");
        out.write("            <div><input type=\"checkbox\" id=\"allPick\">全选</div>\r\n");
        out.write("        </div>\r\n");
        out.write("\r\n");
        out.write("        <div style=\"clear: both;height: 100px;box-sizing: border-box;\">\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("            <div style=\"text-align: right;font-size: 20px;overflow: hidden;\">总金额:￥<span style=\"color: orangered;font-size: 28px;\" id=\"allprice\">0.00</span></div>\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("            <div style=\"text-align: right;overflow: hidden;\">\r\n");
        out.write("                <div style=\"height: 40px;line-height: 40px;text-align: center;width: 200px;float: right;border-radius: 8px;background:linear-gradient(rgb(250,86,0) ,rgb(255,158,0) );\" id=\"pay\">支付订单</div>\r\n");
        out.write("            </div>\r\n");
        out.write("        </div>\r\n");
        out.write("          ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f0);
    // /WEB-INF/jsp/shopcar.jsp(326,10) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/shopcar.jsp(326,10) '${shopCarList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${shopCarList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/shopcar.jsp(326,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("i");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("              <a  class=\"Game-child \" style=\"width: 100%;\">\r\n");
          out.write("                    <input class=\"gid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.games.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" type=\"hidden\">\r\n");
          out.write("                  <div  style=\"float: left;padding-top: 30px;height: 40px;margin-right: 10px;display: inline-block;\">\r\n");
          out.write("\r\n");
          out.write("                      <input type=\"checkbox\" lay-skin=\"primary\" class=\"cb\" >\r\n");
          out.write("\r\n");
          out.write("                  </div>\r\n");
          out.write("                  <img class=\"list-img\" src=\"../../img/gamesImg/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.games.gamesImg.imgUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("                  <div class=\"list-gameInfoBox\">\r\n");
          out.write("                      <p class=\"list-GameName\" >");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.games.gameName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</p>\r\n");
          out.write("                  </div>\r\n");
          out.write("\r\n");
          out.write("                  <div class=\"list-gamePriceBox\">\r\n");
          out.write("                          ");
          out.write("\r\n");
          out.write("                      <p class=\"list-price\"  >￥");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.games.discountPrice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</p>\r\n");
          out.write("                  </div>\r\n");
          out.write("\r\n");
          out.write("                  <div class=\"list-ToolBox\">\r\n");
          out.write("                      <p style=\"font-size: 16px\" class=\"delete\">删除</p>\r\n");
          out.write("                  </div>\r\n");
          out.write("              </a>\r\n");
          out.write("          ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}