<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head>
    <title>Post Details</title>
  </head>
  <body>
    <h2>Post Details</h2>
    <table border="1">
      <tr>
        <th>Post ID</th>
        <th>User ID</th>
        <th>Image</th>
        <th>Content</th>
        <th>Date Post</th>
        <th>Modified</th>
        <th>Last Modified Time</th>
      </tr>
      <c:forEach items="${postList}" var="postList">
        <tr>
          <td>${postList.postID}</td>
          <td>${postList.userID}</td>
          <td>${postList.image}</td>
          <td>${postList.content}</td>
          <td>${postList.datePost}</td>
          <td>${postList.modified}</td>
          <td>${postList.lastModifiedTime}</td>
        </tr>
      </c:forEach>

    </table>
  </body>
</html>
