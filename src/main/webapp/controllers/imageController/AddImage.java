package controllers.imageController;

import models.ImagesModel;
import services.ImageServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/image/user/addImage/"})
public class AddImage extends HttpServlet {
    ImageServices imageServices = new ImageServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        ImagesModel newImage = new ImagesModel("2","demo image 2","image","1");
        var resultOfAddImage = imageServices.CreateImage(newImage);
        System.out.println(resultOfAddImage);
        req.setAttribute("resultOfAddImage",resultOfAddImage);
        req.getRequestDispatcher("/view/home.jsp");
    }
}
