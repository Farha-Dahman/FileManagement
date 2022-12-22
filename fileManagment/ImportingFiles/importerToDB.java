package fileManagment.ImportingFiles;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class importerToDB {
    public static void importingInfoToDB(File file ,StringBuilder name, String type,String size, int version,Connection connection) {
        try {
            System.out.println("Inserting records into the table...");
            String query = " insert into FILESINFO (name, type, size, version,content)" + " values (?, ?, ?,?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            String fileName = name.toString();
            preparedStmt.setString(1, fileName);
            preparedStmt.setString(2, type);
            preparedStmt.setString(3, size);
            preparedStmt.setFloat(4, version);
            byte[] content = filesReader.ReadingContentAsBytes(file.getPath());
            Blob blob = new SerialBlob(content);
            preparedStmt.setBlob(5,blob);
            preparedStmt.execute();
            System.out.println("success");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}