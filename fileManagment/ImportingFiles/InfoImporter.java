package fileManagment.ImportingFiles;

import fileManagment.File;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InfoImporter {

    public static void importinginfo(File file, Connection connection) {
            try {
                // Execute a query
                System.out.println("Inserting records into the table...");
                //String sql = "INSERT INTO FILESINFO VALUES (@file.fileName, @file.fileType,@file.fileSize)";
                String query = " insert into FILESINFO (name, type, size)" + " values (?, ?, ?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, file.getFileName());
                preparedStmt.setString(2, file.getFileType());
                preparedStmt.setFloat(3, file.getSize());
                preparedStmt.execute();
                System.out.println("success");
                //connection.close();
                //stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }