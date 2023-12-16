<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css" />
    <title>Reddit - Đăng ký</title>
</head>
<body>
    <section>
        <form action="${pageContext.request.contextPath}/user/newAccount/add" method="get">
            <h1>Register</h1>
            <div class="inputbox">
                <ion-icon name="first-name-outline"></ion-icon>
                <input name="firstname" type="firstname" required>
                <label for="">Tên</label>
            </div>
            <div class="inputbox">
                <ion-icon name="last-name-outline"></ion-icon>
                <input name="lastname" type="lastname" required>
                <label for="">Họ</label>
            </div>
            <div class="inputbox">
                <ion-icon name="mail-outline"></ion-icon>
                <input name="email" type="email" required>
                <label for="">Email</label>
            </div>
            <div class="inputbox">
                <ion-icon name="lock-close-outline"></ion-icon>
                <input name="pass" type="password" required>
                <label for="">Password</label>
            </div>
            <div class="inputbox">
                <ion-icon name="lock-close-outline"></ion-icon>
                <input name="rePass" type="password" required>
                <label for="">Nhập lại Password</label>
            </div>
            <div class="inputbox">
                <ion-icon name="phone-outline"></ion-icon>
                <input name="phone" type="phone" required>
                <label for="">Nhập Số điện thoại</label>
            </div>
            <div class="inputbox">
                <ion-icon name="birthday-outline"></ion-icon>
                <input name="birthday" type="birthday" required>
                <label for="">Ngày sinh</label>
            </div>
            <div class="inputbox">
                <ion-icon name="gender-outline"></ion-icon>
                <input name="gender" type="gender" required>
                <label for="">Giới tính</label>
            </div>
            <button>Register</button>
        </form>
    </section>
</body>
</html>