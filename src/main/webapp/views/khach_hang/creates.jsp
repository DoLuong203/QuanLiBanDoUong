<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="col-8 offset-2">
    <sf:form method="post" action="${action}" modelAttribute="kh">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <sf:input path="ma" cssClass="form-control"/>
                <sf:errors path="ma"/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <sf:input path="ho" cssClass="form-control"/>
                <sf:errors path="ho"/>
            </div>
        </div>

                <div class="row mt-3">
                    <div class="col-6">
                        <label>Tên đệm</label>
                        <sf:input path="tenDem" cssClass="form-control"/>
                        <sf:errors path="tenDem"/>
                    </div>
                    <div class="col-6">
                        <label>Tên</label>
                        <sf:input path="ten" cssClass="form-control"/>
                        <sf:errors path="ten"/>
                    </div>

                </div>
                <div class="row mt-3">
                    <div class="col-6">
                        <label>Địa Chỉ</label>
                        <sf:input path="diaChi" cssClass="form-control"/>
                        <sf:errors path="diaChi"/>
                    </div>
                    <div class="col-6">
                        <label>Ngay Sinh :</label>
                        <sf:input type="date" path="ngaySinh" cssClass="form-control"/>
                        <sf:errors path="ngaySinh"/>
                    </div>
                    <div class="row mt-3">
                        <div class="col-6">
                            <label>Thành Phố</label>
                            <sf:input path="thanhPho" cssClass="form-control"/>
                            <sf:errors path="thanhPho"/>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-6">
                            <label>Số điện thoại :</label>
                            <sf:input path="Sdt" cssClass="form-control"/>
                            <sf:errors path="Sdt"/>
                        </div>

                        <div class="row mt-3">
                            <div class="col-6">
                                <label>Quốc Gia</label>
                                <sf:input path="quocGia" cssClass="form-control"/>
                                <sf:errors path="quocGia"/>
                            </div>
                            <div class="col-6">
                                <label>Mật khẩu</label>
                                <sf:input type="password" path="matKhau" cssClass="form-control"/>
                                <sf:errors path="matKhau"/>
                            </div>
                            <div class="row mt-3">
                                <div class="col-6">
                                    <button class="btn btn-primary">Thêm mới</button>
                                </div>
                                <div class="col-6"></div>

                            </div>
    </sf:form>
                        </div>
    <script src="/cuongbcph27577_SOF3011_IT17321_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>