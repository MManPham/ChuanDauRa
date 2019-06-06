<%-- 
    Document   : giangvien
    Created on : 06-Jun-2019, 12:01:41
    Author     : Man Pham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>GiangVien</title>
        <link href="../Assets/Css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-info text-light py-3 main-nav">
            <div class="container">
                <a class="navbar-brand" href="index.html"><img src="https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjhjPfY_97WAhWCOI8KHSvHA34QjRwIBw&url=http%3A%2F%2Fpluspng.com%2Fhp-png-1793.html&psig=AOvVaw38ZFiKrvcpgGwQUMhu9Vx8&ust=1507481987906950" alt="Logo"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

            </div>
        </nav>
    </header>
    <body>
        <div class="container" style="padding-top: 30px;margin-top: 50px; box-shadow: 0 0 3px 3px #a3a3c2; background: #e6f2ff;border-radius: 5px;">

            <h1>Lớp môn học</h1>
            Tên lớp <select id="options" onchange="optionCheck()" style="border-radius: 5px;">
                <option value="show">Công nghệ java</option>
                <option value="goto"></option>
                <option value="show"></option>
                <option value="goto"></option>
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



            <div class="table-responsive" id="sailorTableArea">
                <table id="sailorTable" class="table table-striped table-bordered" width="100%">

                    <thead>
                        <tr>
                            <th>Tên sinh viên</th>
                            <th>Quá trình(?%)</th>
                            <th>Giữa kỳ(?%)</th>
                            <th>Thực hành(?%)</th>
                            <th>Cuối kỳ(?%)</th>
                            <th>Trung bình</th> 
                            <th>Chuẩn đầu ra môn học</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr> 
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>  
                    </tbody>
                </table>
            </div>
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
                <table id="sailorTable" class="table table-striped table-bordered" width="100%">

                    <thead>
                        <tr>
                            <th>Tên sinh viên</th> 
                            <th>LO[i] đạt được</th>
                            <th>Chi tiết</th>   
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr> 

                    </tbody>
                </table>
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
