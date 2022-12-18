package fileManagment.ImportingFiles;
import fileManagment.FileInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InfoImporter {

    public static void importinginfo(FileInfo file, Connection connection) {
            try {
                System.out.println("Inserting records into the table...");
                String query = " insert into FILESINFO (name, type, size)" + " values (?, ?, ?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, file.getFileName());
                preparedStmt.setString(2, file.getFileType());
                preparedStmt.setFloat(3, file.getSize());
                preparedStmt.execute();
                System.out.println("success");
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }