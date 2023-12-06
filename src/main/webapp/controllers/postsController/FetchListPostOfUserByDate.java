package controllers.postsController;

import services.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/posts/date")
public class FetchListPostOfUserByDate extends HttpServlet {
    private PostServices postServices = new PostServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfListPostOfUserByDate = postServices.GetPostOfUserByDate("1",LocalDate.of(1011,1,12));
        System.out.println(resultOfListPostOfUserByDate);
        req.setAttribute("resultOfListPostOfUserByDate",resultOfListPostOfUserByDate);
        req.getRequestDispatcher("view/home.jsp");
    }
}
