package fileManagment.FileClassification;

import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FileClassification {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void CreateTableClassification(Connection connection){
        logger.info("Inside the Create Table Classification function");
        try(Statement stmt = connection.createStatement()){
            String sql = "create table customCategory(id int(10) primary key not null AUTO_INCREMENT ,nameClassification varchar(15),name varchar(15),type varchar(15),size varchar(15))";
            stmt.executeUpdate(sql);
            logger.info("Execute SQL query");
            System.out.println("Created table in given database...");
            logger.info("Created table in given database");
        }
        catch (SQLException e) {
            logger.info("SQLException");
            e.printStackTrace();
        }

    }
}