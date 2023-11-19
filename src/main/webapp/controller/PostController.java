package controller;

import model.PostRequestModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet({"/posts","/"})
public class PostController extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/j2ee";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uri = request.getRequestURI();
        if (uri.contains("/")){
            processDoGet(request,response);
        }
    }
    protected void processDoGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String query = "SELECT * FROM post";
        ArrayList<PostRequestModel> posts = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet  resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                PostRequestModel post = new PostRequestModel(
                        resultSet.getString("PostID"),
                        resultSet.getString("UserID"),
                        resultSet.getString("Image"),
                        resultSet.getString("Content"),
                        resultSet.getDate("DatePost").toLocalDate(),
                        resultSet.getDate("Modifed").toLocalDate(),
                        resultSet.getDate("LastModifedTime").toLocalDate()
                );
                System.out.println("PostID: " + resultSet.getString("PostID"));
                posts.add(post);
            }
            request.setAttribute("posts", posts);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/view/testData.jsp").forward(request,response);
    }
}
