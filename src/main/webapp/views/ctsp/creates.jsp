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
    <sf:form method="post" action="${action}" modelAttribute="ctsp">

        <div class="row mt-3">
            <div class="col-6">
                <label>San Pham :</label>
                <sf:select path="sanPhamVMD" class="form-select" >
                    <c:forEach items="${danhSachSP}" var="sp">
                        <option value="${sp.id}">${sp       .ten}</option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="sanPhamVMD"/>
            </div>
            <div class="col-6">
                <label>Mau Sac :</label>
                <sf:select path="mauSacVMD" class="form-select" >
                    <c:forEach items="${danhSachMS}" var="ms">
                        <option value="${ms.id}">${ms.ten}</option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="mauSacVMD"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Dong San Pham :</label>
                <sf:select path="dspVMD" class="form-select" >
                    <c:forEach items="${danhSachDSP}" var="dsp">
                        <option value="${dsp.id}">${dsp.ten}</option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="dspVMD"/>
            </div>
            <div class="col-6">
                <label>NSX :</label>
                <sf:select path="nsxVMD" class="form-select" >
                    <c:forEach items="${danhSachNSX}" var="nsx">
                        <option value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="nsxVMD"/>
            </div>
        </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Nam bao hanh </label>
            <sf:input path="namBH" type="number" cssClass="form-control"/>
            <sf:errors path="namBH"/>
        </div>
        <div class="col-6">
            <label>Mo ta</label>
            <sf:input path="moTa" cssClass="form-control"/>
            <sf:errors path="moTa"/>
        </div>

    </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>So luong ton : </label>
                <sf:input path="soLuongTon" type="number" cssClass="form-control"/>
                <sf:errors path="soLuongTon"/>
            </div>
            <div class="col-6">
                <label>Gia Nhap</label>
                <sf:input path="giaNhap" cssClass="form-control"/>
                <sf:errors path="giaNhap"/>
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Gia Ban</label>
                <sf:input path="giaBan" cssClass="form-control"/>
                <sf:errors path="giaBan"/>
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