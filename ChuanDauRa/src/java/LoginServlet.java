/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HttpRequest.HttpLogin;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.models.CDR_KH_KQW;
import com.models.CDR_MHW;
import com.models.GiangVienW;
import com.models.ListCDR_MHW;
import com.models.Lop_MHW;
import com.models.SinhvienMonhocW;
import com.models.SinhvienW;
import com.models.testSinhvienMonhocW;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.*;

/**
 *
 * @author Man Pham
 */
class Sortbyroll implements Comparator<CDR_KH_KQW> {

    public int getNumberCdr(String cdr) {
        int numbCdr = Integer.parseInt(cdr.substring(3));
        return numbCdr;
    }

    public int compare(CDR_KH_KQW a, CDR_KH_KQW b) {
        return getNumberCdr(a.getChuanDaura()) - getNumberCdr(b.getChuanDaura());
    }
}

public class LoginServlet extends HttpServlet {

    public SinhvienW getSinhVienJson(String jsonResponse) {

        List<CDR_KH_KQW> ls_cdr_khkq = new ArrayList<>();
        List<ListCDR_MHW> ls_cdr_mh = new ArrayList<>();
        JSONObject sv_object = new JSONObject(jsonResponse.toString());
        Gson gson = new Gson();
        SinhvienW SV_Response = new Gson().fromJson(jsonResponse, SinhvienW.class);
        return SV_Response;
    }

    public ArrayList<testSinhvienMonhocW> getSVMHJson(JSONArray json_ls_kqmh, Boolean isSV) {
        Gson gson = new Gson();
        ArrayList<testSinhvienMonhocW> ls_kqmh = new ArrayList<>();
        java.lang.reflect.Type listType = new TypeToken<List<testSinhvienMonhocW>>() {
        }.getType();
        for (int i = 0; i < json_ls_kqmh.length(); i++) {
            JSONObject chitiet_kqmh = json_ls_kqmh.getJSONObject(i);
            JsonParser jsonParser = new JsonParser();
            JsonObject gsonObject = (JsonObject) jsonParser.parse(chitiet_kqmh.toString());
            testSinhvienMonhocW temp = new Gson().fromJson(gsonObject, testSinhvienMonhocW.class);
            ls_kqmh.add(temp);
        }

        return ls_kqmh;
    }

    public GiangVienW getGiangVienJson(String jsonResponse) {

        JSONObject json_gv = new JSONObject(jsonResponse.toString());
        Gson gson = new Gson();
        GiangVienW gv_return = new Gson().fromJson(jsonResponse, GiangVienW.class);
        return gv_return;
    }

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
        String URL = "http://localhost:8080/ChuanDauRa_API/chuandaura";
        Boolean isNQL = null;
        try {
            String password = request.getParameter("yourPassword");
            String _id = request.getParameter("yourId");
            _httpLogin = new HttpLogin(_id, password);
            Boolean isSV = _httpLogin.httpPostAccout(URL + "/login/sinhvien");
            if (!isSV) {
                Boolean isGV = _httpLogin.httpPostAccout(URL + "/login/giaovien");
                if (!isGV) {
                    String errMessge = _httpLogin.getErMessage();
                    response.sendRedirect("index.jsp");
                    //Go to Web Login
                } else {
                    HttpSession session = request.getSession();
                    isNQL = _httpLogin.isNQL;
                    List<GiangVienW> ds_gv = new ArrayList<>();
                    if (isNQL) {
                        ds_gv = this.getDsGiangVienJson(_httpLogin.httpGetAccout(URL + "/giangvien/"));
                        session.setAttribute("ds_gv", ds_gv);
                    }

                    GiangVienW GV_Response = this.getGiangVienJson(_httpLogin.httpGetAccout(URL + "/giangvien/" + _id));

                    session.setAttribute("giangvien", GV_Response);
                    session.setAttribute("test", "minhman");
                    session.setAttribute("isNQL", isNQL);

                    //Go to Web GV
                    response.sendRedirect("WebProfile/giangvien.jsp");
                }
            } else {

                SinhvienW SV_Response = this.getSinhVienJson(_httpLogin.httpGetAccout(URL + "/sinhvien/" + _id));
                JSONArray json_ls_kqmh = new JSONArray(_httpLogin.httpGetAccout(URL + "/testketquahoc/" + _id));

                ArrayList<testSinhvienMonhocW> LS_SV_MH = this.getSVMHJson(json_ls_kqmh, true);

                HttpSession session = request.getSession();
                session.setAttribute("sinhvien", SV_Response);
                session.setAttribute("ketquaHT", LS_SV_MH);

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



