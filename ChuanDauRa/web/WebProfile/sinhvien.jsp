<%-- 
    Document   : sinhvien
    Created on : 06-Jun-2019, 12:01:28
    Author     : Man Pham
--%>

<%@page import="com.models.SinhvienW"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Sinh Vien</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../Assets/Css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-info text-light py-3 main-nav">
            <div class="container">
                <a class="navbar-brand" href="index.html"><img src="https://courses.uit.edu.vn/theme/website_monhoc/pix/logo-header.png" alt="Logo"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <label class="ml-auto mr-2  text-light mb-0">Nguyen Van A</label>|&nbsp;
                <a href="#" class=" text-light"> Đăng xuất</a>

            </div>
        </nav>
    </header>
    <body style=" background: #ccf5ff;">
        <%
            if (session.getAttribute("sinhvien") == null) {
                response.sendRedirect("index.jsp");
            }

        %>

        <div class="container" style="padding-top: 30px;margin-top: 50px; box-shadow: 0 0 3px 3px #a3a3c2; background: white;border-radius: 5px;">
            <div id="products" class="row view-group">
                <div class="item col-xs-8 col-lg-8">

                    <div class="img-event">
                        <h1 class="group card-title inner list-group-item-heading">
                            Tin tức chung  

                        </h1>        

                    </div>
                    <div class="caption card-body">
                        <p>- Tổng tín chỉ đạt được: ${ketquaHT.size()*4}</p>
                        <p>- Tổng chuẩn đầu ra hoàn thành: 7/13</p><hr>
                        <h1>Các khóa học</h1>
                        <h2>Tìm kiếm</h2>
                        Khóa học <select id="options" onchange="optionCheck()">
                            <option value="show">Show Div</option>
                            <option value="goto">Go To Google</option>
                        </select>&emsp;
                        Năm <select id="options" onchange="optionCheck()">
                            <option value="show">Show Div</option>
                            <option value="goto">Go To Google</option>
                        </select>&emsp;
                        Học kỳ <select id="options" onchange="optionCheck()">
                            <option value="show">HK1</option>
                            <option value="goto">HK2</option>
                            <option value="goto">HK3</option>
                        </select>&emsp;&emsp;&emsp;
                        <button class="btn-info">Xem</button><br>
                        </hr>
                        <c:forEach items="${ketquaHT}"  var="kq_mh" >
                            <div class="thumbnail card m-2 row">
                                <div class="d-flex justify-content-between p-2 pb-0">
                                    <p>Tên môn học chuyên nghành:<span> <c:out value = "${kq_mh.getTenLop()}"/></span> </p>
                                    <p>Số tín chỉ: <span> <c:out value = "${kq_mh.getTinChi()}"/></span></p>
                                </div>
                                <p>- Kết quả học tập</p>
                                <div class="table-responsive" id="sailorTableArea">
                                    <table id="sailorTable" class="table table-striped table-bordered" width="100%">

                                        <thead>
                                            <tr>
                                                <th>Quá trình</th>
                                                <th>Giữa kỳ</th>
                                                <th>Thực hành</th>
                                                <th>Cuối kỳ</th>
                                                <th>Trung bình</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td> <c:out value = "${kq_mh.getDiemqt()}"/></td>
                                                <td> <c:out value = "${kq_mh.getDiemgk()}"/></td>
                                                <td> <c:out value = "${kq_mh.getDiemgk()}"/></td>
                                                <td> <c:out value = "${kq_mh.getDiemth()}"/></td>
                                                <td> <c:out value = "${kq_mh.getDiemck()}"/></td>

                                            </tr> 
                                        </tbody>
                                    </table>
                                </div>
                                <p>- Đạt chuẩn đầu ra</P>
                                <div class="table-responsive" id="sailorTableArea">
                                    <table id="sailorTable" class="table table-striped table-bordered" width="100%">

                                        <thead>
                                            <tr>
                                                <th>Môn học</th>
                                                <th>Chuyên nghành</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${kq_mh.getListCDR_MH()}"  var="cdr_mh" >
                                                <tr>
                                                    <td><c:out value = "${cdr_mh.getChuanDauRaMonHoc()}"/>  <c:out value = "${cdr_mh.getKetQua()}"/>%</td>
                                                    <td><c:forEach items = "${cdr_mh.getChuanDauRaKhoaHoc()}" var = "cdr_cn"> 
                                                            <c:out value = "${cdr_cn.getChuanDaura()}"/>: <c:out value = "${cdr_cn.getKetQua()}"/> 
                                                        </c:forEach> 
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </c:forEach>


                    </div>
                </div>

                <div class="item col-xs-4 col-lg-4">
                    <div class="table-responsive" id="sailorTableArea">
                        <table id="sailorTable" class="table table-striped table-bordered" width="100%">

                            <thead>
                                <tr>
                                    <th colspan="2"><h5>&emsp;&emsp;&emsp;Chuẩn đầu ra đạt được</h5></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${sinhvien.chuanDauRA_KH}"  var="cdr_kh" >
                                    <tr>
                                        <td><c:out value = "${cdr_kh.getChuanDaura().toString()}"/></td>
                                        <td><c:out value = "${cdr_kh.getKetQua().toString()}"/></td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td colspan="2">Tổng CĐR hoàn thành:</td>

                                </tr> 

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <footer class="py-5 bg-dark" style="margin-top: 30px">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
        </div>
        <!-- /.container -->
    </footer>

</html>
