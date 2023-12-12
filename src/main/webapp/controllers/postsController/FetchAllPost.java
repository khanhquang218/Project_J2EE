package controllers.postsController;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/posts/admin/allPost/"})
public class FetchAllPost extends HttpServlet {
    private PostServices postServices = new PostServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfAllPost = postServices.GetAllPosts();
        System.out.printf(resultOfAllPost.toString());
        req.setAttribute("resultOfAllPost",resultOfAllPost);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
