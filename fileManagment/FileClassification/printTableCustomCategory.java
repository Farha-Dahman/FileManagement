package fileManagment.FileClassification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class printTableCustomCategory {
    public static void printTableClassification(Connection connection) {
        try {
            String query = "SELECT * FROM customCategory";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int countClassification=0;
            while (resultSet.next()) {
                String nameClassification= resultSet.getString("nameClassification");
                System.out.println("Name Classification "+ ++countClassification +":"+nameClassification);
                String filename = resultSet.getString("name");
                String fileType=resultSet.getString("type");
                String fileSize=resultSet.getString("size");
                if(!filename.equals("null")&&!filename.equals("Null")){
                    System.out.println("Name of file : "+filename);
                }
                if(!fileType.equals("null")&&!fileType.equals("Null")){
                    System.out.println("Type of file : "+fileType);
                }
                if(!fileSize.equals("null")&&!fileSize.equals("Null")){
                    System.out.println("Size of file : "+fileSize);
                }
                System.out.println("-----------------");
                //  System.out.format("%s, %s\n", id, filename);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
