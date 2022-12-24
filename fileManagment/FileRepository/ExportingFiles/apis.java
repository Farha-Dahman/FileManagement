package fileManagment.FileRepository.ExportingFiles;

import fileManagment.FileRepository.ExportingFiles.Intf.Iapis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class apis implements Iapis {
    public ResultSet getByName(Connection connection, String fileName) {
        ResultSet resultSet = null;
        try {
            String query = "select * from filesinfo WHERE name = (?)";
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, fileName);
            resultSet = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getByType(Connection connection, String type) {
        ResultSet resultSet = null;
        try {
            String query = "select * from filesinfo WHERE type = (?)";
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, type);
            resultSet = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getBySize(Connection connection, String size) {
        ResultSet resultSet = null;
        try {
            String query = "select * from filesinfo WHERE size = (?)";
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, size);
            resultSet = prepareStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
