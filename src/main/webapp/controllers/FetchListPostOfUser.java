package controllers;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet({"/posts/5"})
public class FetchListPostOfUser extends HttpServlet {
    private PostServices postServices = new PostServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfListPostOfUser = postServices.GetPostOfUserID("5");
        System.out.printf(resultOfListPostOfUser.toString());
        req.setAttribute("resultOfListPostOfUser", resultOfListPostOfUser);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
