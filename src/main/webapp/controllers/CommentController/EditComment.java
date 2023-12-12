package controllers.CommentController;

import services.CommentServices;
import services.PostServices;

import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet({"/comments/update"})
public class EditComment extends HttpServlet {
    private CommentServices commentServices = new CommentServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfEditComment = commentServices.EditCommentModel(1, "Demo update of post", LocalDate.now());
        System.out.println(resultOfEditComment);
        req.setAttribute("resultOfEditComment",resultOfEditComment);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
