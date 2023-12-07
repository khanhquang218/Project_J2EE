package controllers.usersController;

import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/admin/allUser/")
public class FetchAllUser extends HttpServlet {
    private UserServices userServices = new UserServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfAllUser = userServices.GetAllUsers();
        System.out.println(resultOfAllUser);
        req.setAttribute("resultOfAllUser",resultOfAllUser);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
