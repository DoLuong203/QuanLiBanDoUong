<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <sf:form method="post" action="${action}" modelAttribute="hd">
    <div class="row mt-3">
        <div class="col-6">
            <label>Mã</label>
            <sf:input path="ma" cssClass="form-control"/>
            <sf:errors path="ma"/>
        </div>
        <div class="col-6">
            <label>Tên Người Nhận</label>
            <sf:input path="tenNguoiNhan" cssClass="form-control"/>
            <sf:errors path="tenNguoiNhan"/>
        </div>
    </div>

    <div class="row mt-3">
        <div class="col-6">
            <label>Ngày Tạo</label>
            <sf:input type="date" path="ngayTao" cssClass="form-control"/>
            <sf:errors path="ngayTao"/>
        </div>
        <div class="col-6">
            <label>Ngày Thanh Toán</label>
            <sf:input type="date" path="ngayThanhToan" cssClass="form-control"/>
            <sf:errors path="ngayThanhToan"/>
        </div>

    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Ngày Ship</label>
            <sf:input path="ngayShip" type="date" cssClass="form-control"/>
            <sf:errors path="ngayShip"/>
        </div>
        <div class="col-6">
            <label>Ngaỳ Nhận :</label>
            <sf:input type="date" path="ngayNhan" cssClass="form-control"/>
            <sf:errors path="ngayNhan"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Nhan Vien :</label>
            <sf:select path="nhanVienVMD" class="form-select" >
                <c:forEach items="${danhSachNV}" var="nv">
                    <option value="${nv.id}">${nv.ten}</option>
                </c:forEach>
            </sf:select>
            <sf:errors path="nhanVienVMD"/>
        </div>
        <div class="col-6">
            <label>Khách Hàng :</label>
            <sf:select path="khachHangVMD" class="form-select" >
                <c:forEach items="${danhSachKH}" var="kh">
                    <option value="${kh.id}">${kh.ten}</option>
                </c:forEach>
            </sf:select>
            <sf:errors path="khachHangVMD"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Số điện thoại :</label>
            <sf:input path="sdt" cssClass="form-control"/>
            <sf:errors path="sdt"/>
        </div>
        <div class="col-6">
            <label>Địa Chỉ:</label>
            <sf:input path="diaChi" cssClass="form-control"/>
            <sf:errors path="diaChi"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Tình Trạng</label>
            <div class="form-check">
                <sf:radiobutton class="form-check-input"  path="tinhTrang" id="flexRadioDefault1" value="0"/>
                <label class="form-check-label" for="flexRadioDefault1">
                    Đã thanh toán
                </label>
            </div>
            <div class="form-check">
                <sf:radiobutton class="form-check-input"  path="tinhTrang" id="flexRadioDefault2" value="1" />
                <label class="form-check-label" for="flexRadioDefault2">
                    Chưa Thanh Toán
                </label>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Thêm mới</button>
        </div>
        <div class="col-6"></div>

    </div>

    </sf:form>

    <script src="/cuongbcph27577_SOF3011_IT17321_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>