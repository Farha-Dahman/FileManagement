package fileManagment.ImportingFiles;
import Exceptions.IOFileException;
import Exceptions.SQLQueryException;
import Exceptions.NullObjectException;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class StoreContentToFile {
    private final static Logger logger = Logger.getLogger(Main.class);
    private static final String SELECTCONTENTQUERY = "select content from FILESINFO";

    public static void storingContent(Connection connection, String OutputFilePath) throws SQLQueryException, IOFileException, NullObjectException {
        logger.info("Inside the storingContent function");
        Statement statement;
        try {
            statement = connection.createStatement();
            logger.info("create the statement");
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on creating Statement to sending a query to DB ");
        }
        ResultSet resultSet;
        try {

            resultSet = statement.executeQuery(SELECTCONTENTQUERY);
            logger.info("create the ResultSet");
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on executing select query");
        }
        Blob blob = null;
        try {
            if(resultSet.next()){
                blob = resultSet.getBlob("content");
                logger.info("create the Blob object");
            }
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on reading content from DB");
        }
        byte[] ContentAsBytes = new byte[0];
        try {
            if (blob != null) {
                ContentAsBytes = blob.getBytes( 1 ,(int)blob.length());
            }
            logger.info("create the ContentAsBytes array");
        } catch (NullPointerException e){
            throw new NullObjectException("Content is empty ");
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on converting content to bytes array");
        }

        FileOutputStream outPutStream;
        try {
            outPutStream = new FileOutputStream(OutputFilePath);
            logger.info("create the FileOutputStream");
        } catch (FileNotFoundException e) {
            throw new IOFileException("Failed on creating output file");
        }
        try {
            outPutStream.write(ContentAsBytes);
            logger.info("create the FileOutputStream");
        } catch (IOException e) {
            throw new IOFileException("Failed on writing content to a specific file");
        }
    }
}
