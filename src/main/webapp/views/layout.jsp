<%--
  Created by IntelliJ IDEA.
  User: Cuong
  Date: 3/22/2023
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">IT17321</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/khach_hang/index">Khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sản phẩm</a>
                </li>
            </ul>
        </div>
    </div>
    <div style="float: right"><a class="btn btn-primary" href="">Logout</a></div>
</nav>
<a></a>
<div class="row mt-2" style="min-height: 500px;">
    <div class="col-3">
        <div class="list-group">
            <button type="button" class="list-group-item list-group-item-action active" aria-current="true">
                <a href="#"></a>
            </button>
            <button type="button" class="list-group-item list-group-item-action ">
                <a href="/khach_hang/index">khách hàng</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/san_pham/index">Sản phẩm</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/chuc_vu/index">Chức vụ</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/cua_hang/index">Cửa hàng</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/mau_sac/index">Màu sắc</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/ctsp/index">Chi tiết sản phẩm</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/nhan_vien/index">Nhân viên</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/dsp/index">Dòng sàn phẩm</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/nsx/index">Nhà sản xuất</a></button>
            <button type="button" class="list-group-item list-group-item-action"><a
                    href="/hoa_don/index">Hóa Đơn</a></button>
        </div>
    </div>
    <div class="col-9">
        <jsp:include page="${ view }"/>
    </div>
</div>

<div class="row bg-dark text-white" style="min-height: 200px;">
    <footer class="bg-dark text-center text-white">
        <!-- Grid container -->
        <div class="container p-4 pb-0">
            <!-- Section: Social media -->
            <section class="mb-4">
                <!-- Facebook -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <!-- Twitter -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-twitter"></i
                ></a>

                <!-- Google -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-google"></i
                ></a>

                <!-- Instagram -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-instagram"></i
                ></a>

                <!-- Linkedin -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-linkedin-in"></i
                ></a>

                <!-- Github -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-github"></i
                ></a>
            </section>
            <!-- Section: Social media -->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2020 Copyright:
            <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>