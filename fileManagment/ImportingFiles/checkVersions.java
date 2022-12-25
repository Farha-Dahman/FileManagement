package fileManagment.ImportingFiles;
import Exceptions.SQLQueryException;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkVersions {
    private static Logger logger = Logger.getLogger(Main.class);
    public static boolean fileExists(StringBuilder name, String type, int version, Connection connection) throws SQLQueryException {
        logger.info("Inside the fileExists function");
        String fileName = name.toString();
        String exists = null;
        String selectSQL = "SELECT name,type,version FROM FILESINFO WHERE name = ? AND type = ? AND version = ? ";
        logger.info("Creating the selectSQL query");
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(selectSQL);
            preparedStmt.setString(1,fileName);
            preparedStmt.setString(2,type);
            preparedStmt.setInt(3,version);
            ResultSet result = preparedStmt.executeQuery();
            logger.info("Execute the selectSQL query");
            try {
                while (result.next()) {
                    fileName = result.getString("name");
                    System.out.println("File Name : " + fileName);
                    exists = fileName;
                }
            } catch (SQLException e1) {
                throw new SQLQueryException("Failed on reading info from DB ");
            } finally {
                preparedStmt.close();
                logger.info("Closed the PreparedStatement");
            }
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on the select sql query ");
        }
        return !(exists == null);
    }
}
