package controllers.postsController;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/posts/delete"})
public class DeletePost extends HttpServlet {
    private PostServices postServices = new PostServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfDeletePost = postServices.DeletePostModel(2);
        System.out.printf(String.valueOf(resultOfDeletePost));
        req.setAttribute("resultOfDeletePost",resultOfDeletePost);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
