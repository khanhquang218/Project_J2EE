<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>List of Posts</title>
</head>
<body>
    <h2>List of Posts</h2>

    <c:forEach var="post" items="${posts}">
        <p>
            <a href="${request.contextPath}/view-post?id=${post.postID}">
                <c:out value="${post.content}" />
            </a>
        </p>
    </c:forEach>
</body>
</html>
