package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilesChecker {
    private static final String SELECTSQL = "SELECT id,name,type,version FROM FILESINFO WHERE name = ? AND type = ? AND version = ? ";

    public static int fileExists(StringBuilder name, String type, int version, Connection connection) {
        String fileName = name.toString();
        int fileId = 0;
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(SELECTSQL);
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
