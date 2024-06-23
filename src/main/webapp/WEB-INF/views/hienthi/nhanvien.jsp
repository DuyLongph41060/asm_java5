<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<h1>QL NHAN VIEN</h1>
<br>
<form action="/nhan-vien/search" method="get" class="d-flex mb-3 container">
    <input type="text" name="ten" class="form-control me-2"
           placeholder="Moi nhap ten" required>
    <button type="submit" class="btn btn-primary">Search</button>
</form>
<div class="container">
    <form:form modelAttribute="sp" method="post" action="/nhan-vien/add">
        ID: <form:input class="form-control" path="id" />
        <form:errors path="id"/>
        <br>
        Ten: <form:input class="form-control" path="ten"/>
        <form:errors path="ten"/>
        <br>
        Ma: <form:input class="form-control" path="ma" />
        <form:errors path="ma"/>
        <br>
        Ten Dang Nhap: <form:input class="form-control" path="tendangnhap" />
        <form:errors path="tendangnhap"/>
        <br>
        Mat Khau: <form:input cssStyle="password" class="form-control" path="matkhau" />
        <form:errors path="matkhau"/>
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
            <th>Ten</th>
            <th>Ma</th>
            <th>Ten Dang Nhap</th>
            <th>Mat Khau</th>
            <th>Trang thai</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="sp">
            <tr>
                <td>${sp.id}</td>
                <td>${sp.ten}</td>
                <td>${sp.ma}</td>
                <td>${sp.tendangnhap}</td>
                <td>${sp.matkhau}</td>
                <td>${sp.trangThai?"Hoat dong":"Khong hoat dong"}</td>
                <td>
                    <a href="/nhan-vien/delete/${sp.id}" class="btn btn-dark">Delete</a>
                    <a href="/nhan-vien/detail/${sp.id}" class="btn btn-warning">Detail</a>
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