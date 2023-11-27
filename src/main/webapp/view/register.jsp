<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <title>Reddit - Đăng ký</title>
</head>
<body>
    <section>
        <form>
            <h1>Register</h1>
            <div class="inputbox">
                <ion-icon name="first-name-outline"></ion-icon>
                <input type="firstname" required>
                <label for="">Tên</label>
            </div>
            <div class="inputbox">
                <ion-icon name="last-name-outline"></ion-icon>
                <input type="lastname" required>
                <label for="">Họ</label>
            </div>
            <div class="inputbox">
                <ion-icon name="mail-outline"></ion-icon>
                <input type="email" required>
                <label for="">Email</label>
            </div>
            <div class="inputbox">
                <ion-icon name="lock-close-outline"></ion-icon>
                <input type="password" required>
                <label for="">Password</label>
            </div>
            <div class="inputbox">
                <ion-icon name="lock-close-outline"></ion-icon>
                <input type="password" required>
                <label for="">Nhập lại Password</label>
            </div>
            <div class="inputbox">
                <ion-icon name="phone-outline"></ion-icon>
                <input type="phone" required>
                <label for="">Nhập Số điện thoại</label>
            </div>
            <div class="inputbox">
                <ion-icon name="birthday-outline"></ion-icon>
                <input type="birthday" required>
                <label for="">Ngày sinh</label>
            </div>
            <div class="inputbox">
                <ion-icon name="gender-outline"></ion-icon>
                <input type="gender" required>
                <label for="">Giới tính</label>
            </div>
            <button>Register</button>
        </form>
    </section>
</body>
</html>