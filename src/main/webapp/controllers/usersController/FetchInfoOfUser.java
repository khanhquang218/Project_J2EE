package controllers.usersController;

import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/user/info"})
public class FetchInfoOfUser extends HttpServlet {
    private UserServices userServices = new UserServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfGetInfoUser = userServices.FetchUserModelByUserID("1");
        System.out.println(resultOfGetInfoUser.UserID);
        System.out.println(resultOfGetInfoUser.FirstName);
        System.out.println(resultOfGetInfoUser.LastName);
        System.out.println(resultOfGetInfoUser.Email);
        System.out.println(resultOfGetInfoUser.Phone);
        System.out.println(resultOfGetInfoUser.UserAccount);
        System.out.println(resultOfGetInfoUser.DayOfBirth);
        System.out.println(resultOfGetInfoUser.Gender);
        System.out.println(resultOfGetInfoUser.Address);
        req.setAttribute("resultOfGetInfoUser",resultOfGetInfoUser);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
