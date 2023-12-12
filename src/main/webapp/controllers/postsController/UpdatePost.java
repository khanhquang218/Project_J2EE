package controllers.postsController;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet({"/posts/update"})
public class UpdatePost extends HttpServlet {
    private PostServices postServices = new PostServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfUpdatePost = postServices.EditPostModel(1, "Demo update of post","image", LocalDate.now());
        System.out.println(resultOfUpdatePost);
        req.setAttribute("resultOfUpdatePost",resultOfUpdatePost);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
