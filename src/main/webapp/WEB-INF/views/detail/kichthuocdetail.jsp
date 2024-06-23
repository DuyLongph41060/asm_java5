<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04/04/2024
  Time: 11:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
<form action="/kich-thuoc/update/${listSP.id}" method="post">
    <div class="mb-3">
        <label class="form-label">ID:</label>
        <input type="text" class="form-control" name="id" readonly value="${listSP.id}" disabled>
    </div>
    <div class="mb-3">
        <label class="form-label">Ma:</label>
        <input type="text" class="form-control" name="ma"  value="${listSP.ma}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten:</label>
        <input type="text" class="form-control" name="ten" value="${listSP.ten}">
    </div>
    <div class="mb-3 row">
        <label class="form-label col-4">Trang thai</label>
        <div class="form-check col-4">
            <input type="radio" class="form-check-input" value="true" name="trangThai"
                   <c:if test="${listSP.trangThai == 'Hoat dong'}">checked</c:if>>
            <label class="form-check-label">
                Hoat dong
            </label>
        </div>
        <div class="form-check col-4">
            <input type="radio" class="form-check-input" value="false" name="trangThai"
                   <c:if test="${listSP.trangThai == 'Khong hoat dong'}">checked</c:if>
            >
            <label class="form-check-label">
                Khong hoat dong
            </label>
        </div>
    </div>
    <a href="/kich-thuoc/hien-thi" class="btn btn-dark">Back</a>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
