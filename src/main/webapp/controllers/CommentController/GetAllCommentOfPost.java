package controllers.CommentController;

import services.CommentServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/comments/"})
public class GetAllCommentOfPost extends HttpServlet {
    private CommentServices commentServices = new CommentServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfCommentOfPost = commentServices.GetAllCommentOfPost(1);
        System.out.println(resultOfCommentOfPost);
        req.setAttribute("resultOfCommentOfPost",resultOfCommentOfPost);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
