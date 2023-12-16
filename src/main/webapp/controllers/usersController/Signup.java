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

@WebServlet({"/user/newAccount/","/user/newAccount/add"})
public class Signup extends HttpServlet {
    private UserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("add")){
            processResponse(req,resp);
        }
        else req.getRequestDispatcher("/view/register.jsp").forward(req,resp);
    }
    protected void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String userID = req.getParameter("");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String pass = req.getParameter("pass");
        LocalDate dateofbirth = LocalDate.now();
        String gender = req.getParameter("gender");
        UserModel userModel = new UserModel(userID, firstname, lastname, email, phone,
                "null", pass, dateofbirth, gender,"null");
        try {
            userServices.CreateAccount(userModel);
            req.setAttribute("successMessage", "Post created successfully!");
            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
