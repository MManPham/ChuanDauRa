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
        <script src="../Assets/JS/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(() => {
                let data = '';
                
                let redCDR = (ds_cdr)=>{
                    let cdr = '';
                     ds_cdr.forEach((item,index) => {
                         cdr += item.chuanDauRaMonHoc +" "+ item.ketQua+"% ";
                     })
                    return cdr; 
                }
                
                let add_lop_mh = (ds_lopmh) => {
                    ds_lopmh.forEach((element,index) => {
                        console.log(element);
                        $('#ds_sv_lmh').append(
                              "<tr>\n\
                                <td><b>"+(index+1)+"</b></td>\n\
                                   <td>"+element.tenSV+"</td>\n\
                                <td>"+element.diemqt+"</td>\n\
                                <td>"+element.diemgk+"</td>\n\
                                <td>"+element.diemth+"</td>\n\
                                <td>"+element.diemck+"</td>\n\
                                <td>"+((element.diemqt + element.diemgk + element.diemth +element.diemck)/4)+"</td>\n\
                                <td>"+redCDR(element.listCDR_MH)+"</td>\n\
                            </tr>"  
                        )
                    });
                }

                $('.gv').click((event) => {
                    let id = event.target.id;
                    $.ajax({
                        type: 'POST',
                        data: {id: id},
                        url: 'http://localhost:8080/ChuanDauRa/AjaxTruongKhoa',
                        success: (result) => {
                            data = JSON.parse(result);
                            if (data.danhSachLopCN)
                            {
                                $('#ds_sv_lmh').empty();
                                add_lop_mh(data.danhSachLopMH[0].ds_SV)
                            }
                        }
                    })
                })

            })
        </script>
    </head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-info text-light py-3 main-nav ">
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
    <body>


        <div class="row p-2 d-flex justify-content-center">
            <c:if test = "${isNQL}">
                <div class="col-3">
                    <div class="list-group" style="margin-top: 100px;">
                        <h4 class="list-group-item text-left">Danh sách giảng viên ${test} </h4>
                        <button type="button" id="${giangvien.getMaSoGiangVien()}" class="list-group-item list-group-item-action active gv">
                            Trưởng khoa.
                        </button>
                        <c:forEach items="${ds_gv}"  var="gv" >
                            <c:if test = "${gv.getMaSoGiangVien()!=giangvien.getMaSoGiangVien()}">                            
                                <button type="button" class="list-group-item list-group-item-action gv" id="${gv.getMaSoGiangVien()}">
                                    <c:out value = "${gv.getTenGiangVien()}"/>
                                </button></c:if>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="col-9">
                <div class="container " style="padding-top: 20px;margin-top: 100px; box-shadow: 0 0 1px 2px #a3a3c2; background:'white';border-radius: 5px;">
                    <h1>Lớp môn học</h1>
                    <c:forEach items="${giangvien.getDanhSachLopMH()}"  var="ds_lop_mh" >
                        <h4><c:out value = "${ds_lop_mh.getTen_Lop()}"/></h4>
                        <div class="table-responsive" id="sailorTableArea">
                            <table id="sailorTable" class="table hold table-hover  " width="100%" style="color: 'white'">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th >Tên sinh viên</th>
                                        <th  class="text-center" >Quá trình</th>
                                        <th class="text-center">Giữa kỳ</th>
                                        <th class="text-center">Thực hành</th>
                                        <th class="text-center">Cuối kỳ</th>
                                        <th class="text-center">Trung bình</th> 
                                        <th style='width:23%'>Chuẩn đầu ra môn học</th>
                                    </tr>
                                </thead>
                                <tbody id="ds_sv_lmh">
                                    <c:forEach varStatus="loop" items="${ds_lop_mh.getDs_SV()}"  var="lop_mh" >
                                        <tr class="sv_lmh">
                                            <td><b>${loop.index +1}<b></td>
                                                        <td ><c:out value = "${lop_mh.getTensv()}"/></td>
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