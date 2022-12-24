package fileManagment.FileClassification;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FileClassification {

    public static void CreateTableClassification(Connection connection){

        try(Statement stmt = connection.createStatement();){

            String sql = "create table customCategory(id int(10) primary key not null AUTO_INCREMENT ,nameClassification varchar(15),name varchar(15),type varchar(15),size varchar(15))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}