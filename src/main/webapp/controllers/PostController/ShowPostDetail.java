package controllers.PostController;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/posts/postDetail/"})
public class ShowPostDetail extends HttpServlet {
    private PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfGetPostByPostID = postServices.GetPostByPostID(1);
        req.setAttribute("postDetail",resultOfGetPostByPostID);
        req.getRequestDispatcher("/view/CommentPost.jsp").forward(req,resp);
    }

    protected void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
