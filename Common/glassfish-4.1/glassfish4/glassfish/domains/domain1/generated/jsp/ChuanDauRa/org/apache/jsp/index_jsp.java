package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>Đăng nhập</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Assets/Css/login.css\">\r\n");
      out.write("        <link href=\"Assets/Css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <header>\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-info text-light py-3 main-nav\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.html\"><img src=\"https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjhjPfY_97WAhWCOI8KHSvHA34QjRwIBw&url=http%3A%2F%2Fpluspng.com%2Fhp-png-1793.html&psig=AOvVaw38ZFiKrvcpgGwQUMhu9Vx8&ust=1507481987906950\" alt=\"Logo\"></a>\r\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("    <body id=\"LoginForm\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"login-form\">\r\n");
      out.write("                <div class=\"main-div\">\r\n");
      out.write("                    <div class=\"panel\">\r\n");
      out.write("                        <h1>Đăng nhập</h1>\r\n");
      out.write("                        <p>vui lòng nhập ID và mật khẩu!</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <form id=\"Login\" action=\"LoginServlet\" method=\"POST\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <input type=\"text\" name=\"yourId\" class=\"form-control\" id=\"inputEmail\" value =\"12340001\" placeholder=\"VD: 16521805\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <input type=\"password\" name=\"yourPassword\" class=\"form-control\" id=\"inputPassword\" value=\"Pass\" placeholder=\"Mật khẩu\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <input type=\"checkbox\"> Ghi nhớ tài khoản\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\">Đăng nhập</button>\r\n");
      out.write("                        <div class=\"forgot\">\r\n");
      out.write("                            <a href=\"#\">Quên mật khẩu?</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div></div></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<footer class=\"py-5 bg-dark\" style=\"margin-top: 30px;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <p class=\"m-0 text-center text-white\">Copyright &copy; Your Website 2019</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.container -->\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
