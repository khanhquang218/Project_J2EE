package controllers;

import models.PostModel;
import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/"})
public class PostController extends HttpServlet {
    private final PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        List<PostModel> postModelList = postServices.GetAllPosts();
//        req.setAttribute("postList", postModelList);
//        req.getRequestDispatcher("/view/home.jsp");
        PostModel postModel = postServices.FecthPostModel("1");
        req.setAttribute("postList", postModel);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
