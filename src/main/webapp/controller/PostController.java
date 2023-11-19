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
        if (uri.contains("/createpost")){
            proccessDoPost(request,response);
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
    protected void proccessDoPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String PostID = request.getParameter("PostID");
        String UserID = request.getParameter("UserID");
        String Image = request.getParameter("Image");
        String Content = request.getParameter("Content");
        String DatePost = request.getParameter("DatePost");
        String Modifed = request.getParameter("Modifed");
        String LastModifedTime = request.getParameter("LastModifedTime");
        String query = "INSERT INTO post(PostID, UserID, Image, Content, DatePost, Modifed, LastModifedTime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        if (UserID != null && Content != null){
            try (Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, PostID);
                preparedStatement.setString(2, UserID);
                preparedStatement.setString(3, Image);
                preparedStatement.setString(4, Content);
                preparedStatement.setString(5, DatePost);
                preparedStatement.setString(6, Modifed);
                preparedStatement.setString(7, LastModifedTime);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect(request.getContextPath()+ "/posts");
        }
    }
}
