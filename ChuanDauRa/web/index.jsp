<%-- 
    Document   : index
    Created on : 03-Jun-2019, 00:41:14
    Author     : Man Pham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Đăng nhập</title>
        <link rel="stylesheet" type="text/css" href="Assets/Css/login.css">
        <link href="Assets/Css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-info text-light py-3 main-nav">
            <div class="container">
                <a class="navbar-brand" href="index.html"><img src="https://courses.uit.edu.vn/theme/website_monhoc/pix/logo-header.png" alt="Logo" alt="Logo"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

            </div>
        </nav>
    </header>
    <body id="LoginForm">
        <div class="container">

            <div class="login-form">
                <div class="main-div">
                    <div class="panel">
                        <h1>Đăng nhập</h1>
                        <p>vui lòng nhập ID và mật khẩu!</p>
                    </div>
                    <form id="Login" action="LoginServlet" method="POST">
                        <div class="form-group">
                            <input type="text" name="yourId" class="form-control" id="inputEmail" value ="12340001" placeholder="VD: 16521805">
                        </div>
                        <div class="form-group">
                            <input type="password" name="yourPassword" class="form-control" id="inputPassword" value="Pass" placeholder="Mật khẩu">
                        </div>
                        <input type="checkbox"> Ghi nhớ tài khoản
                        <button type="submit" class="btn btn-primary">Đăng nhập</button>
                        <div class="forgot">
                            <a href="#">Quên mật khẩu?</a>
                        </div>
                    </form>
                </div>

            </div></div></div>


</body>

<footer class="py-5 bg-dark" style="margin-top: 30px;">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
</footer>

</html>
