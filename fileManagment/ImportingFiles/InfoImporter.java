package fileManagment.ImportingFiles;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InfoImporter {

    public static void importinginfo(File file, String type,String conent, Connection connection) {
            try {
                System.out.println("Inserting records into the table...");
                String query = " insert into FILESINFO (name, type, size,content)" + " values (?, ?, ?,?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, file.getName());
                preparedStmt.setString(2, type);
                preparedStmt.setFloat(3, file.length());
                preparedStmt.setString(4, conent);
                preparedStmt.execute();
                System.out.println("success");
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }