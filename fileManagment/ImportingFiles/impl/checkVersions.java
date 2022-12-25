package fileManagment.ImportingFiles.impl;
import Exceptions.SQLQueryException;
import fileManagment.ImportingFiles.intf.IcheckerVersions;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkVersions implements IcheckerVersions {
    private static Logger logger = Logger.getLogger(Main.class);
    public int fileExists(StringBuilder name, String type, int version, Connection connection) throws SQLQueryException {
        logger.info("Inside the fileExists function");
        String fileName = name.toString();
        int fileId =0;
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
                    fileId = result.getInt("id");
                    System.out.println("File id : " + fileId);
                }
            } catch (SQLException e1) {
                logger.warn("May have an error in reading info from DB");
                throw new SQLQueryException("Failed on reading info from DB ");
            } finally {
                preparedStmt.close();
                logger.info("Closed the PreparedStatement");
            }
        } catch (SQLException e) {
            logger.warn("May have an error in select query");
            throw new SQLQueryException("Failed on the select sql query ");
        }
        return fileId;
    }
}
