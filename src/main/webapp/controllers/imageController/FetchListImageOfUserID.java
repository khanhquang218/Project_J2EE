package controllers.imageController;

import services.ImageServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/image/user/"})
public class FetchListImageOfUserID extends HttpServlet {
    private ImageServices imageServices = new ImageServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfListImageOfUser = imageServices.GetAllImageOfUser("1");
        System.out.printf(resultOfListImageOfUser.toString());
        req.setAttribute("resultOfGetAllImage",resultOfListImageOfUser);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
