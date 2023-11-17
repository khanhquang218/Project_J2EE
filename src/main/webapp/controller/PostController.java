package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet({"/posts"})
public class PostController extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/j2ee";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<HashMap<String, String>> posts = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM post");

            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                HashMap<String, String> postMap = new HashMap<>();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    postMap.put(metaData.getColumnName(i), resultSet.getString(i));
                }

                posts.add(postMap);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("posts", posts);
        // Chuyển hướng yêu cầu đến trang JSP để hiển thị danh sách bài đăng
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO posts (title, content) VALUES (?, ?)");
            statement.setString(1, title);
            statement.setString(2, content);

            int rowsAffected = statement.executeUpdate();

            // Xử lý kết quả thêm bài đăng

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/posts");
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String postId = request.getParameter("postId");
        String newTitle = request.getParameter("newTitle");
        String newContent = request.getParameter("newContent");

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("UPDATE posts SET title = ?, content = ? WHERE id = ?");
            statement.setString(1, newTitle);
            statement.setString(2, newContent);
            statement.setInt(3, Integer.parseInt(postId));

            int rowsAffected = statement.executeUpdate();

            // Xử lý kết quả cập nhật bài đăng

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/posts");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String postId = request.getParameter("postId");

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM posts WHERE id = ?");
            statement.setInt(1, Integer.parseInt(postId));

            int rowsAffected = statement.executeUpdate();

            // Xử lý kết quả xóa bài đăng

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/posts");
    }
}
