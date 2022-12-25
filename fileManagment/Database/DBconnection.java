package fileManagment.Database;
import fileManagment.ImportingFiles.TableCreator;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.*;

public class DBconnection {
    private static Logger logger = Logger.getLogger(Main.class);
    private static final String LINK_OF_DATABASE = "jdbc:mysql://localhost:3306/fileManagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection= null;
    public static Connection getConnection(){
        logger.info("Inside the connection function");
        try{
            if (connection == null) {
                logger.info("Wait in synchronized");
                System.out.println("Wait in synchronized block");
                synchronized (DBconnection.class) {//stop here ...
                    if (connection == null) {// not null
                        Class.forName("com.mysql.jdbc.Driver");
                        connection = DriverManager.getConnection(LINK_OF_DATABASE, USER_NAME, PASSWORD);
                        logger.info("Created connection");
                        TableCreator.creatingTableForFilesInfo(connection);
                        System.out.println("Success");
                        logger.info("connected Successfully");
                    }
                }
            }
            return connection;
        }catch (Exception e) {
            logger.info("Exception!");
            System.out.println(e.getMessage());
            return connection;
        }
    }
    public static void Close(){
        logger.info("Closed the connection");
        try {
            DBconnection.getConnection().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
