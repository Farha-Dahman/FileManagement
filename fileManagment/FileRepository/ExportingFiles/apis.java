package fileManagment.FileRepository.ExportingFiles;

import fileManagment.FileRepository.ExportingFiles.Intf.Iapis;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class apis implements Iapis {
    private static Logger logger = Logger.getLogger(Main.class);
    public ResultSet getByName(Connection connection, String fileName) {
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
            e.printStackTrace();
        }
        logger.info("returned the resultSet");
        return resultSet;
    }
    public ResultSet getByType(Connection connection, String type) {
        ResultSet resultSet = null;
        try {
            String query = "select * from filesinfo WHERE type = (?)";
            logger.info("Created the query");
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, type);
            resultSet = prepareStatement.executeQuery();
            logger.info("Created the resultSet");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("returned the resultSet");
        return resultSet;
    }

    public ResultSet getBySize(Connection connection, String size) {
        ResultSet resultSet = null;
        try {
            String query = "select * from filesinfo WHERE size = (?)";
            logger.info("Created the query");
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, size);
            resultSet = prepareStatement.executeQuery();
            logger.info("Created the resultSet");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("returned the resultSet");
        return resultSet;
    }
}
