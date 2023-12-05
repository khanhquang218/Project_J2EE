package controllers;

import models.PostModel;
import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(value = {"/posts/create"})
public class AddNewPost extends HttpServlet {
    private PostServices postServices = new PostServices();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        PostModel newPost = new PostModel(2,"1", "image",
                "demo code create of posts", LocalDate.now(),LocalDate.now(), LocalDate.now());
        var resultOfCreatePost = postServices.CreateNewPost(newPost);
        System.out.println(resultOfCreatePost);
        req.setAttribute("resultOfCreatePost",resultOfCreatePost);
        req.getRequestDispatcher("/view/home.jsp");
    }
}