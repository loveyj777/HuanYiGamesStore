/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2021-11-24 03:13:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userSetting_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"utf-8\">\n");
      out.write("\t\t<title>欢颐游戏</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<link rel=\"shortcut icon\" href=\"http://119.91.193.63:8080/HuanYiGamesStore/img/shortcut.png\" />\n");
      out.write("\t\t<script src=\"http://119.91.193.63:8080/HuanYiGamesStore/js/jquery-3.5.1.js\" type=\"text/javascript\"></script>\n");
      out.write("\t\t<script src=\"http://lib.h-ui.net/jquery.cookie/1.4.1/jquery.cookie.js\"></script>\n");
      out.write("\t\t<script src=\"https://www.layuicdn.com/layui/layui.js\"></script>\n");
      out.write("\t\t<script src=\"http://119.91.193.63:8080/HuanYiGamesStore/js/header.js\"></script>\n");
      out.write("\t\t<script src=\"http://119.91.193.63:8080/HuanYiGamesStore/js/userInfo.js\"></script>\n");
      out.write("\t\t<link href=\"https://www.layuicdn.com/layui/css/layui.css\" rel=\"stylesheet\" />\n");
      out.write("\t\t<link   rel=\"stylesheet\" href=\"http://119.91.193.63:8080/HuanYiGamesStore/css/header.css\"/>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"http://119.91.193.63:8080/HuanYiGamesStore/css/footer.css\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"http://119.91.193.63:8080/HuanYiGamesStore/css/font.css\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"http://119.91.193.63:8080/HuanYiGamesStore/css/userInfo.css\">\n");
      out.write("\n");
      out.write("\t\t<script>\n");
      out.write("\t\t\tvar nameInput;\n");
      out.write("\t\t\tvar nameSpan;\n");
      out.write("\t\t\t$(function(){\n");
      out.write("\n");
      out.write("\t\t\t\tconsole.log(\"ok\")\n");
      out.write("\n");
      out.write("\t\t\t\tmyInfoA=$('#myInfoA');\n");
      out.write("\n");
      out.write("\t\t\t\tmyInfo_items=$('.person-items:eq(0)');\n");
      out.write("\n");
      out.write("\t\t\t\t nameInput=$('#nameInput');\n");
      out.write("\t\t\t\t nameSpan=$('#checkName');\n");
      out.write("\t\t\t\tmyInfoA.css(\"background-color\",\"#FF6D3F\")\n");
      out.write("\t\t\t\tmyInfo();\n");
      out.write("\t\t\t\tnameBlur();\n");
      out.write("\t\t\t\tflushImg()\n");
      out.write("\n");
      out.write("\t\t\t\tsearch();\n");
      out.write("\t\t\t});\n");
      out.write("\tfunction nameBlur() {\n");
      out.write("\t\tnameInput.blur(function (){\n");
      out.write("\t\t\tif (nameInput.val().length<2){\n");
      out.write("\t\t\t\tnameSpan.text(\"昵称不符合规定\")\n");
      out.write("\t\t\t\tnameSpan.css('color','red')\n");
      out.write("\t\t\t\t$('#submit').attr(\"disabled\",true)\n");
      out.write("\t\t\t\t$('#submit').css('cursor','not-allowed')\n");
      out.write("\t\t\t}else if(nameInput.val()!=originalName){\n");
      out.write("\t\t\t\tconsole.log(originalName)\n");
      out.write("\t\t\t\tconsole.log(nameInput.val());\n");
      out.write("\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\ttype:'post',\n");
      out.write("\t\t\t\t\turl:'/user/setting/checkUserNameAndPhone',\n");
      out.write("\t\t\t\t\tdataType:'text',\n");
      out.write("\t\t\t\t\tdata:{'userName':nameInput.val(),'phone':''},\n");
      out.write("\t\t\t\t\tsuccess:function (data) {\n");
      out.write("\t\t\t\t\t\tif (data==='ok'){\n");
      out.write("\t\t\t\t\t\t\tnameSpan.text('该用户名可使用')\n");
      out.write("\t\t\t\t\t\t\tnameSpan.css('color','red')\n");
      out.write("\t\t\t\t\t\t\t$('#submit').attr(\"disabled\",false)\n");
      out.write("\t\t\t\t\t\t\t$('#submit').css('cursor','pointer')\n");
      out.write("\t\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\t\tnameSpan.text('该用户名已存在')\n");
      out.write("\t\t\t\t\t\t\tnameSpan.css('color','red')\n");
      out.write("\t\t\t\t\t\t\t$('#submit').attr(\"disabled\",true)\n");
      out.write("\t\t\t\t\t\t\t$('#submit').css('cursor','not-allowed')\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t})\n");
      out.write("\t\t\t}else {\n");
      out.write("\t\t\t\tnameSpan.text(\" \")\n");
      out.write("\t\t\t}\n");
      out.write("\t\t})\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t</script>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<div id=\"header\">\n");
      out.write("\t\t<div class=\" layui-row \">\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"layui-col-lg2 logo \">\n");
      out.write("\n");
      out.write("\t\t\t\t<img src=\"http://119.91.193.63:8080/HuanYiGamesStore/img/logo.png\" style=\"width: 190px;height: 67px;\" />\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\" layui-col-lg4   nav_list \">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><a href=\"/index\" style=\"color: white\">首页</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"/games\" style=\"color: white\">商城</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"/pointsShop\" style=\"color: white\">积分商城</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"layui-col-lg4 search\"id=\"\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div style=\"  display: inline-block; padding: 14px 0px; \">\n");
      out.write("\t\t\t\t\t<div class=\"search-border\">\n");
      out.write("\t\t\t\t\t\t<div style=\" display: inline-block;\"><input type=\"text\" id=\"searchText\" placeholder=\"请输入关键词\" class=\"search-input\" />\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"search-icon\">&nbsp;</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div class=\" layui-fluid \" id=\"section\" style=\"margin-top: 30px;\">\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"person-meau-left\">\n");
      out.write("\t\t\t\t<dl style=\"height: 600px;\">\n");
      out.write("\t\t\t\t\t<dt>订单中心</dt>\n");
      out.write("\t\t\t\t\t<dd class=\"dd-line\"></dd>\n");
      out.write("\t\t\t\t\t<dd><a href=\"/user/order\" id=\"myOrderA\">我的订单</a></dd>\n");
      out.write("\t\t\t\t\t<dd><a href=\"/user/games\" id=\"myGamesA\">我的游戏</a></dd>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<dt>我的财产</dt>\n");
      out.write("\t\t\t\t\t<dd class=\"dd-line\"></dd>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<dd><a href=\"/user/coupon\" id=\"myCouponA\">我的优惠</a></dd>\n");
      out.write("\t\t\t\t\t<dd><a href=\"/user/points\" id=\"myPointsA\">我的积分</a></dd>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<dt>我的账户</dt>\n");
      out.write("\t\t\t\t\t<dd class=\"dd-line\"></dd>\n");
      out.write("\t\t\t\t\t<dd><a href=\"/user/setting\"id=\"myInfoA\">基本信息</a></dd>\n");
      out.write("\n");
      out.write("\t\t\t\t</dl>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"person-meau-middle\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"person-items\" style=\"height: 500px;\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<form  class=\"layui-form\" novalidate=\"novalidate\"  lay-filter=\"infoForm\" enctype=\"multipart/form-data\" >\n");
      out.write("\t\t\t\t\t<div class=\"layui-row person-info-panel-top\" >\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-col-lg2\"  id=\"person-img-div\" >\n");
      out.write("\t\t\t\t\t\t\t<div class=\"file-upicon\"><button type=\"button\" style=\"position: absolute;left: -13px;top: -4px;background-color: black\"  class=\"layui-btn \" id=\"imgUpload\"><i class=\"layui-icon\"  >&#xe67c;</i></button></div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-col-lg9\" style=\" margin-left: 40px;\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"layui-row\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"layui-col-12\"><p>个性介绍不超过50字</p></div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"layui-col-12\" style=\"margin-top: 25px;\"><textarea  id=\"person-introduce\" placeholder=\"你会对别人怎么形容自己...\"name=\"introduce\" maxlength=\"50\"></textarea></div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"layui-row person-info-panel-bottom\" >\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-col-lg2\" ><p style=\"font-size:18px;\">昵称:</p></div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-col-lg9\" style=\"margin-left: 40px;\"><input type=\"text\" class=\"person-info-bottom-input\" maxlength=\"16\" id=\"nameInput\" lay-verify=\"required|username\"  name=\"username\"/><span id=\"checkName\"></span></div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-col-lg12\" ><p style=\"font-size: 12px;padding:15px 0px 40px 170px;\">2-16个字符，可由中英文、数字、“_”组成</p></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-col-lg2\"><p style=\"font-size:18px;\">手机:</p></div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-col-lg9\" style=\"margin-left: 40px;\" id=\"phone-div\"></div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-col-lg12\" style=\"padding-bottom:40px;\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-col-lg2\"><p style=\"font-size:18px;\">密码:</p></div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-col-lg9\" style=\"margin-left: 40px;\"><a href=\"javascript:updatePwd()\">修改密码</a></div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div style=\"position: absolute;right: 100px;bottom: 0px;\"><button class=\"submit-btn\" lay-submit  lay-filter=\"personInfo\" id=\"submit\"  >保存全部修改</button></div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"footer\" style=\"width: 100%;height: 300px;background-color: rgb(71,71,71);position: relative;float: left;margin-top: 200px\">\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"download\">\n");
      out.write("\t\t\t\t<p>下载客户端:</p>\n");
      out.write("\t\t\t\t<div id=\"pc\">\n");
      out.write("\t\t\t\t\t<span>PC端</span>\n");
      out.write("\t\t\t\t\t<div class=\"yuan\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"official\">\n");
      out.write("\t\t\t\t<p>官方渠道:</p>\n");
      out.write("\t\t\t\t<div id=\"qvdao1\">\n");
      out.write("\t\t\t\t\t<span>微博</span>\n");
      out.write("\t\t\t\t\t<div class=\"yuan1\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div id=\"qvdao2\">\n");
      out.write("\t\t\t\t\t<span>微信</span>\n");
      out.write("\t\t\t\t\t<div class=\"yuan2\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"friend\">\n");
      out.write("\t\t\t\t<p id=\"p\">友情连接:</p>\n");
      out.write("\t\t\t\t<div id=\"ftxt\">\n");
      out.write("\t\t\t\t\t<a id=\"p1\" href=\"\">凤凰游戏</a>\n");
      out.write("\t\t\t\t\t<a href=\"\" id=\"p2\">杉果游戏</a>\n");
      out.write("\t\t\t\t\t<a id=\"p3\" href=\"\">WeGame</a>\n");
      out.write("\t\t\t\t\t<a href=\"\" id=\"p4\">Steam</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"bqtxt\">\n");
      out.write("\t\t\t\t<p>关于我们| AboutWe|服务条款│软件许可及服务协议│隐私保护指引|儿童隐私保护指引侵权通知|广告服务│客服中心│网站导航</p>\n");
      out.write("\t\t\t\t<p>COPYRIGHT @ 2021 LoveYJ.ALL RIGHTS RESERVED. LoveYJ 版权所有</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<p><a href=\"https://beian.miit.gov.cn/#/Integrated/index\" target=\"_blank\" style=\"color: grey\">湘ICP备2021018874号</a></p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</body>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("\tth .layui-table-cell {\n");
      out.write("\n");
      out.write("\t\tmax-height: 40px;\n");
      out.write("\t\tline-height: 30px;\n");
      out.write("\t}\n");
      out.write("\t.layui-table-cell {\n");
      out.write("\n");
      out.write("\t\twhite-space: normal;\n");
      out.write("\t\theight:90px !important;\n");
      out.write("\t\tword-break: break-all;\n");
      out.write("\t}\n");
      out.write("\t.layui-table img {\n");
      out.write("\n");
      out.write("\t\tmax-height: 90px;\n");
      out.write("\t\tmax-width: 200px;\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</html>\n");
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
        out.write("\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t");
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
    // /WEB-INF/jsp/userSetting.jsp(124,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user == null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<div class=\"layui-col-lg2 \" id=\"header-right\" style=\"height: 67px;  overflow: hidden;display: inline-block;\">\n");
        out.write("\n");
        out.write("\t\t\t\t\t\t<div style=\"padding: 14px 0px;\">\n");
        out.write("\t\t\t\t\t\t\t<a href=\"/login\" style=\"text-align: center;\">\n");
        out.write("\t\t\t\t\t\t\t\t<span style=\"color: white;line-height: 35px;font-size: 12px;\">登录</span>\n");
        out.write("\t\t\t\t\t\t\t</a>\n");
        out.write("\t\t\t\t\t\t</div>\n");
        out.write("\t\t\t\t\t</div>\n");
        out.write("\t\t\t\t");
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
    // /WEB-INF/jsp/userSetting.jsp(134,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ sessionScope.user.userName != null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<div class=\"layui-col-lg2 \" id=\"header-right\" style=\"height: 67px;  overflow: hidden;display: inline-block;\">\n");
        out.write("\n");
        out.write("\t\t\t\t\t\t<div style=\"padding: 14px 0px;\">\n");
        out.write("\t\t\t\t\t\t\t<a href=\"/shopCar\">\n");
        out.write("\t\t\t\t\t\t\t\t<span class=\"shopcar\">&nbsp;</span>\n");
        out.write("\t\t\t\t\t\t\t</a>\n");
        out.write("\t\t\t\t\t\t\t<a href=\"/user/order\" id=\"flushImg\" target=\"_blank\">\n");
        out.write("\t\t\t\t\t\t\t\t<img   src=\"http://119.91.193.63:8080/HuanYiGamesStore/img/userHeadImg/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.headImg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" class=\"person-icon\"></img>\n");
        out.write("\t\t\t\t\t\t\t</a>\n");
        out.write("\t\t\t\t\t\t</div>\n");
        out.write("\t\t\t\t\t</div>\n");
        out.write("\t\t\t\t");
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
}
