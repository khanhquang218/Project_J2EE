package controllers.PostController;

import models.PostModel;
import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/posts/admin/")
public class ListAllPosts extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostServices postServices = new PostServices();
        List<PostModel> posts = postServices.GetAllPosts();
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/view/User-ThongTin.jsp").forward(request, response);
    }
}
