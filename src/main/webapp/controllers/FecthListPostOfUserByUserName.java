package controllers;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts/user/")
public class FecthListPostOfUserByUserName extends HttpServlet {
    private  PostServices postServices = new PostServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfListPostOfUserByUserName = postServices.GetPostsByUserName("aaaa");
        System.out.println(resultOfListPostOfUserByUserName);
        req.setAttribute("resultOfPostOfUserByUserName",resultOfListPostOfUserByUserName);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
