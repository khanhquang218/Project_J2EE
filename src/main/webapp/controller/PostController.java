package controller;

import Service.PostService;
import model.PostModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/posts"})
public class PostController extends HttpServlet {
    private final PostService postService = new PostService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List< PostModel> postModelList = postService.GetAllPost();
        request.setAttribute("postlist", postModelList);
        request.getRequestDispatcher("/view/posts.jsp").forward(request,response);
    }
}
