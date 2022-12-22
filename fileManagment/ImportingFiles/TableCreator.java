package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    public static void creatingTableForFilesInfo(Connection connection) {
        try(Statement statement = connection.createStatement();){

            String sql = "create table FILESINFO(id int(10) primary key not null AUTO_INCREMENT ,name varchar(15)  not null,type varchar(15),size float(4), version int(2))";

            statement.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}