package controllers.usersController;

import models.UserModel;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/dangnhap"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String inputUserAccount = request.getParameter("inputUserAccount");
        String inputPass = request.getParameter("inputPass");
        UserServices userServices = new UserServices();
        UserModel userModel = userServices.login(inputUserAccount, inputPass);
        request.getRequestDispatcher("/view/login.jsp");
    }
}
