package controllers.friendshipController;

import services.FriendshipService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/user/deleteFriend/"})
public class DeleteFriend extends HttpServlet {
    private FriendshipService friendshipService = new FriendshipService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfDeleteFriend = friendshipService.DeleteARelationship("1","2");
        System.out.println(resultOfDeleteFriend);
        req.setAttribute("resultOfDeleteFriend",resultOfDeleteFriend);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
