package fileManagment.FileRepository.DisplayFiles;

import java.sql.*;

public class PrintAvailableFiles {
    public void printFiles(Connection connection) {
        try {
            String query = "SELECT * FROM files";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String filename = resultSet.getString("FileName");
                System.out.format("%s, %s\n", id, filename);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


