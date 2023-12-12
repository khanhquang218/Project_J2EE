package services;

public class Configura {
    public final String JDBC_URL;
    public final String JDBC_USER;
    public final String JDBC_PASSWORD;
    public  Configura (){
        JDBC_URL = "jdbc:mysql://localhost:3306/j2ee";
        JDBC_USER = "root";
        JDBC_PASSWORD = "123456";
    }
    public static void CheckDrive(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassCastException exception){
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}