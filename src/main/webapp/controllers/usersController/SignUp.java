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

@WebServlet({"/user/add"})
public class SignUp extends HttpServlet {
    private UserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        UserModel newUser = new UserModel("6","1", "image",
                "demo code create of posts", "123","adadas", "aa", LocalDate.now(),"adc","ada");
        var resultOfCreateUser = userServices.CreateAccount(newUser);
        System.out.println(resultOfCreateUser);
        req.setAttribute("resultOfCreateUser",resultOfCreateUser);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
