package controllers;

import models.PostModel;
import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/"})
public class PostController extends HttpServlet {
    private final PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PostModel> postModelList = postServices.GetAllPosts();
        req.setAttribute("postList", postModelList);
        req.getRequestDispatcher("/view/home.jsp");
//        Test GetAllPosts
//        List<PostModel> postModelList = postServices.GetAllPosts();
//        req.setAttribute("postList", postModelList);
//        req.getRequestDispatcher("/view/home.jsp");
//        Test FecthPostModel
//        List<PostModel> postModelList = postServices.GetPostOfFriend("1");
//        req.setAttribute("postList", postModelList);
//        req.getRequestDispatcher("/view/home.jsp");
//        Test GetPostOfFriend

//        PostModel newPost = new PostModel("2", "1", "a", "a", LocalDate.now(), LocalDate.now(), LocalDate.now());
//        postServices.CreateNewPost(newPost);

//        Test CraeteNewPost
    }
}
