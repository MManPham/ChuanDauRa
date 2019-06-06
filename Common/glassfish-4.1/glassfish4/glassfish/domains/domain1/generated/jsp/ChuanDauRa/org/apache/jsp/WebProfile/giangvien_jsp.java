package org.apache.jsp.WebProfile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class giangvien_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>GiangVien</title>\n");
      out.write("        <link href=\"../Assets/Css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <header>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-info text-light py-3 main-nav\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.html\"><img src=\"https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjhjPfY_97WAhWCOI8KHSvHA34QjRwIBw&url=http%3A%2F%2Fpluspng.com%2Fhp-png-1793.html&psig=AOvVaw38ZFiKrvcpgGwQUMhu9Vx8&ust=1507481987906950\" alt=\"Logo\"></a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\" style=\"padding-top: 30px;margin-top: 50px; box-shadow: 0 0 3px 3px #a3a3c2; background: #e6f2ff;border-radius: 5px;\">\n");
      out.write("\n");
      out.write("            <h1>Lớp môn học</h1>\n");
      out.write("            Tên lớp <select id=\"options\" onchange=\"optionCheck()\" style=\"border-radius: 5px;\">\n");
      out.write("                <option value=\"show\">Công nghệ java</option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"show\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("            </select>&emsp;\n");
      out.write("            Học kỳ <select id=\"options\" onchange=\"optionCheck()\" style=\"border-radius: 5px;\">\n");
      out.write("                <option value=\"show\">1</option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("            </select>&emsp;\n");
      out.write("            Năm <select id=\"options\" onchange=\"optionCheck()\" style=\"border-radius: 5px;\">\n");
      out.write("                <option value=\"show\">2019</option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"show\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("            </select>&emsp;&emsp;&emsp;\n");
      out.write("            <button class=\"btn-info\" style=\"border-radius: 5px;\">Xem</button><br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"table-responsive\" id=\"sailorTableArea\">\n");
      out.write("                <table id=\"sailorTable\" class=\"table table-striped table-bordered\" width=\"100%\">\n");
      out.write("\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Tên sinh viên</th>\n");
      out.write("                            <th>Quá trình(?%)</th>\n");
      out.write("                            <th>Giữa kỳ(?%)</th>\n");
      out.write("                            <th>Thực hành(?%)</th>\n");
      out.write("                            <th>Cuối kỳ(?%)</th>\n");
      out.write("                            <th>Trung bình</th> \n");
      out.write("                            <th>Chuẩn đầu ra môn học</th>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>  \n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <h1>Lớp sinh hoạt</h1>\n");
      out.write("            Tên lớp <select id=\"options\" onchange=\"optionCheck()\" style=\"border-radius: 5px;\">\n");
      out.write("                <option value=\"show\">Công nghệ java</option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"show\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("            </select>&emsp;\n");
      out.write("\n");
      out.write("            Năm <select id=\"options\" onchange=\"optionCheck()\" style=\"border-radius: 5px;\">\n");
      out.write("                <option value=\"show\">2019</option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"show\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("                <option value=\"goto\"></option>\n");
      out.write("            </select>&emsp;&emsp;&emsp;\n");
      out.write("            <button class=\"btn-info\" style=\"border-radius: 5px;\">Xem</button><br><br>\n");
      out.write("\n");
      out.write("            <div class=\"table-responsive\" id=\"sailorTableArea\"> \n");
      out.write("                <table id=\"sailorTable\" class=\"table table-striped table-bordered\" width=\"100%\">\n");
      out.write("\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Tên sinh viên</th> \n");
      out.write("                            <th>LO[i] đạt được</th>\n");
      out.write("                            <th>Chi tiết</th>   \n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("\n");
      out.write("                        </tr> \n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <footer class=\"py-5 bg-dark\" style=\"margin-top: 30px;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <p class=\"m-0 text-center text-white\">Copyright &copy; Your Website 2019</p>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("</html>\n");
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
