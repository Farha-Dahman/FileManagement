package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    private static final String CREATETABLEQUERY= "create table FILESINFO(id int(10) primary key not null AUTO_INCREMENT ,name varchar(35)  not null,type varchar(15),size float(4), version int(2),content BLOB)";

    public static void creatingTableForFilesInfo(Connection connection) {
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(CREATETABLEQUERY);
            System.out.println("Created table in given database...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}