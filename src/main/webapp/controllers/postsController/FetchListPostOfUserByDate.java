package controllers.postsController;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet({"/posts/user/date/"})
public class FetchListPostOfUserByDate extends HttpServlet {
    private PostServices postServices = new PostServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resulrOfListPostOfUserByDate = postServices.FetchListPostOfUserByDate("1", LocalDate.of(2020,1,10));
        System.out.println(resulrOfListPostOfUserByDate);
        req.setAttribute("resulrOfListPostOfUserByDate",resulrOfListPostOfUserByDate);
    }
}
