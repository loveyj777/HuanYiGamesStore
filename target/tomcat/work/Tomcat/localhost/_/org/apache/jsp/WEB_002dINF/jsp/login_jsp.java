/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2021-11-19 06:19:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("\t<title>欢颐游戏商城-登录</title>\r\n");
      out.write("\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"../../img/shortcut.png\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"../../js/jquery-3.5.1.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js\"></script>\r\n");
      out.write("\t<script src=\"https://ciphertrick.com/demo/jquerysession/js/jquerysession.js\"></script>\r\n");
      out.write("\t<script src=\"../../layui/layui/layui.js\"></script>\r\n");
      out.write("\t<link href=\"../../layui/layui/css/layui.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../../css/font.css\">\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\tbtn_HoverLine();\r\n");
      out.write("\t\t\tbtn_Switch();\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tvar flag = 0;\r\n");
      out.write("\r\n");
      out.write("\t\tfunction changeLine_Last_Enter() {\r\n");
      out.write("\t\t\t$('.LoginUnderLine:last').css({\r\n");
      out.write("\t\t\t\t'width': '0%',\r\n");
      out.write("\t\t\t\t'display': 'block'\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t$('.LoginUnderLine:last').animate({\r\n");
      out.write("\t\t\t\twidth: '100%'\r\n");
      out.write("\t\t\t}, 'fast', function() {\r\n");
      out.write("\t\t\t\t$('.LoginUnderLine:last').css('width', '100%')\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction changeLine_Last_Leave() {\r\n");
      out.write("\t\t\tswitch (flag) {\r\n");
      out.write("\t\t\t\tcase 0:\r\n");
      out.write("\t\t\t\t\t$('.LoginUnderLine:last').animate({\r\n");
      out.write("\t\t\t\t\t\t\t\twidth: '0%'\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t'fast'\r\n");
      out.write("\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\tcase 1:\r\n");
      out.write("\t\t\t\t\t$('.LoginUnderLine:last').animate({\r\n");
      out.write("\t\t\t\t\t\t\t\twidth: '50%'\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t'fast',\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.LoginUnderLine:last').css('width', '50%');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tfunction changeLine_First_Enter() {\r\n");
      out.write("\t\t\t$('.LoginUnderLine:first').css({\r\n");
      out.write("\t\t\t\t'display': 'block',\r\n");
      out.write("\t\t\t\t'width': '0%'\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t$('.LoginUnderLine:first').animate({\r\n");
      out.write("\t\t\t\twidth: '100%'\r\n");
      out.write("\t\t\t}, 'fast', function() {\r\n");
      out.write("\t\t\t\t$('.LoginUnderLine:first').css('width', '100%')\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction changeLine_First_Leave() {\r\n");
      out.write("\t\t\tswitch (flag) {\r\n");
      out.write("\t\t\t\tcase 0:\r\n");
      out.write("\t\t\t\t\t$('.LoginUnderLine:first').animate({\r\n");
      out.write("\t\t\t\t\t\t\t\twidth: '50%'\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t'fast',\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.LoginUnderLine:first').css('width', '50%');\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$('.LoginUnderLine:last').css('display', 'none');\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\tcase 1:\r\n");
      out.write("\t\t\t\t\t$('.LoginUnderLine:first').animate({\r\n");
      out.write("\t\t\t\t\t\t\t\twidth: '0%'\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t'fast'\r\n");
      out.write("\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction btn_HoverLine() {\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t$('#btn_UserLogin').bind({\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tmouseenter: function() {\r\n");
      out.write("\t\t\t\t\tchangeLine_Last_Enter();\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tmouseleave: function() {\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tchangeLine_Last_Leave();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t$('#btn_PhoneLogin').bind({\r\n");
      out.write("\t\t\t\tmouseenter: function() {\r\n");
      out.write("\t\t\t\t\tchangeLine_First_Enter();\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tmouseleave: function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tchangeLine_First_Leave();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction btn_Switch() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t$('#btn_UserLogin').click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$('.LoginUnderLine:first').css('display', 'none');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tlet form_PhoneLogin = $('#form_PhoneLogin');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tform_PhoneLogin.css('display', 'none')\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tlet form_UserLogin = $('#form_UserLogin');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tform_UserLogin.css('display', 'block')\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tflag = 1;\r\n");
      out.write("\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t\t$('#btn_PhoneLogin').click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$('.LoginUnderLine:last').css('display', 'none');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tlet form_UserLogin = $('#form_UserLogin');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tlet form_PhoneLogin = $('#form_PhoneLogin');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tform_UserLogin.css('display', 'none')\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tform_PhoneLogin.css('display', 'block')\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tflag = 0;\r\n");
      out.write("\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\t.form-margin {\r\n");
      out.write("\t\t\tmargin: 0 auto;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tbody {\r\n");
      out.write("\r\n");
      out.write("\t\t\tbox-sizing: border-box;\r\n");
      out.write("\t\t\tmax-width: 1920px;\r\n");
      out.write("\t\t\tmin-width: 1500px;\r\n");
      out.write("\t\t\tmargin: 0 auto;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t#section {\r\n");
      out.write("\t\t\toverflow: hidden;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t.div-btn {\r\n");
      out.write("\r\n");
      out.write("\t\t\ttext-align: center;\r\n");
      out.write("\t\t\tfont-weight: 700;\r\n");
      out.write("\t\t\theight: 30px;\r\n");
      out.write("\t\t\tfont-size: 16px;\r\n");
      out.write("\t\t\tbox-sizing: border-box;\r\n");
      out.write("\t\t\tmargin: 0 auto;\r\n");
      out.write("\t\t\tcursor: pointer;\r\n");
      out.write("\t\t\toverflow: hidden;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t#header {\r\n");
      out.write("\t\t\tborder-bottom: 2px solid orange;\r\n");
      out.write("\t\t\tpadding: 5px 0px 15px 0px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tdiv {\r\n");
      out.write("\r\n");
      out.write("\t\t\twhite-space: nowrap;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t#form_UserLogin {\r\n");
      out.write("\t\t\tdisplay: none;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t.LoginUnderLine {\r\n");
      out.write("\r\n");
      out.write("\t\t\tdisplay: block;\r\n");
      out.write("\t\t\twidth: 50%;\r\n");
      out.write("\t\t\theight: 10%;\r\n");
      out.write("\t\t\tbackground-color: red;\r\n");
      out.write("\t\t\tmargin: 5px auto;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t.login-fogetPwd {\r\n");
      out.write("\t\t\ttext-align: right;\r\n");
      out.write("\t\t\tmargin-top: 10px;\r\n");
      out.write("\t\t\tbox-sizing: border-box;\r\n");
      out.write("\t\t\toverflow: hidden;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\ta {\r\n");
      out.write("\t\t\tcursor: pointer;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t.layui-form-item {\r\n");
      out.write("\t\t\tmargin-bottom: 0px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t.msgbox {\r\n");
      out.write("\r\n");
      out.write("\t\t\theight: 18px;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t.loginpanel {\r\n");
      out.write("\t\t\twidth: 330px;\r\n");
      out.write("\t\t\theight: 350px;\r\n");
      out.write("\t\t\tposition: absolute;\r\n");
      out.write("\t\t\tright: 10%;\r\n");
      out.write("\t\t\ttop: 5%;\r\n");
      out.write("\t\t\tborder-radius: 10px;\r\n");
      out.write("\t\t\tpadding: 40px;\r\n");
      out.write("\t\t\tpadding-top: 50px;\r\n");
      out.write("\t\t\tborder: 1px solid white;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t.form-bitem {\r\n");
      out.write("\r\n");
      out.write("\t\t\tpadding-top: 15px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t.btn_Login {\r\n");
      out.write("\t\t\tcursor: pointer;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t#btn_PhoneLogin {\r\n");
      out.write("\t\t\twidth: 65%;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t#btn_UserLogin {\r\n");
      out.write("\t\t\twidth: 40%;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<div class=\" layui-row \">\r\n");
      out.write("\t\t<div class=\"layui-col-lg  layui-col-lg-offset1\">\r\n");
      out.write("\t\t\t<img src=\"../../img/logo.png\" style=\"width: 220px;\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"section\" class=\" layui-fluid \"\r\n");
      out.write("\t style=\" height: 900px;background: url(../../img/a.png) no-repeat ;background-size: cover; background-color: rgb(39,39,39);\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"loginpanel\" style=\"background-color: white;\">\r\n");
      out.write("\t\t<div class=\"layui-row   \">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"layui-col-lg6  \">\r\n");
      out.write("\t\t\t\t<div class=\"  div-btn  \" id=\"btn_PhoneLogin\" >\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t手机登录/注册\r\n");
      out.write("\t\t\t\t\t<i class=\"LoginUnderLine\"></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"layui-col-lg6   \">\r\n");
      out.write("\t\t\t\t<div class=\" div-btn  \" id=\"btn_UserLogin\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t密码登入\r\n");
      out.write("\t\t\t\t\t<i class=\"LoginUnderLine\" style=\"display: none;\"></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<form class=\"layui-form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login/userLogin\" method=\"post\" style=\"margin-top: 20px; \" id=\"form_UserLogin\" lay-filter=\"userForm\"\r\n");
      out.write("\t\t\t  novalidate=\"novalidate\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"layui-row\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item layui-col-lg\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block  form-margin\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"username\" required lay-verify=\"required|username\"\r\n");
      out.write("\t\t\t\t\t\t\t   placeholder=\"用户名\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-col-lg msgbox\"><span id=\"userCheckMsg\"></span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"layui-row  \">\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item layui-col-lg\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block form-margin\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password\" required lay-verify=\"required|password\"\r\n");
      out.write("\t\t\t\t\t\t\t   placeholder=\"密码\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-col-lg msgbox\"><span id=\"nouseID\"></span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"layui-row  \">\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item layui-col-lg\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block form-margin\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"submit-btn btn_Login layui-bg-orange layui-input\" lay-submit  lay-filter=\"userLogin\" >登入</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"layui-row form-bitem\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-form-item layui-col-lg6 \" pane>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-block form-margin\" style=\"margin: 0px;padding: 0px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=rememberPwd\" title=\"记住密码\" class=\"layui-input \" lay-filter=\"rememberPwd\" id=\"rememberPwd\"\r\n");
      out.write("\t\t\t\t\t\t\t\t   lay-skin=\"primary\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<form class=\"layui-form\" action=\"\" style=\"margin-top: 20px;\" id=\"form_PhoneLogin\" method=\"\"  lay-filter=\"phoneForm\" novalidate=\"novalidate\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"layui-row\">\r\n");
      out.write("\t\t\t<div class=\"layui-form-item layui-col-lg\" pane>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-block  form-margin\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"phone\" required lay-verify=\"required|phone\" placeholder=\"电话号码\" id=\"phone\"\r\n");
      out.write("\t\t\t\t\t\t   autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-col-lg msgbox\"><span id=\"phoneCheckMsg\"></span></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"layui-row  \">\r\n");
      out.write("\t\t\t<div class=\"layui-form-item layui-col-lg7\" pane>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline form-margin\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"idCode\" required lay-verify=\"required \" id=\"idCode\"\r\n");
      out.write("\t\t\t\t\t\t   placeholder=\"验证码\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"layui-col-lg5 \" >\r\n");
      out.write("\t\t\t\t<div id=\"sendIdentifyingCode\"     class=\"layui-input layui-bg-black\" style=\"cursor: pointer;line-height: 38px;text-align: center;\" >\r\n");
      out.write("\t\t\t\t\t获取验证码\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"layui-col-lg12 msgbox \"><span id=\"pwdCheckMsg\"></span></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"layui-row\">\r\n");
      out.write("\t\t\t<div class=\"layui-col-lg12 \" style=\"margin: 3px 0px 20px 0px; color:darkorange; box-sizing: border-box; overflow: hidden; font-weight: bold;\">\r\n");
      out.write("\t\t\t\t未注册的手机号登录后会直接注册为新的账号\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-form-item layui-col-lg\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-block form-margin\">\r\n");
      out.write("\t\t\t\t\t<button class=\"submit-btn btn_Login layui-bg-orange layui-input\" lay-submit  lay-filter=\"phoneLogin\" >登入</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\tlayui.use('form', function() {\r\n");
      out.write("\r\n");
      out.write("\t\tvar form = layui.form;\r\n");
      out.write("\t\tvar IdentifyingCode;\r\n");
      out.write("\r\n");
      out.write("\t\tform.on('checkbox(rememberPwd)', function(data){\r\n");
      out.write("\t\t\t$.cookie(\"flag\",data.elem.checked ,{ expires: 7, path: '/' })\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tif ($.cookie(\"flag\")==='true')\r\n");
      out.write("\t\t{\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tform.val(\"userForm\", {\r\n");
      out.write("\t\t\t\t\t\"username\":$.cookie(\"username\")\r\n");
      out.write("\t\t\t\t\t,\"password\": $.cookie(\"password\")\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t$(\"#rememberPwd\").prop(\"checked\",true)\r\n");
      out.write("\t\t\tform.render();\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tform.val(\"userForm\", {\r\n");
      out.write("\t\t\t\t\"username\":$.cookie(\"username\")\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\tform.render();\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tform.on('submit(userLogin)', function(data){\r\n");
      out.write("\t\t\tuserLogin();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tfunction userLogin(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\tmethod:'post',\r\n");
      out.write("\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/userLogin\",\r\n");
      out.write("\t\t\t\tdataType:'text',\r\n");
      out.write("\t\t\t\tdata:form.val(\"userForm\"),\r\n");
      out.write("\t\t\t\tsuccess:function (data){\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif(data==\"error\")\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"登陆失败\" ,{time: 1500 ,icon:2});\r\n");
      out.write("\t\t\t\t\t\t$.cookie(\"flag\",\"false\")\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\tif($.cookie(\"flag\")===\"true\")\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t$.cookie(\"username\",form.val(\"userForm\").username, { expires: 7, path: '/' });\r\n");
      out.write("\t\t\t\t\t\t\t$.cookie(\"password\",form.val(\"userForm\").password, { expires: 7, path: '/' });\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\telse {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t$.removeCookie(\"password\",{ expires: 7, path: '/' });\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tlocation.href = data;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction  resetCode(){\r\n");
      out.write("\tlet \ta=60;\r\n");
      out.write("\t\tlet sendIdentifyingCode=$(\"#sendIdentifyingCode\");\r\n");
      out.write("\t\tlet timer=null\r\n");
      out.write("\t timer =\tsetInterval(function () {\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (a>0){\r\n");
      out.write("\t\t\t\tsendIdentifyingCode.html('('+a+\")秒后重新发送\");\r\n");
      out.write("\t\t\t\tsendIdentifyingCode.css({\"cursor\":\"not-allowed\",\"pointer-events\":\"none\"});\r\n");
      out.write("\t\t\t\ta-=1;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tclearInterval(timer);\r\n");
      out.write("\t\t\t\tsendIdentifyingCode.html(\"获取验证码\");\r\n");
      out.write("\t\t\t\tsendIdentifyingCode.css({\"cursor\":\"pointer\",\"pointer-events\":\"unset\"});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}, 1000)\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tlayui.use('form',function (){\r\n");
      out.write("\r\n");
      out.write("\tvar\tform = layui.form;\r\n");
      out.write("\r\n");
      out.write("\tvar IdentifyingCode;\r\n");
      out.write("\r\n");
      out.write("\tvar reg=/^1[3456789]\\d{9}$/;\r\n");
      out.write("\t\tvar sendIdentifyingCode=$(\"#sendIdentifyingCode\");\r\n");
      out.write("\r\n");
      out.write("\t\tsendIdentifyingCode.click(function () {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar phoneNum =$(\"#phone\").val()\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(reg.test(phoneNum)){\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sendIdentifyingCode\",\r\n");
      out.write("\t\t\t\t\tdataType: 'text',\r\n");
      out.write("\t\t\t\t\tdata: form.val('phoneForm'),\r\n");
      out.write("\t\t\t\t\tsuccess:function (data){\r\n");
      out.write("\t\t\t\t\t\tresetCode();\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"验证码已发送\", {time: 1500, icon: 1});\r\n");
      out.write("\t\t\t\t\t\tIdentifyingCode=data;\r\n");
      out.write("\t\t\t\t\t\tconsole.log(IdentifyingCode);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tlayer.msg(\"请输入正确的手机号\", {time: 1500, icon: 2});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tform.on('submit(phoneLogin)', function(data){\r\n");
      out.write("\t\t\tconsole.log(IdentifyingCode)\r\n");
      out.write("\t\t\tvar idCode=$(\"#idCode\").val();\r\n");
      out.write("\t\t\tif(idCode == IdentifyingCode)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tphoneLogin()\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse {\r\n");
      out.write("\t\t\t\tlayer.msg(\"验证码错误\" ,{time: 1500 ,icon:2});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tfunction phoneLogin(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\tmethod:'post',\r\n");
      out.write("\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/phoneLogin\",\r\n");
      out.write("\t\t\t\tdataType:'text',\r\n");
      out.write("\t\t\t\tdata:form.val(\"phoneForm\"),\r\n");
      out.write("\t\t\t\tsuccess:function (data){\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\tlocation.href = data;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
}
