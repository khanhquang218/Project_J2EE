package controllers.CommentController;

import services.CommentServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/comment/delete"})
public class DeleteComment extends HttpServlet {
    private CommentServices commentServices = new CommentServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfDeleteComment = commentServices.DeleteComment(1, "1");
        System.out.printf(String.valueOf(resultOfDeleteComment));
        req.setAttribute("resultOfDeleteComment",resultOfDeleteComment);
        req.getRequestDispatcher("/view/CommentPost.jsp");
    }
}
