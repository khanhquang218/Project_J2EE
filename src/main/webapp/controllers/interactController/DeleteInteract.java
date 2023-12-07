package controllers.interactController;

import services.InteractServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts/interact/delete/")
public class DeleteInteract extends HttpServlet {
    private InteractServices interactServices = new InteractServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resultOfListInteractOfPost = interactServices.DeleteAInteract(1,"1");
        System.out.println(resultOfListInteractOfPost);
        req.setAttribute("resultOfListInteractOfPost",resultOfListInteractOfPost);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
