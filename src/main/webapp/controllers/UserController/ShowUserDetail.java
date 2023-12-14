package controllers.UserController;

import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/userDetail")
public class ShowUserDetail extends HttpServlet {
    private UserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String UserId = req.getParameter("userID");
        try {
            var resultOfUserDetail = userServices.FetchUserModelByUserID("1");
            req.setAttribute("userDetail",resultOfUserDetail);
            req.getRequestDispatcher("/view/User-ThongTin.jsp").forward(req, resp);
        }catch (Exception exception){
            exception.printStackTrace();
            req.getRequestDispatcher("/view/SearchFailed.jsp").forward(req,resp);
        }
    }
}
