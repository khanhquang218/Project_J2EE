package controllers.postsController;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts/")
public class FetchListPostOfFriend extends HttpServlet {
    private PostServices postServices = new PostServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfListPostOfFriend = postServices.FetchListPostOfFriend("1");
        System.out.printf(resultOfListPostOfFriend.toString());
        req.setAttribute("resultOfListPostOfFriend",resultOfListPostOfFriend);
    }
}
