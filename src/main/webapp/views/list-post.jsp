<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Posts</title>
</head>
<body>
    <h2>List of Posts</h2>
    <c:forEach var="post" items="${posts}">
        <p><a href="${request.contextPath}/view-post?id=${post.postID}">${post.content}</a></p>
    </c:forEach>
</body>
</html>
