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
        <th scope="col">Thành Phố</th>
        <th scope="col">Ngay Sinh</th>
        <th scope="col">Quốc Gia</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSachKH}" var="kh">
    <tr>
        <td>${kh.ma}</td>
        <td>${kh.ten}</td>
        <td>${kh.diaChi}</td>
        <td>${kh.thanhPho}</td>
        <td>${kh.ngaySinh}</td>
        <td>${kh.quocGia}</td>
        <td><a class="btn btn-primary" href="delete/${kh.id}">Delete</a></td>
        <td><a class="btn btn-primary" href="edit/${kh.id}">Edit</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>