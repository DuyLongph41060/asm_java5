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
<body class="container" style="margin-top: 50px">
<div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
    <div class="col-sm-12">
        <h3>Login</h3>
        <form action="/login/checkLogin" method="post">
            <div class="form-group">
                <label>UserName</label>
                <input type="text" class="form-control" name="tendangnhap" placeholder="Enter UserName">
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input type="password" class="form-control" name="matkhau" placeholder="Enter password">
            </div>
            <div class="checkbox">
                <label><input type="checkbox"> Remember me</label>
            </div>
            <div class="text-danger">
                <c:if test="${not empty errors}">
                    ${errors}
                </c:if>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
</div>
</body>
</html>