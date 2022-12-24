package fileManagment.ImportingFiles;

import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void creatingTableForFilesInfo(Connection connection) {
        logger.info("Inside the creatingTableForFilesInfo function");
        try(Statement statement = connection.createStatement()){

            String sql = "create table FILESINFO(id int(10) primary key not null AUTO_INCREMENT ,name varchar(35)  not null,type varchar(15),size varchar(100), version int(2),content BLOB)";
            logger.info("create the sql query");
            statement.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}