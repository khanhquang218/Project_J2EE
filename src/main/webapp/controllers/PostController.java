package controllers;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts/")
public class PostController extends HttpServlet {

    private static PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var postList = postServices.FetchListPostOfFriend("1");
        req.setAttribute("postList", postList);
        req.getRequestDispatcher("/views/Home.jsp").forward(req, resp);
    }
}
