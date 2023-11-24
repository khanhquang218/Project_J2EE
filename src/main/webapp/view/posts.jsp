<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
</head>
<body>
    <div>
        <h1>All Posts:</h1>
        <ul>
            <c:forEach var="post" items="${posts}">
                <li>
                    <strong>${post.PostID}</strong>
                    <p>${post.Content}</p>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
