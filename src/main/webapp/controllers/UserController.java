package controllers;

import models.UserModel;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/user"})
public class UserController extends HttpServlet {
    private final UserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Test GetAllUser
        List<UserModel> userModelList = userServices.GetAllUsers();
        req.setAttribute("userList", userModelList);
        req.getRequestDispatcher("/view/home.jsp");
//        Test FetchUserModelByUserID
        UserModel userModel = userServices.FetchUserModelByUserID("1");
        req.setAttribute("userList", userModel);
        req.getRequestDispatcher("/view/home.jsp");
//        Test FecthUserName
    }
}
