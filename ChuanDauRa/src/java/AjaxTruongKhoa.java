/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HttpRequest.HttpLogin;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.models.GiangVienW;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Man Pham
 */
@WebServlet(urlPatterns = {"/AjaxTruongKhoa"})
public class AjaxTruongKhoa extends HttpServlet {

    public List<GiangVienW> getDsGiangVienJson(String jsonResponse) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement trandeElement = parser.parse(jsonResponse);
        JsonArray trande = trandeElement.getAsJsonArray();
        List<GiangVienW> ds_gv = new ArrayList<>();

        for (int i = 0; i < trande.size(); i++) {
            GiangVienW temp = new Gson().fromJson(trande.get(i), GiangVienW.class);
            ds_gv.add(temp);
        }

        // java.lang.reflect.Type listType = new TypeToken<List<ds_gv>>() {}.getType();
        return ds_gv;
    }

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
            out.println("<title>Servlet AjaxTruongKhoa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjaxTruongKhoa at " + request.getContextPath() + "</h1>");
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
        String URL = "http://localhost:8080/ChuanDauRa_API/chuandaura";
        response.setContentType("text/plan;charset=UTF-8");
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        HttpLogin _httpLogin = new HttpLogin();
        out.print(_httpLogin.httpGetAccout(URL + "/giangvien/"+id));
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







