package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>登录页</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"js/bootstrap.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\" background-image: url('Desert.jpg');background-size: cover\">\r\n");
      out.write("<nav class=\" navbar navbar-inverse navbar-fixed-top \"  role=\"navigation\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"navbar-header\"><a  href=\"\" class=\"navbar-brand\">1924 8322</a></div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("    <div style=\"height: auto\">\r\n");
      out.write("\r\n");
      out.write("    <div style=\"margin-top: 100px;margin-left: auto;margin-right: auto ;width: 500px;\r\n");
      out.write("    background-color: #eee;height: 200px\" >\r\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath() );
      out.write("/loginAction\" method=\"post\">\r\n");
      out.write("        <div style=\"background-color: #fff\">电影租赁管理系统</div>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-2 col-md-offset-2\" style=\"margin-top: 30px\">用户名</div>\r\n");
      out.write("            <div class=\"col-md-6\"style=\"margin-top: 30px\"><input type=\"text\" name=\"username\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-2 col-md-offset-2\" style=\"margin-top: 30px\">密码</div>\r\n");
      out.write("            <div class=\"col-md-5\"style=\"margin-top: 30px\"><input type=\"password\" name=\"password\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row\"><input class=\"btn btn-info col-md-2 col-md-offset-2\"  style=\"margin-top: 5px\" value=\"登录\" type=\"submit\"></div>\r\n");
      out.write("    </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
