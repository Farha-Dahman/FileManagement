package fileManagment.ImportingFiles;

import fileManagment.Main;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkVersions {
    private static Logger logger = Logger.getLogger(Main.class);
    static boolean fileExists(StringBuilder name, String type,int version, Connection connection) {
        logger.info("Inside the fileExists function");
        String fileName = name.toString();
        String fileType;
        int fileVresion;
        String exists = null;
        String selectSQL = "SELECT name,type,version FROM FILESINFO WHERE name = ? AND type = ? AND version = ? ";
        logger.info("Creating the selectSQL query");
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(selectSQL);
            preparedStmt.setString(1,fileName);
            preparedStmt.setString(2,type);
            preparedStmt.setInt(3,version);
            ResultSet rs = preparedStmt.executeQuery();
            logger.info("Execute the selectSQL query");
            try {
                while (rs.next()) {
                    fileName = rs.getString("name");
                    System.out.println("File Name : " + fileName);
                    logger.info("Get the name of file: " + fileName);
                    fileType = rs.getString("type");
                    System.out.println("File Type : " + type);
                    logger.info("Get the type of file: " + type);
                    fileVresion = rs.getInt("version");
                    System.out.println("File Version : " + version);
                    logger.info("Get the version of file: " + version);
                    exists = fileName;
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                preparedStmt.close();
                logger.info("Closed the PreparedStatement");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return !(exists == null);
    }
}
