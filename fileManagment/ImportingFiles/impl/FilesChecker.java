package fileManagment.ImportingFiles.impl;
import Exceptions.SQLQueryException;
import fileManagment.ImportingFiles.intf.IFileChecker;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilesChecker implements IFileChecker {
    private final static Logger logger = Logger.getLogger(Main.class);
    private static final String SELECTSQL = "SELECT id,name,type,version FROM FILESINFO WHERE name = ? AND type = ? AND version = ? ";
    public int fileExists(StringBuilder name, String type, int version, Connection connection) throws SQLQueryException {
        logger.info("Inside the fileExists function");
        String fileName = name.toString();
        int fileId =0;
        logger.info("Creating the selectSQL query");
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(SELECTSQL);
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
