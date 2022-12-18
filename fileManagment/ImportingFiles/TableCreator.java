package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    public static void creatingTableForFilesInfo(Connection connection) {
        try(Statement stmt = connection.createStatement();){
            String sql = "CREATE TABLE FILESINFO " +
                    "(name VARCHAR(255), " +
                    " type VARCHAR(255), " +
                    " size INTEGER, " +
                    " PRIMARY KEY (name))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}