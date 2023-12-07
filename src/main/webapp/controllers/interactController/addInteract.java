package controllers.interactController;

import models.InteractModel;
import services.InteractServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/interact/create/"})
public class addInteract extends HttpServlet {
    private InteractServices interactServices = new InteractServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        InteractModel newInteract = new InteractModel("1",1,"1");
        var resultOfInteract = interactServices.CreateAInteract(newInteract);
        System.out.println(resultOfInteract );
        req.setAttribute("resultOfInteract",resultOfInteract);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
