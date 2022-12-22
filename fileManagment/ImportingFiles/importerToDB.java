package fileManagment.ImportingFiles;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class importerToDB {
    public static void importingInfoToDB(File file, String type, Connection connection) {
        try {
            System.out.println("Inserting records into the table...");
            String query = " insert into FILESINFO (name, type, size)" + " values (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, file.getName());
            preparedStmt.setString(2, type);
            preparedStmt.setFloat(3, file.length());
            preparedStmt.execute();
            System.out.println("success");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
