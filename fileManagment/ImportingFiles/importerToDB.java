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
    public static void importCustomCategoryToDB(String nameClassification,String name, String type,String size, Connection connection) {
        try {
            System.out.println("Inserting records into the table...");
            String query = " insert into customCategory(nameClassification,name, type, size)" + " values (?,?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nameClassification);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, type);
            preparedStmt.setString(4, size);
            preparedStmt.execute();
            System.out.println("success");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
