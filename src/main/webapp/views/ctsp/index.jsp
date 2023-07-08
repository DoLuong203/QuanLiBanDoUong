<%@ page language="java" pageEncoding="utf-8"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div><a href="create" class="btn btn-primary">Add</a></div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ten SP</th>
        <th scope="col">Tên NSX</th>
        <th scope="col">Ten DSP</th>
        <th scope="col">Ten MS</th>
        <th scope="col">Nam Bao Hanh</th>
        <th scope="col">So luong hang ton</th>
        <th scope="col">Gia Nhap</th>
        <th scope="col">Gia Ban</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSachCTSP}" var="nv">
        <tr>
            <td>${nv.sanPham.ten}</td>
            <td>${nv.nsx.ten}</td>
            <td>${nv.dsp.ten}</td>
            <td>${nv.mauSac.ten}</td>
            <td>${nv.namBH}</td>
            <td>${nv.soLuongTon}</td>
            <td>${nv.giaNhap}</td>
            <td>${nv.giaBan}</td>
            <td><a class="btn btn-primary" href="delete/${nv.id}">Delete</a></td>
            <td><a class="btn btn-primary" href="edit/${nv.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>