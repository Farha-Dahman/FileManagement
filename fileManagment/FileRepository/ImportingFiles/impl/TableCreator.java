package fileManagment.FileRepository.ImportingFiles.impl;
import Exceptions.SQLQueryException;

import fileManagment.FileRepository.ImportingFiles.intf.ITableCreator;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator implements ITableCreator {
    private final static Logger logger = Logger.getLogger(Main.class);
    private static final String CREATETABLEQUERY= "create table FILESINFO(id int(10) primary key not null AUTO_INCREMENT ,name varchar(35)  not null,type varchar(15),size varchar(10), version int(2),content BLOB)";
    public void creatingTableForFilesInfo(Connection connection) throws SQLQueryException {
        logger.debug("Enter to creatingTableForFilesInfo function with 1 parameter connection");
        logger.info("Inside the creatingTableForFilesInfo function");
        try(Statement statement = connection.createStatement()){
            logger.info("create the sql query (creating the table)");
            statement.executeUpdate(CREATETABLEQUERY);
            System.out.println("Created table in given database...");
        }
        catch (SQLException e) {
            throw new SQLQueryException("Created table failed, maybe it's exists");
        }
        logger.debug("Exit from creatingTableForFilesInfo function");
    }
}