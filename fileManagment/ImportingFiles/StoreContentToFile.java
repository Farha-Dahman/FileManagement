package fileManagment.ImportingFiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class StoreContentToFile {
    public static void storingContent(Connection connection, String OutputFilePath){

        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs;
        try {
            rs = statement.executeQuery("select content from FILESINFO");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Blob blob = null;
        try {
            if(rs.next()){
                blob = rs.getBlob("content");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        byte[] byteArray;
        try {
            byteArray = blob.getBytes( 1 ,(int)blob.length());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        FileOutputStream outPutStream;
        try {
            outPutStream = new FileOutputStream(OutputFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            outPutStream.write(byteArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
