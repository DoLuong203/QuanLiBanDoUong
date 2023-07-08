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
        <th scope="col">Ma</th>
        <th scope="col">Tên</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">SĐT</th>
        <th scope="col">Ngay Sinh</th>
        <th scope="col">Giới Tính</th>
        <th scope="col">Chức vụ</th>
        <th scope="col">Của hàng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSachNV}" var="nv">
        <tr>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.chucVu.ten}</td>
            <td>${nv.cuaHang.ten}</td>
            <td><a class="btn btn-primary" href="delete/${nv.id}">Delete</a></td>
            <td><a class="btn btn-primary" href="edit/${nv.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>