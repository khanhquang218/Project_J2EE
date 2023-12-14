package controllers.PostController;

import models.PostModel;
import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet({"/user/newPost/","/user/newPost/add"})
public class AddNewPost extends HttpServlet {
    private PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String url = req.getRequestURI();
        if (url.contains("add")){
            processResponse(req,resp);
        }
        else req.getRequestDispatcher("/view/CreatePost.jsp").forward(req,resp);
    }
    private int generatePostID() {
        // Implement a more robust method for generating unique post IDs.
        return postServices.GetAllPosts().size() + 1;
    }
    protected void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        var postID = generatePostID();
        String content = req.getParameter("text-post");
        LocalDate modifed = LocalDate.now();
        LocalDate lastModifedTime = LocalDate.now();
        LocalDate datePost = LocalDate.now();
        PostModel postModel = new PostModel(postID, "1", "null", content, datePost,
                modifed, lastModifedTime);
        try {
            postServices.CreateNewPost(postModel);
            req.setAttribute("successMessage", "Post created successfully!");
            req.getRequestDispatcher("/view/CreatePost.jsp").forward(req, resp);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
