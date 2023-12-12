package controllers.usersController;

import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/user/username/"})
public class FetchListUserByUserName extends HttpServlet {
    UserServices userServices = new UserServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfListUserByUserName = userServices.FetchUserModelByUserName("aaaa");
        System.out.println(resultOfListUserByUserName);
        req.setAttribute("resultOfListUserByUserName",resultOfListUserByUserName);
        req.getRequestDispatcher("/view/hoome.jsp");
    }
}
