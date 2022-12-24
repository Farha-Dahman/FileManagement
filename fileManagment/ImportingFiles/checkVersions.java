package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkVersions {
   public static boolean fileExists(StringBuilder name, String type,int version, Connection connection) {
        String fileName = name.toString();
        String fileType;
        int fileVresion;
        String exists = null;
        String selectSQL = "SELECT name,type,version FROM FILESINFO WHERE name = ? AND type = ? AND version = ? ";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(selectSQL);
            preparedStmt.setString(1,fileName);
            preparedStmt.setString(2,type);
            preparedStmt.setInt(3,version);
            ResultSet rs = preparedStmt.executeQuery();
            try {
                while (rs.next()) {
                    fileName = rs.getString("name");
                    System.out.println("File Name : " + fileName);
                    fileType = rs.getString("type");
                    System.out.println("File Type : " + type);
                    fileVresion = rs.getInt("version");
                    System.out.println("File Version : " + version);
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
