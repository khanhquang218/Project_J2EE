package controllers.ImageController;

import models.ImagesModel;
import services.ImageServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@WebServlet({"/image","/image/addImage"})
public class AddImage extends HttpServlet {
    private ImageServices imageServices  = new ImageServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("").forward(req,resp);
    }

    //lấy đường dẫn
    //tách tên file ảnh khỏi đường đẫn
    //lưu ảnh vào database và
    protected void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        //nơi lưu
        String userID = req.getParameter("");
        String uploadPath = String.format("/images/%s",userID);
        //tạo forder nếu chưa tồn tại
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        //xử lý yêu cầu từ http request
        Part filePart = req.getPart("image");
        String fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName();
        String filePath = uploadPath + File.separator + fileName;

        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        ImagesModel newImage = new ImagesModel("15","demo create of image on view",filePath,userID);
        try{
            imageServices.CreateImage(newImage);
            req.setAttribute("message","Compile");
            req.getRequestDispatcher("/view/").forward(req,resp);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
