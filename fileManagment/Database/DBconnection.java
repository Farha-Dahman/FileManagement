package fileManagment.Database;
import fileManagment.ImportingFiles.TableCreator;

import java.sql.*;


public class DBconnection {

    private static final String LINK_OF_DATABASE = "jdbc:mysql://localhost:3306/fileManagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection= null;
    public static Connection getConnection(){
        try{
            if (connection == null) {
                System.out.println("Wait in synchronized block");
                synchronized (DBconnection.class) {//stop here ...
                    if (connection == null) {// not null
                        Class.forName("com.mysql.jdbc.Driver");
                        connection = DriverManager.getConnection(LINK_OF_DATABASE, USER_NAME, PASSWORD);
                        TableCreator.creatingTableForFilesInfo(connection);
                        System.out.println("Success");
                    }
                }
            }
            return connection;
        }catch (Exception e) {
            System.out.println(e);
            return connection;
        }
    }
    public static void Close(){
        try {
            DBconnection.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}