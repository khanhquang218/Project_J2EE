package controllers;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/form-post-list"},
        asyncSupported = true
)

public class FormListPost extends HttpServlet {
    private PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        var postList = postServices.GetPostOfUserID("1");

        req.setAttribute("postList", postList);
        req.getRequestDispatcher("views/HomePage.jsp").forward(req, resp);
    }
}
