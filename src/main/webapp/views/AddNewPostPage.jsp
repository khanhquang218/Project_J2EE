<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head>
    <title>Add Post</title>
  </head>
  <body>
   <h1><td>Add Post</td></h1>
   <form action="/project/form-add-post" method="post">
      <p>User ID: <input type="text" name="userID"></p>
      <p>Image: <input type="text" name="image"></p>
      <p>Content: <input type="text" name="content"></p>
      <button type="submit">Submit</button>
    </form>
   </body>
</html>
