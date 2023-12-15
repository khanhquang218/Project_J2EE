<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
            integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
            integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.0/css/all.min.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Mulish:wght@200;500&family=Roboto:wght@100;300;400&family=Ubuntu&display=swap"
            rel="stylesheet">
        <link rel="stylesheet" type="text/css"
            href="${pageContext.request.contextPath}/css/User-BangTin.css" />
        <title>J2EE - Trang Chủ</title>
    </head>
    <body>
        <header>
            <div class="header">
                <ul>
                    <div class="icon-web">
                        <li><a href><i class="fa-brands fa-reddit"></i>Reddit</a></li>
                    </div>
                    <div class="button-home">
                        <li><button><i class="fa-solid fa-house"></i> Home</button></li>
                    </div>
                    <li><input type="Tim Kiem"> <i
                            class="fa-solid fa-magnifying-glass"></i></li>
                    <div class="button-function">
                        <li><button><i class="fa-brands fa-rocketchat"></i></button></li>
                        <li><button><i class="fa-regular fa-bell"></i></button></li>
                        <li><button><i class="fa-solid fa-plus"></i></button></li>
                    </div>
                    <div class="button-user">
                        <li><button><i class="fa-regular fa-user"></i> Tên người
                                dùng</button></li>
                    </div>
                </ul>
            </div>
        </header>
        <!-- Thong tin nguoi dung -->
        <div class="header-user">
            <div class="user-information">
                <ul>
                    <img src="user_avatar.jpg" alt="Avatar">
                </ul>
                <a href>Tên người dùng</a>
                <button>Chỉnh sửa</button>
            </div>
            <div class="main-function">
                <a href>Bài viết</a>
                <a href>Thông tin cá nhân</a>
                <a href>Bạn bè</a>
            </div>
        </div>
         <c:set var="user" value="${resultUser}"/>
                <c:forEach var="post" items="${listpost}">
                    <!-- Bai Post 1 -->
                    <div class="post">
                        <div class="post-header">
                            <div class="post-avatar">
                                <img src="user_avatar.jpg" alt="Ảnh đại diện người dùng">
                            </div>

                            <div class="post-details">
                                <span class="post-author"><p>${user.userAccount}</p></span>
                                <span class="post-time">2 giờ trước</span>
                            </div>
                        </div>
                        <div class="post-content">
                            <p>${post.content}</p>
                        </div>
                        <div class="post-actions">
                            <a href="#" class="post-like"><i
                                    class="fa-regular fa-thumbs-up"></i> Thích</a>
                            <a href="#" class="post-comment"><i
                                    class="fa-regular fa-comment"></i> Bình luận</a>
                        </div>
                        <div class="commentbox">
                            <textarea placeholder="Write a comment..."></textarea>
                        </div>
                    </div>
                </c:forEach>

    </body>
</html>