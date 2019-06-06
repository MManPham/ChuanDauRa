/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HttpRequest.HttpLogin;
import Models.Sinhvien;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Man Pham
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpLogin _httpLogin = null;
        String UrlPostSV = "http://localhost:8080/ChuanDauRa_API/chuandaura/login/sinhvien";
        String UrlPostGV = "http://localhost:8080/ChuanDauRa_API/chuandaura/login/giaovien";
        Boolean isNQL = null;
        try {
            String password = request.getParameter("yourPassword");
            String _id = request.getParameter("yourId");
            _httpLogin = new HttpLogin(_id, password);
            Boolean isSV = _httpLogin.httpPostAccout(UrlPostSV);
            if (!isSV) {
                Boolean isGV = _httpLogin.httpPostAccout(UrlPostGV);
                if(!isGV){
                    String errMessge = _httpLogin.getErMessage();
                    response.sendRedirect("index.jsp");
                    //Go to Web Login
                }else{
                   isNQL = _httpLogin.isNQL;
                   //Go to Web GV
                   response.sendRedirect("WebProfile/giangvien.jsp");
                }
            }else{
                //go to Web Sinh Vien
                response.sendRedirect("WebProfile/sinhvien.jsp");
            }

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}













