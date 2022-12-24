package fileManagment.ImportingFiles;

import Exceptions.SQLQueryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkVersions {
    static boolean fileExists(StringBuilder name, String type,int version, Connection connection) throws SQLQueryException {
        String fileName = name.toString();
        String exists = null;
        String selectSQL = "SELECT name,type,version FROM FILESINFO WHERE name = ? AND type = ? AND version = ? ";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(selectSQL);
            preparedStmt.setString(1,fileName);
            preparedStmt.setString(2,type);
            preparedStmt.setInt(3,version);
            ResultSet result = preparedStmt.executeQuery();
            try {
                while (result.next()) {
                    fileName = result.getString("name");
                    System.out.println("File Name : " + fileName);
                    exists = fileName;
                }
            } catch (SQLException e1) {
                throw new SQLQueryException("Failed on reading info from DB ");
            } finally {
                preparedStmt.close();
            }
        } catch (SQLException e) {
            throw new SQLQueryException("Failed on the select sql query ");
        }
        return !(exists == null);
    }
}
