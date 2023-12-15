package controllers.PostController;

import services.CommentServices;
import services.InteractServices;
import services.PostServices;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/posts/"})
public class ShowPostOfFriend extends HttpServlet {

    private PostServices postServices = new PostServices();
    private UserServices userServices = new UserServices();
    private InteractServices interactServices = new InteractServices();
    private CommentServices commentServices = new CommentServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String UserID = "1";

        var resultNameOfUser = userServices.FetchUserModelByUserID(UserID);
        req.setAttribute("resultUser",resultNameOfUser);

        var listPostOfUser = postServices.GetPostOfUserID(UserID);
        req.setAttribute("listpost",listPostOfUser);
        String getPostIDFormView = req.getParameter("postID");
        req.getRequestDispatcher("/view/User-BangTin.jsp").forward(req,resp);
    }
}
