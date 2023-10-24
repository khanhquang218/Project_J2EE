package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet({"/lab3/search", "/"})
public class CustomerController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("name").equalsIgnoreCase("") || request.getParameter("phone").equalsIgnoreCase("") || request.getParameter("address").equalsIgnoreCase("")){
            response.sendError(422, "Empty Value");
            return;
        }
        String name = request.getParameter("name");
        String sql = String.format("Select * from customer where TenThueBao like '%%%s%%'", name);
        String connString = "jdbc:mysql://localhost:3306/qldienthoai";
        List<HashMap<String, String>> customers = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connString, "root", "123456");
            Statement stmt = conn.createStatement();
            ResultSet rt = stmt.executeQuery(sql);
            ResultSetMetaData rd = rt.getMetaData();
            while (rt.next()) {
                HashMap<String, String> map = new HashMap<>();
                for(int i = 1;i <= rd.getColumnCount();i++){
                    map.put(rd.getColumnName(i), rt.getString(i));
                }
                customers.add(map);
                System.out.println(rt.getString(1));
            }
            request.setAttribute("customers", customers);
        } catch(SQLException exception) {
            System.out.println("My exception: " + exception);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/view/result.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("search")){
            processRequest(req, resp);
        } else {
            req.getRequestDispatcher("/view/form.jsp").forward(req, resp);
        }
    }
}
