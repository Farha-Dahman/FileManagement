package fileManagment.FileRepository.ExportingFiles;

import Exceptions.SQLQueryException;
import fileManagment.Database.DBconnection;
import fileManagment.FileRepository.ExportingFiles.Intf.Iapis;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class apis implements Iapis {
    private static Logger logger = Logger.getLogger(Main.class);

    public ResultSet getByName(Connection connection, String fileName) throws SQLQueryException {
        logger.info("Inside the getByName function");
        ResultSet resultSet = null;
        try {
            String query = "select * from filesinfo WHERE name = (?)";
            logger.info("Created the query");
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, fileName);
            resultSet = prepareStatement.executeQuery();
            logger.info("Created the resultSet");

        } catch (SQLException e) {
            throw new SQLQueryException("Failed on getting files by name from DB");
        }
        logger.info("returned the resultSet");
        return resultSet;
    }

    public ResultSet getByType(Connection connection, String type) throws SQLQueryException {
        ResultSet resultSet = null;
        try {
            String query = "select * from filesinfo WHERE type = (?)";
            logger.info("Created the query");
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, type);
            resultSet = prepareStatement.executeQuery();
            logger.info("Created the resultSet");

        } catch (SQLException e) {
            throw new SQLQueryException("Failed on getting files by type from DB");
        }
        logger.info("returned the resultSet");
        return resultSet;
    }

    public ResultSet getBySize(Connection connection, String size) throws SQLQueryException {
        ResultSet resultSet = null;
        try {
            String query = "select * from filesinfo WHERE size = (?)";
            logger.info("Created the query");
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, size);
            resultSet = prepareStatement.executeQuery();
            logger.info("Created the resultSet");

        } catch (SQLException e) {
            throw new SQLQueryException("Failed on getting files by size from DB");
        }
        logger.info("returned the resultSet");
        return resultSet;
    }

    public ResultSet getByCustom(Connection connection, String nameClassification) throws SQLQueryException {
        ResultSet resultSet = null;
        String sql = "SELECT name,type,size FROM customCategory WHERE nameClassification=?";
        try {
            PreparedStatement preparedStatement = DBconnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,nameClassification);
            resultSet = preparedStatement.executeQuery();
            ExportByCustom.exportByCustom(connection,resultSet);
        } catch (Exception e) {
            throw new SQLQueryException("Failed on getting files by custom from DB");
        }
        return resultSet;
    }
}
