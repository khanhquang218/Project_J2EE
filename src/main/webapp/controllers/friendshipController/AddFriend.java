package controllers.friendshipController;

import models.FriendshipModel;
import services.FriendshipService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/user/addFriend/")
public class AddFriend extends HttpServlet {
    private FriendshipService friendshipService = new FriendshipService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        FriendshipModel friendshipModel = new FriendshipModel("1","1","2",
                LocalDate.now(), true);
        var resultOfAddFriend = friendshipService.CreateRelationship(friendshipModel);
        System.out.println(resultOfAddFriend);
        req.setAttribute("resultOfAddFriend",resultOfAddFriend);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
