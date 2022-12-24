package fileManagment.ImportingFiles;

import Exceptions.IOFileException;
import Exceptions.SQLQueryException;
import Exceptions.NullObjectException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class StoreContentToFile {
    public static void storingContent(Connection connection, String OutputFilePath) throws SQLQueryException, IOFileException, NullObjectException {

        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on creating Statement to sending a query to DB ");
        }
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("select content from FILESINFO");
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on executing select query");
        }
        Blob blob = null;
        try {
            if(resultSet.next()){
                blob = resultSet.getBlob("content");
            }
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on reading content from DB");
        }
        byte[] byteArray;
        try {
            byteArray = blob.getBytes( 1 ,(int)blob.length());
        } catch (NullPointerException e){
            throw new NullObjectException("Content is empty ");
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on converting content to bytes array");
        }

        FileOutputStream outPutStream;
        try {
            outPutStream = new FileOutputStream(OutputFilePath);
        } catch (FileNotFoundException e) {
            throw new IOFileException("Failed on creating output file");
        }
        try {
            outPutStream.write(byteArray);
        } catch (IOException e) {
            throw new IOFileException("Failed on writing content to a specific file");
        }
    }
}
