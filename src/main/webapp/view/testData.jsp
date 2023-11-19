<!-- Trang JSP trống, ví dụ: empty.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empty JSP Page</title>
</head>
<body>
    <%-- Dữ liệu từ servlet sẽ được đổ ở đây --%>
    <div>
        <h1>Data from Servlet:</h1>
        <ul>
            <%-- Sử dụng forEach để lặp qua dữ liệu và hiển thị --%>
            <c:forEach var="post" items="${posts}">
                <li>${post.PostID}</li>
            </c:forEach>

        </ul>
    </div>
</body>
</html>
