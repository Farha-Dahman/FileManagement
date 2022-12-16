package fileManagment;
import java.sql.*;


public class DBconnection {

    private static final String LINK_OF_DATABASE = "jdbc:mysql://localhost:3306/fileManagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    public void DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(LINK_OF_DATABASE,USER_NAME,PASSWORD);
            if(connection!=null){
                System.out.println("Success");}
            }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
        }
    }
}
