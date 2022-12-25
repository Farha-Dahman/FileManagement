package fileManagment.FileClassification;

import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class printTableCustomCategory {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void printTableClassification(Connection connection) {
        logger.info("Inside the print Table Classification function");
        try {
            String query = "SELECT * FROM customCategory";
            logger.info("create the query");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            logger.info("resultSet created");
            int countClassification=0;
            while (resultSet.next()) {
                logger.info("inside the while statement for the resultSet");
                String nameClassification= resultSet.getString("nameClassification");
                System.out.println("Name Classification "+ ++countClassification +":"+nameClassification);
                String filename = resultSet.getString("name");
                String fileType = resultSet.getString("type");
                String fileSize = resultSet.getString("size");
                if(!filename.equals("null")&&!filename.equals("Null")){
                    logger.info("file name: " + filename);
                    System.out.println("Name of file : "+filename);
                }
                if(!fileType.equals("null")&&!fileType.equals("Null")){
                    logger.info("file type: " + fileType);
                    System.out.println("Type of file : "+fileType);
                }
                if(!fileSize.equals("null")&&!fileSize.equals("Null")){
                    logger.info("file size: " + fileSize);
                    System.out.println("Size of file : "+fileSize);
                }
                System.out.println("-----------------");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
