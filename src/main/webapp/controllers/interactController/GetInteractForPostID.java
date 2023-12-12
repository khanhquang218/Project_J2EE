package controllers.interactController;

import services.InteractServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/posts/interact/"})
public class GetInteractForPostID extends HttpServlet {
    private InteractServices interactServices = new InteractServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        var resutlOfInteractOfPost = interactServices.GetAllInteractOfPost(1);
        System.out.println(resutlOfInteractOfPost);
        req.setAttribute("resutlOfInteractOfPost",resutlOfInteractOfPost);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
