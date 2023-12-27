package controllers;


import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        value = {"/posts"},
        asyncSupported = true
)
public class PostListServlet extends HttpServlet {
    private static PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.getWriter().println("PostListController");
        var postList = postServices.GetPostOfUserID("1");
        req.setAttribute("postList", postList);
        req.getRequestDispatcher("/views/Home.jsp").forward(req, resp);
    }
}
