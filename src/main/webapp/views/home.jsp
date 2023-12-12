<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Posts</title>
    <style>
        /* Thêm CSS cho trang hiển thị bài post */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        .post {
            border: 1px solid #ccc;
            margin-bottom: 20px;
            padding: 10px;
        }

        .post img {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>

<h1>Recent Posts</h1>

<%-- Hiển thị danh sách bài post từ request attribute --%>
<%-- Đối với mỗi bài post, hiển thị thông tin của nó --%>
<c:forEach var="post" items="${posts}">
    <div class="post">
        <h2>${post.content}</h2>
        <p>Posted by ${post.userID} on ${post.datePost}</p>
        <%-- Thêm hình ảnh nếu có --%>
        <c:if test="${not empty post.image}">
            <img src="${post.image}" alt="Post Image">
        </c:if>
    </div>
</c:forEach>

</body>
</html>
