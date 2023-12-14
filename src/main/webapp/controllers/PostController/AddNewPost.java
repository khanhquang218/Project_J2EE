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

@WebServlet(name = "add-new-post",urlPatterns = {"/posts/addNewPost/"})
public class AddNewPost extends HttpServlet {
    private PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("/view/CreatePost.jsp").forward(req,resp);
    }
    private int generatePostID() {
        // Implement a more robust method for generating unique post IDs.
        return postServices.GetAllPosts().size() + 1;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        var postID = generatePostID();
        String content = req.getParameter("text-post");
        LocalDate modifed = LocalDate.now();
        LocalDate lastModifedTime = LocalDate.now();
        LocalDate datePost = LocalDate.now();
        PostModel postModel = new PostModel(postID,"1","null",content,datePost,
                modifed,lastModifedTime);
        try {
            postServices.CreateNewPost(postModel);
            resp.sendRedirect(req.getContextPath() +"/posts/");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
