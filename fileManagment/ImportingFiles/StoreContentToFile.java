package fileManagment.ImportingFiles;

import fileManagment.Main;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class StoreContentToFile {
    private final static Logger logger = Logger.getLogger(Main.class);
    private static final String SELECTCONTENTQUERY = "select content from FILESINFO";
    public static void storingContent(Connection connection, String OutputFilePath){
        logger.info("Inside the storingContent function");
        Statement statement;
        try {
            statement = connection.createStatement();
            logger.info("create the statement");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(SELECTCONTENTQUERY);
            logger.info("create the ResultSet");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Blob blob = null;
        try {
            if(resultSet.next()){
                blob = resultSet.getBlob("content");
                logger.info("create the Blob object");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        byte[] ContentAsBytes = new byte[0];
        try {
            if (blob != null) {
                ContentAsBytes = blob.getBytes( 1 ,(int)blob.length());
            logger.info("create the ContentAsBytes array");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        FileOutputStream outPutStream;
        try {
            outPutStream = new FileOutputStream(OutputFilePath);
            logger.info("create the FileOutputStream");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            outPutStream.write(ContentAsBytes);
            logger.info("create the FileOutputStream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
