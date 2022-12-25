package fileManagment.Database;
import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;
import fileManagment.ImportingFiles.intf.ITableCreator;
import fileManagment.ImportingFiles.TableCreator;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.*;

public class DBconnection {
    private final static Logger logger = Logger.getLogger(Main.class);
    private static final String LINK_OF_DATABASE = "jdbc:mysql://localhost:3306/fileManagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection= null;
    public static Connection getConnection() throws NullObjectException, SQLQueryException {
        logger.debug("Enter to getConnection function.");
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
                        ITableCreator iTableCreator = new TableCreator();
                        iTableCreator.creatingTableForFilesInfo(connection);
                        System.out.println("Success");
                        logger.info("connected Successfully");
                    }
                }
            }
            logger.debug("Exit from getConnection function.");
            return connection;
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on creating table");
        } catch (ClassNotFoundException e) {
            throw new NullObjectException("Failed in founding the class.");
        }
    }
    public static void Close() throws NullObjectException, SQLQueryException {
        logger.debug("Enter to Close function.");
        logger.info("Closed the connection");
        try {
            DBconnection.getConnection().close();
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on getting the connection");
        }
        logger.debug("Exit to Close function.");
    }
}
