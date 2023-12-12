<%@ page import="model.PostRequestModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@200;500&family=Roboto:wght@100;300;400&family=Ubuntu&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CommentPost.css">
    <title>J2EE - Trang Chủ</title>
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

    <div class="post">
        <div class="post-header">
            <div class="post-avatar">
                <img src="user_avatar.jpg" alt="Ảnh đại diện người dùng">
            </div>
            <div class="post-details">
                <span class="post-author">Tên người đăng</span>
                <span class="post-time">2 giờ trước</span>
            </div>
        </div>
        
        <div class="post-content">
            <p>I've been in vietnam for over 2 weeks now and I've been really depressed about the racism I'm facing here. To give some context, I'm chinese and indian, quite dark skinned, female.

                The counts of racism I've faced here is absolutely disheartening, maybe because of my background, I tend to notice the implicates of it. Other - I've been really well behaved, trying to break the misconceptions about my countrie(s) not because I deliberately want to, but because that's how I am. I'm introverted, am always polite, tip well, do not indulge in the bad stuff.</p>
        </div>

        <div class="post-actions">
            <a href="#" class="post-like">Thích</a>
            <a href="#" class="post-comment">Bình luận</a>
        </div>

        <div class="commentbox">
            <textarea placeholder="Write a comment..."></textarea>
        </div>

        <div class="user-comment">
            <div class="user-avatar-comment">
                <img src="user_avatar_jpg" alt="Ảnh đại diện ng dùng">
            </div>
            <div class="comment-details">
                <span class="post-author">Tên người đăng</span>
                <span class="post-time">3 giờ trước</span>
            </div>
            <div class="comment_content">
                <p>I'm a Vietnamese girl who loved summer a bit too much, so, as a result, my skin got darker. I'm fine with it, just a bit limited options when it comes to choosing clothes. But one day, my coworkers, my dear coworkers, who often discriminated my background as well (we have the North - South thingy here) said loud enough for me to hear that dark skinned girls look like they hadn't taken shower for months.</p>
            </div>
        </div>

        <div class="user-comment">
            <div class="user-avatar-comment">
                <img src="user_avatar_jpg" alt="Ảnh đại diện ng dùng">
            </div>

            <div class="comment-details">
                <span class="post-author">Tên người đăng</span>
                <span class="post-time">3 giờ trước</span>
            </div>

            <div class="comment_content">
                <p>I'm a Vietnamese girl who loved summer a bit too much, so, as a result, my skin got darker. I'm fine with it, just a bit limited options when it comes to choosing clothes. But one day, my coworkers, my dear coworkers, who often discriminated my background as well (we have the North - South thingy here) said loud enough for me to hear that dark skinned girls look like they hadn't taken shower for months.</p>
            </div>
        </div>
    </div>
</body>
</html>