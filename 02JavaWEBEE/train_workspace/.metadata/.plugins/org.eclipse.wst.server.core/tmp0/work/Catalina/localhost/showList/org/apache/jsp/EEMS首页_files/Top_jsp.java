/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2017-08-27 02:31:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.EEMS首页_files;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class Top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1503714901000L));
    _jspx_dependants.put("jar:file:/Users/Zd/Desktop/GitHub/BigDataTrain/02JavaWEBEE/train_workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/showList/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098682290000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

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

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD id=Head1>\r\n");
      out.write("<TITLE>无标题页</TITLE>\r\n");
      out.write("<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\r\n");
      out.write("<STYLE type=text/css>\r\n");
      out.write("* {\r\n");
      out.write("\tFONT-SIZE: 12px;\r\n");
      out.write("\tCOLOR: white\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#logo {\r\n");
      out.write("\tCOLOR: white\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#logo A {\r\n");
      out.write("\tCOLOR: white\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("FORM {\r\n");
      out.write("\tMARGIN: 0px\r\n");
      out.write("}\r\n");
      out.write("</STYLE>\r\n");
      out.write("<SCRIPT src=\"Top.files/Clock.js\" type=text/javascript></SCRIPT>\r\n");
      out.write("<META content=\"MSHTML 6.00.2900.5848\" name=GENERATOR>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY\r\n");
      out.write("\tstyle=\"BACKGROUND-IMAGE: url(../images/bg.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x\">\r\n");
      out.write("\t<form id=\"form1\">\r\n");
      out.write("\t\t<DIV id=logo\r\n");
      out.write("\t\t\tstyle=\"BACKGROUND-IMAGE: url(../images/logo.png); BACKGROUND-REPEAT: no-repeat\">\r\n");
      out.write("\t\t\t<DIV\r\n");
      out.write("\t\t\t\tstyle=\"PADDING-RIGHT: 50px; BACKGROUND-POSITION: right 50%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(../images/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 30px; TEXT-ALIGN: right\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<A id=HyperLink2 href=\"../introduce.html\" target=\"mainFrame\">&nbsp;返&nbsp;&nbsp;回&nbsp;&nbsp;首&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;</A>\r\n");
      out.write("\t\t\t\t<IMG src=\"Top.files/menu_seprator.gif\" align=absMiddle>\r\n");
      out.write("\t\t\t\t <A id=HyperLink3\r\n");
      out.write("\t\t\t\t\thref=\"../login.jsp\">&nbsp;&nbsp;&nbsp;退&nbsp;&nbsp;出&nbsp;&nbsp;系&nbsp;&nbsp;统&nbsp;</A>\r\n");
      out.write("\t\t\t</DIV>\r\n");
      out.write("\t\t\t<DIV style=\"DISPLAY: block; HEIGHT: 54px\"></DIV>\r\n");
      out.write("\t\t\t<DIV\r\n");
      out.write("\t\t\t\tstyle=\"BACKGROUND-IMAGE: url(../images/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px\">\r\n");
      out.write("\t\t\t\t<TABLE cellSpacing=0 cellPadding=0 width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<TBODY>\r\n");
      out.write("\t\t\t\t\t\t<TR>\r\n");
      out.write("\t\t\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t\t\t<DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<IMG src=\"Top.files/nav_pre.gif\" align=absMiddle> 欢迎 <SPAN\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tid=lblBra>中北大学</SPAN> <SPAN id=lblDep>软件学院</SPAN> [ ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" ] 光临\r\n");
      out.write("\t\t\t\t\t\t\t\t</DIV></TD>\r\n");
      out.write("\t\t\t\t\t\t\t<TD align=right width=\"70%\"><SPAN\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"PADDING-RIGHT: 50px\"> <IMG\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsrc=\"Top.files/menu_seprator.gif\" align=absMiddle> <SPAN\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=clock></SPAN>\r\n");
      out.write("\t\t\t\t\t\t\t</SPAN></TD>\r\n");
      out.write("\t\t\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t\t</TBODY>\r\n");
      out.write("\t\t\t\t</TABLE>\r\n");
      out.write("\t\t\t</DIV>\r\n");
      out.write("\t\t</DIV>\r\n");
      out.write("\t\t<SCRIPT type=text/javascript>\r\n");
      out.write("\t\t\tvar clock = new Clock();\r\n");
      out.write("\t\t\tclock.display(document.getElementById(\"clock\"));\r\n");
      out.write("\t\t</SCRIPT>\r\n");
      out.write("\t</form>\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
