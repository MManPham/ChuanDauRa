/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HttpRequest.HttpLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.models.CDR_KH_KQW;
import com.models.CDR_MHW;
import com.models.ListCDR_MHW;
import com.models.SinhvienMonhocW;
import com.models.SinhvienW;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Man Pham
 */
class Sortbyroll implements Comparator<CDR_KH_KQW> {

    public int getNumberCdr(String cdr) {
        int numbCdr = Integer.parseInt(cdr.substring(3));
        return numbCdr;
    }

    // Used for sorting in ascending order of 
    // roll number 
    public int compare(CDR_KH_KQW a, CDR_KH_KQW b) {
        return getNumberCdr(a.getChuanDaura()) - getNumberCdr(b.getChuanDaura());
    }
}

public class LoginServlet extends HttpServlet {

    public SinhvienW getSinhVienJson(String jsonResponse) {

        List<CDR_KH_KQW> ls_cdr_khkq = new ArrayList<>();
        List<ListCDR_MHW> ls_cdr_mh = new ArrayList<>();
        JSONObject sv_object = new JSONObject(jsonResponse.toString());

        JSONArray json_ls_cdrkh = sv_object.getJSONArray("chuanDauRA_KH");
        for (int i = 0; i < json_ls_cdrkh.length(); i++) {
            String chuanDaura = json_ls_cdrkh.getJSONObject(i).getString("chuanDaura");
            float ketQua = json_ls_cdrkh.getJSONObject(i).getFloat("ketQua");
            CDR_KH_KQW cdrkh = new CDR_KH_KQW(chuanDaura, ketQua);
            ls_cdr_khkq.add(cdrkh);
        }

        JSONArray json_ls_cdrmh = sv_object.getJSONArray("listCDR_MH");
        for (int i = 0; i < json_ls_cdrmh.length(); i++) {

            JSONObject cdrmh_object = json_ls_cdrmh.getJSONObject(i);
            String maMonHoc = cdrmh_object.getString("maMon");

            JSONArray danhSach_CDR_CN = cdrmh_object.getJSONArray("danhSach_CDR_CN");
            List<CDR_MHW> new_ls_cdrmh = new ArrayList<>();

            for (int j = 0; j < danhSach_CDR_CN.length(); j++) {
                String chuanDauRaMonHoc = danhSach_CDR_CN.getJSONObject(j).getString("chuanDauRaMonHoc");
                float ketQua = danhSach_CDR_CN.getJSONObject(j).getFloat("ketQua");
                CDR_MHW cdrmh = new CDR_MHW(chuanDauRaMonHoc, ketQua);
                new_ls_cdrmh.add(cdrmh);
            }

            ls_cdr_mh.add(new ListCDR_MHW(maMonHoc, new_ls_cdrmh));
        }
        Collections.sort(ls_cdr_khkq, new Sortbyroll());
        SinhvienW SV_Response = new SinhvienW(
                sv_object.getString("mssv"),
                sv_object.getString("tensv"),
                sv_object.getString("sodt"),
                sv_object.getString("nienkhoa"),
                sv_object.getString("passw"),
                sv_object.getString("maCN"), ls_cdr_khkq, ls_cdr_mh
        );

        return SV_Response;
    }

    public List<SinhvienMonhocW> getSVMHJson(String jsonResponse, List<ListCDR_MHW> listCDR_MH) {
        List<SinhvienMonhocW> ls_kqmh = new ArrayList<>();

        JSONArray json_ls_kqmh = new JSONArray(jsonResponse.toString());
        for (int i = 0; i < json_ls_kqmh.length(); i++) {
            JSONObject chitiet_kqmh = json_ls_kqmh.getJSONObject(i);

            for (int j = 0; j < listCDR_MH.size(); j++) {
                Boolean test = listCDR_MH.get(i).getMaMon().equals(chitiet_kqmh.getString("maLopMH"));
                if (listCDR_MH.get(i).getMaMon().equals(chitiet_kqmh.getString("maLopMH"))) {
                    SinhvienMonhocW new_sv_mh = new SinhvienMonhocW(
                            chitiet_kqmh.getString("mssv"),
                            chitiet_kqmh.getString("maLopMH"),
                            chitiet_kqmh.getString("tenLop"),
                            chitiet_kqmh.getDouble("diemqt"),
                            chitiet_kqmh.getDouble("diemgk"),
                            chitiet_kqmh.getDouble("diemth"),
                            chitiet_kqmh.getDouble("diemck"),
                            chitiet_kqmh.getInt("tinChi"),
                            listCDR_MH.get(i));
                    ls_kqmh.add(new_sv_mh);
                    break;
                }

            }
        }

        return ls_kqmh;
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
                    isNQL = _httpLogin.isNQL;
                    //Go to Web GV
                    response.sendRedirect("WebProfile/giangvien.jsp");
                }
            } else {

                SinhvienW SV_Response = this.getSinhVienJson(_httpLogin.httpGetAccout(URL + "/sinhvien/" + _id));
                    List<SinhvienMonhocW> LS_SV_MH = this.getSVMHJson(_httpLogin.httpGetAccout(URL + "/ketquahoc/" + _id), SV_Response.getListCDR_MH());

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



