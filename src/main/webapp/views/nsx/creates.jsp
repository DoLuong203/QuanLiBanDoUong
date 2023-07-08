<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ASM - SPRINGBOOT</title>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="col-8 offset-2">
    <sf:form method="post" action="${action}" modelAttribute="nsx">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã :</label>
                <sf:input path="ma" cssClass="form-control"/>
                <sf:errors path="ma" />
            </div>
            <div class="col-6">
                <label>Tên :</label>
                <sf:input path="ten" cssClass="form-control"/>
                <sf:errors path="ten" />
            </div>
            <div class="col-6"></div>
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