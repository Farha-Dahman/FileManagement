package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilesChecker {
    public static int fileExists(StringBuilder name, String type, int version, Connection connection) {
        String fileName = name.toString();
        int fileId = 0;
        String selectSQL = "SELECT id,name,type,version FROM FILESINFO WHERE name = ? AND type = ? AND version = ? ";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(selectSQL);
            preparedStmt.setString(1,fileName);
            preparedStmt.setString(2,type);
            preparedStmt.setInt(3,version);
            ResultSet rs = preparedStmt.executeQuery();
            try {
                while (rs.next()) {
                    fileId = rs.getInt("id");
                    System.out.println("File id : " + fileId);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                preparedStmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fileId;
    }
}
