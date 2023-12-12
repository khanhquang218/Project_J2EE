package controllers.CommentController;

import models.CommentModel;
import services.CommentServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/comment/create/")
public class CreateComment extends HttpServlet {
    private CommentServices commentServices = new CommentServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        CommentModel newComment = new CommentModel(2 ,"quatroingu", "2",
                1 , LocalDate.now());
        var resultOfCreateComment = commentServices.CreateComment(newComment);
        System.out.println(resultOfCreateComment);
        req.setAttribute("resultOfCreateComment",resultOfCreateComment);
        req.getRequestDispatcher("/view/CommentPost.jsp");
    }
}
