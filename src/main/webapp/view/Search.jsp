<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@200;500&family=Roboto:wght@100;300;400&family=Ubuntu&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Search.css" />
    <title>J2EE - Tim Kiem</title>
</head>
<body>
    <header>
        <div class="header">
            <ul>
                <div class="icon-web">
                    <li><a href=""><i class="fa-brands fa-reddit"></i>Reddit</a></li>
                </div>
                <div class="button-home">
                    <li><button><i class="fa-solid fa-house"></i> Home</button></li>
                </div>
                <li><input type="Tim Kiem"> <i class="fa-solid fa-magnifying-glass"></i></li>
                <div class="button-function">
                    <li><button><i class="fa-brands fa-rocketchat"></i></button></li>
                    <li><button><i class="fa-regular fa-bell"></i></button></li>
                    <li><button><i class="fa-solid fa-plus"></i></button></li>
                </div>
                <div class="button-user">
                    <li><button><i class="fa-regular fa-user"></i> Tên người dùng</button></li>
                </div>
            </ul>
        </div>
    </header>
    
    <div class="search-list">
        <div class="search-list-title">
            <p>Mọi người</p>
        </div>
        <div class="search">
            <img src="user_avatar.jpg" alt="Avatar">
            <a href="">Nguyễn Siêu</a>
            <button>Thêm bạn</button>
        </div>
        <div class="search">
            <img src="user_avatar.jpg" alt="Avatar">
            <a href="">Nguyễn B</a>
            <button>Thêm bạn</button>
        </div>
        <div class="search">
            <img src="user_avatar.jpg" alt="Avatar">
            <a href="">Nguyễn C</a>
            <button>Thêm bạn</button>
        </div>
        <div class="search">
            <img src="user_avatar.jpg" alt="Avatar">
            <a href="">Nguyễn D</a>
            <button>Thêm bạn</button>
        </div>
        <div class="search">
            <img src="user_avatar.jpg" alt="Avatar">
            <a href="">Nguyễn E</a>
            <button>Thêm bạn</button>
        </div>
        <div class="search">
            <img src="user_avatar.jpg" alt="Avatar">
            <a href="">Nguyễn F</a>
            <button>Thêm bạn</button>
        </div>
    </div>

</body>
</html>