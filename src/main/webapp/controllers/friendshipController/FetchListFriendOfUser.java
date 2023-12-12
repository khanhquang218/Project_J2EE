package controllers.friendshipController;

import services.FriendshipService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/user/listFriend/"})
public class FetchListFriendOfUser extends HttpServlet {
    private FriendshipService friendshipService = new FriendshipService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfGetListFriendOfUser = friendshipService.GetAllFriendShipOfUser("1");
        System.out.printf(resultOfGetListFriendOfUser.toString());
        req.setAttribute("resultOfGetListFriendOfUser",resultOfGetListFriendOfUser);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
