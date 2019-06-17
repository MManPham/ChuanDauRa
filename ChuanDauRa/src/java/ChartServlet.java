/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HttpRequest.HttpLogin;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.models.CDR_KH_KQW;
import com.models.Chart;
import com.models.ChartModel;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Hayama
 */
@WebServlet(urlPatterns = {"/ChartServlet"})
public class ChartServlet extends HttpServlet {
    
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
            out.println("<title>Servlet ChartServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public ArrayList<CDR_KH_KQW> getListCDRKH(String  url) throws UnsupportedEncodingException, IOException{
        HttpLogin _httpLogin = new HttpLogin();
        String s = _httpLogin.httpGetAccout(url);
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(s);
        JsonArray trade = tradeElement.getAsJsonArray();        
        ArrayList<CDR_KH_KQW> listCDRKH = new ArrayList<>();
        
        
        for (int i = 0; i < trade.size(); i++) {
            CDR_KH_KQW temp = new Gson().fromJson(trade.get(i), CDR_KH_KQW.class);
            listCDRKH.add(temp);
        }
//        System.out.println(trade);
        

        // java.lang.reflect.Type listType = new TypeToken<List<ds_gv>>() {}.getType();
       

        return listCDRKH;
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
                // processRequest(request, response);
    
        String yearOne =  request.getParameter("yearOne");
        String yearTwo = request.getParameter("yearTwo");
        HttpLogin _httpLogin = new HttpLogin();
        String URL = "http://localhost:8080/ChuanDauRa_API/chuandaura/nhaquanly/GV0001/";
        
        ArrayList<CDR_KH_KQW> yearOneCDRKH = this.getListCDRKH(URL + yearOne);
        ArrayList<CDR_KH_KQW> yearTwoCDRKH = this.getListCDRKH(URL + yearTwo);
        ChartModel chart = new ChartModel(yearOneCDRKH, yearTwoCDRKH);
        List<Chart> pieDataList = chart.getDataArray();
//        
//        List b = new ArrayList();
//        
//        
//        chart.getDataArray().forEach((x )->{
//                List a = new ArrayList();
//                a.add(x.getChuanDauRa());
//                a.add((float)x.getKetQuaNienKhoaDau());
//                a.add((float)x.getKetQuaNienKhoaSau());
//                b.add(a);
//                
//            });
        
        HttpSession session = request.getSession();
        // request.setAttribute("pieDataList", pieDataList);
        session.setAttribute("pieDataList", pieDataList);
        session.setAttribute("yearOne", yearOne);
        session.setAttribute("yearTwo", yearTwo);
        
        response.sendRedirect("http://localhost:8080/ChuanDauRa/chart.jsp");
       
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
        processRequest(request, response);
        
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
