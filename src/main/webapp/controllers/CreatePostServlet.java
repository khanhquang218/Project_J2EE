package controllers;

import models.PostModel;
import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(
        {"/createPost/add"}
)

public class CreatePostServlet extends HttpServlet {
    private static final PostServices postServices = new PostServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        req.getRequestDispatcher("createPost.jsp").forward(req, resp);
    }
    private static final int GeneratePostID(){
        return postServices.GetAllPosts().size();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        var postId = GeneratePostID();
        String userId = req.getParameter("userId");
        String image = req.getParameter("image");
        String content = req.getParameter("content");
        LocalDate datePost = LocalDate.now();
        LocalDate modified = LocalDate.now();
        LocalDate lastModifedTime = LocalDate.now();

        PostModel newpost = new PostModel(postId,userId,image,content,datePost, modified, lastModifedTime);
        var result = postServices.CreateNewPost(newpost);
        if(!result){
            req.getRequestDispatcher("/views/Home.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/views/Home.jsp").forward(req, resp);
    }
}
