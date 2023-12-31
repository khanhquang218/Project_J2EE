package controllers.usersController;

import models.UserModel;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet({"/user/login"})
public class Login extends HttpServlet {
    private UserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String userAccount = "sieuda";
        String pass = "456";
        var resultOfLogin = userServices.login(userAccount, pass);
        System.out.println(resultOfLogin);
        req.setAttribute("resultOfLogin",resultOfLogin);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
