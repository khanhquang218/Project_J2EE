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
          <td><%= postList.getPostID() %></td>
          <td><%= postList.getUserID() %></td>
          <td><%= postList.getImage() %></td>
          <td><%= postList.getContent() %></td>
          <td><%= postList.getDatePost() %></td>
          <td><%= postList.getModified() %></td>
          <td><%= postList.getLastModifiedTime() %></td>
        </tr>
      </c:forEach>

    </table>
  </body>
</html>
