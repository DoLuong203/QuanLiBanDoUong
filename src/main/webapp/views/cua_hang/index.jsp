<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - CRUD Cua Hang</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="f" uri="jakarta.tags.functions" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div><a href="create" class="btn btn-primary">Add </a></div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Ma</th>
        <th scope="col">Tên</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">Thành phố</th>
        <th scope="col">Quốc gia</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach   items="${data}" var="ch">
        <tr>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td><a class="btn btn-primary" href="delete/${ch.id}">Delete</a></td>
            <td><a class="btn btn-primary" href="edit/${ch.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>