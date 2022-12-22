package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkVersions {
    static boolean fileExists(StringBuilder name, String type, Connection connection) {
        String fileName = name.toString();
        String exists = null;
        String selectSQL = "SELECT name,type FROM FILESINFO WHERE name = ? AND type = ? ";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(selectSQL);
            preparedStmt.setString(1,fileName);
            preparedStmt.setString(2,type);
            ResultSet rs = preparedStmt.executeQuery();
            try {
                while (rs.next()) {
                    fileName = rs.getString("name");
                    System.out.println("File Name : " + fileName);
                    fileName = rs.getString("type");
                    System.out.println("File Type : " + type);
                    exists = fileName;
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                preparedStmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return !(exists == null);
    }
}
