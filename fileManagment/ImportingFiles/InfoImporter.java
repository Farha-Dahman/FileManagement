package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InfoImporter {

    public static void importinginfo(String fileName, String fileType, int fileSize, Connection connection) {
        try(Statement stmt = connection.createStatement()){
                // Execute a query
                System.out.println("Inserting records into the table...");
                String sql = "INSERT INTO FILESINFO VALUES (@fileName, @fileType,@fileSize)";
                stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
