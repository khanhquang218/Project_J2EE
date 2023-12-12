<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Post</title>
</head>
<body>
    <h1>Create a New Post</h1>
    <form action="/your-servlet-url" method="post" enctype="multipart/form-data">
        <label for="content">Content:</label>
        <textarea id="content" name="content" rows="4" cols="50"></textarea>
        <br>
        <label for="image">Image:</label>
        <input type="file" id="image" name="image" accept="image/*">
        <br>
        <input type="submit" value="Create Post">
    </form>
</body>
</html>
