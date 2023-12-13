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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CreatePost.css" />
    <title>J2EE - Tạo Bài Post</title>
</head>
<body>
    <header>
        <li><i class="fa-brands fa-reddit"></i><a href="">Reddit</a></li>
        <li><button><i class="fa-solid fa-house"></i></button></li>
        <li><input type="Tim Kiem"> <i class="fa-solid fa-magnifying-glass"></i></li>
        <li><button><i class="fa-brands fa-rocketchat"></i></button></li>
        <li><button><i class="fa-regular fa-bell"></i></button></li>
        <li><button><i class="fa-solid fa-plus"></i></button></li>
        <li><button><i class="fa-regular fa-user"></i></button></li>
    </header>
    <div class="reddit-post-form">
      <ul>
        <div class="PostButton">
          <p><i class="fas fa-bars"></i> Post</p>
        </div>
        
        <div class="PostButton">
          <p><i class="fas fa-image"></i> Image & Video</p>
        </div>
        
        <div class="PostButton">
          <p><i class="fas fa-link"></i> Link</p>
        </div>

        <div class="PostText">
          <ion-icon name="Text-outline"></ion-icon>
          <textarea id="text-post" placeholder="Enter text post"></textarea>
        </div>
        
        <div class="PostFunctionButton">
          <button class="upload-btn">Upload</button>
          <button class="cancel-btn">Cancel</button>
          <button class="post-btn">Post</button>
        </div>
        
      </ul>
    </div>
</body>
</html>