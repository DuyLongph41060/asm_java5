<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark justify-content-center shadow">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link text-light" href="/san-pham/hien-thi">San Pham |</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="/kich-thuoc/hien-thi">Kich Thuoc |</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="/mau-sac/hien-thi">Mau Sac |</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="/nhan-vien/hien-thi">Nhan Vien |</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="/khach-hang/hien-thi">Khach Hang |</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="/spct/hien-thi">San Pham Chi Tiet |</a>
        </li>
        <c:if test="${sessionScope.chucvu == 'admin'}">
            <li class="nav-item">
                <a class="nav-link text-light" href="/hoa-don/hien-thi">Hoa Don |</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="/hdct/hien-thi">Hoa Don Chi Tiet|</a>
            </li>
        </c:if>
    </ul>
</nav>
<h1>QL SAN PHAM CHI TIET</h1>
<br>
<form action="/spct/search" method="get" class="d-flex mb-3 container">
    <input type="text" name="ma" class="form-control me-2"
           placeholder="Moi nhap ma" required>
    <button type="submit" class="btn btn-primary">Search</button>
</form>
<div class="container">
    <form:form modelAttribute="sp" method="post" action="/spct/add">
        ID: <form:input class="form-control" path="id" />
        <form:errors path="id"/>
        <br>
        Ma: <form:input class="form-control" path="ma" />
        <form:errors path="ma"/>
        <br>
        Mau Sac: <form:select class="form-select" path="mausac.id">
                    <form:options items="${mausac}" itemValue="id" itemLabel="ten"></form:options>
                 </form:select>
        <br>
        Kich Thuoc: <form:select class="form-select" path="kichthuoc.id">
                    <form:options items="${kichthuoc}" itemValue="id" itemLabel="ten"></form:options>
                 </form:select>
        <br>
        San Pham: <form:select class="form-select" path="sanpham.id">
                    <form:options items="${sanpham}" itemValue="id" itemLabel="ten"></form:options>
                 </form:select>
        <br>
        So luong: <form:input class="form-control" path="soluong" />
        <form:errors path="soluong"/>
        <br>
        Don Gia: <form:input class="form-control" path="dongia" />
        <form:errors path="dongia"/>
        <br>
        Trang Thai: <form:radiobutton path="trangThai" value="true"/>Hoat dong
        <form:radiobutton path="trangThai" value="false"/>Khong hoat dong
        <form:errors path="trangThai"/>
        <br>
        <form:button class="btn btn-primary" type="submit">ADD</form:button>
    </form:form>

    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Ma</th>
            <th>Mau Sac</th>
            <th>Kich Thuoc</th>
            <th>Ten San Pham</th>
            <th>So Luong</th>
            <th>Don Gia</th>
            <th>Trang thai</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="sp">
            <tr>
                <td>${sp.id}</td>
                <td>${sp.ma}</td>
                <td>${sp.kichthuoc.ten}</td>
                <td>${sp.mausac.ten}</td>
                <td>${sp.sanpham.ten}</td>
                <td>${sp.soluong}</td>
                <td>${sp.dongia}</td>
                <td>${sp.trangThai?"Hoat dong":"Khong hoat dong"}</td>
                <td>
                    <a href="/spct/delete/${sp.id}" class="btn btn-dark">Delete</a>
                    <a href="/spct/detail/${sp.id}" class="btn btn-warning">Detail</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">First</a></li>
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
        <li class="page-item"><a class="page-link" href="#">Last</a></li>
    </ul>
</div>
</body>
</html>