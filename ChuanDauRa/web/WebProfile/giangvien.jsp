<%-- 
    Document   : giangvien
    Created on : 06-Jun-2019, 12:01:41
    Author     : Man Pham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>GiangVien</title>
        <link href="../Assets/Css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-info text-light py-3 main-nav fixed-top">
            <div class="container">
                <a class="navbar-brand" href="index.html"><img src="https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjhjPfY_97WAhWCOI8KHSvHA34QjRwIBw&url=http%3A%2F%2Fpluspng.com%2Fhp-png-1793.html&psig=AOvVaw38ZFiKrvcpgGwQUMhu9Vx8&ust=1507481987906950" alt="Logo"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>
    </header>
    <body>
        <div class="container " style="padding-top: 30px;margin-top: 100px; box-shadow: 0 0 1px 2px #a3a3c2; background:'white';border-radius: 5px;">

            <h1>Lớp môn học</h1>
            <%--
            Tên lớp <select id="options" onchange="optionCheck()" style="border-radius: 5px;">

            <c:forEach items="${giangvien.getDanhSachLopMH()}"  var="item" >
                <option value=" <c:out value = "${item.getTen_Lop()}"/>"> <c:out value = "${item.getTen_Lop()}"/> </option>
            </c:forEach>
            </select>&emsp;
            Học kỳ <select id="options" onchange="optionCheck()" style="border-radius: 5px;">
                <option value="show">1</option>
                <option value="goto"></option>
                <option value="goto"></option>
            </select>&emsp;
            Năm <select id="options" onchange="optionCheck()" style="border-radius: 5px;">
                <option value="show">2019</option>
                <option value="goto"></option>
                <option value="goto"></option>
                <option value="show"></option>
                <option value="goto"></option>
                <option value="goto"></option>
            </select>&emsp;&emsp;&emsp;
            <button class="btn-info" style="border-radius: 5px;">Xem</button><br><br>
            --%>
            <c:forEach items="${giangvien.getDanhSachLopMH()}"  var="ds_lop_mh" >
                <h4><c:out value = "${ds_lop_mh.getTen_Lop()}"/></h4>
                <div class="table-responsive" id="sailorTableArea">
                    <table id="sailorTable" class="table hold table-hover  " width="100%" style="color: 'white'">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th >Mã số sinh viên</th>
                                <th  class="text-center" >Quá trình</th>
                                <th class="text-center">Giữa kỳ</th>
                                <th class="text-center">Thực hành</th>
                                <th class="text-center">Cuối kỳ</th>
                                <th class="text-center">Trung bình</th> 
                                <th style='width:23%'>Chuẩn đầu ra môn học</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach varStatus="loop" items="${ds_lop_mh.getDs_SV()}"  var="lop_mh" >
                                <tr>
                                    <td><b>${loop.index +1}<b></td>
                                    <td ><c:out value = "${lop_mh.getMssv()}"/></td>
                                    <td class="text-center"><c:out value = "${lop_mh.getDiemqt()}"/></td>
                                    <td class="text-center"><c:out value = "${lop_mh.getDiemgk()}"/></td>
                                    <td class="text-center"><c:out value = "${lop_mh.getDiemth()}"/></td>
                                    <td class="text-center"><c:out value = "${lop_mh.getDiemck()}"/></td>
                                    <td class="text-center"><c:out value = "${(lop_mh.getDiemck() + lop_mh.getDiemth()+ lop_mh.getDiemgk()+lop_mh.getDiemqt())/4}"/></td>
                                    <td ><c:forEach  items="${lop_mh.getListCDR_MH()}"  var="ds_cdr" >
                                            <span> <c:out value = " ${ds_cdr.getChuanDauRaMonHoc()}"/>  <c:out value = " ${ds_cdr.getKetQua()}"/>%</span>
                                    </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </c:forEach>
            <h1>Lớp sinh hoạt</h1>
            Tên lớp <select id="options" onchange="optionCheck()" style="border-radius: 5px;">
                <option value="show">Công nghệ java</option>
                <option value="goto"></option>
                <option value="show"></option>
                <option value="goto"></option>
            </select>&emsp;

            Năm <select id="options" onchange="optionCheck()" style="border-radius: 5px;">
                <option value="show">2019</option>
                <option value="goto"></option>
                <option value="goto"></option>
                <option value="show"></option>
                <option value="goto"></option>
                <option value="goto"></option>
            </select>&emsp;&emsp;&emsp;
            <button class="btn-info" style="border-radius: 5px;">Xem</button><br><br>

            <div class="table-responsive" id="sailorTableArea"> 
                <c:forEach items="${giangvien.getDanhSachLopCN()}"  var="ds_lop_sh" >
                    <h4> <c:out value = "${ds_lop_sh.getTen_Lop()}"/></h4>
                    
                <table id="sailorTable" class="table table-striped table-bordered" width="100%">

                    <thead>
                        <tr>
                            <th>Mã số sinh viên</th> 
                            <th>LO[i] đạt được</th>
                            <th>Chi tiết</th>   
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ds_lop_sh.getDs_SV()}"  var="danhSachSinhVien" >
                        <tr>
                            <td><c:out value = "${danhSachSinhVien.getMssv()}"/></td>
                            <td>
                                <c:forEach items="${danhSachSinhVien.getChuanDauRA_KH()}"  var="danhSachChuanDauRa" >
                                    <c:out value = "${danhSachChuanDauRa.getChuanDaura()}"/> :<c:out value = "${danhSachChuanDauRa.getKetQua()}"/>  
                                 </c:forEach>
                            </td>
                            <td>
                                <form action="../LoginServlet" method="GET">
                                    <input type="hidden" name="mssv" value="${danhSachSinhVien.getMssv()}" > 
                                    <input type="submit" value="Chi tiết" />
                                </form>
                            </td>

                        </tr>
                        </c:forEach>

                        
                    </tbody>
                </table>
               
                </c:forEach>
            </div>

        </div>
    </body>

    <footer class="py-5 bg-dark" style="margin-top: 30px;">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
        </div>
        <!-- /.container -->
    </footer>

</html>
