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
        urlPatterns = {"/form-add-post"},
        asyncSupported = true
)

public class AddPost extends HttpServlet {
    private PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("views/AddNewPostPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        var postID = PostOfLength();
        while (postServices.CheckPostIsExists(postID)){
            postID++;
        }
        var userID = req.getParameter("userID");
        var content = req.getParameter("content");
        var image = req.getParameter("image");
        PostModel newPostModel = new PostModel(postID, userID, content, image, LocalDate.now(),LocalDate.now(),LocalDate.now());
        var resultOfCreate = postServices.CreateNewPost(newPostModel);
        if(resultOfCreate){
            req.getRequestDispatcher("views/Home.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("views/Home.jsp").forward(req, resp);
    }
    private int PostOfLength(){
        return postServices.GetAllPosts().size();
    }
}
