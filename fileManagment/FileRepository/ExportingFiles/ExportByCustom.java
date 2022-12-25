package fileManagment.FileRepository.ExportingFiles;

import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;
import fileManagment.Database.DBconnection;
import fileManagment.FileRepository.ExportingFiles.Intf.Iapis;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExportByCustom {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void exportByCustom(Connection connection, ResultSet resultSet) throws SQLQueryException, NullObjectException {
        logger.info("Inside the exportByCustom function");
        Iapis iapis = new apis();
        String fileName = null;
        String fileType = null;
        String fileSize = null;
        try {
            while (resultSet.next()) {
                logger.info("Inside the while statement for resultSet");
                fileName = resultSet.getString(1);
                fileType = resultSet.getString(2);
                fileSize = resultSet.getString(3);

                if (!fileName.equals("null") && !fileType.equals("null") && !fileSize.equals("null")) {
                    String query = "select * from filesinfo WHERE name = ? and type=? and size=?";
                    PreparedStatement preparedStatement = DBconnection.getConnection().prepareStatement(query);
                    preparedStatement.setString(1, fileName);
                    preparedStatement.setString(2, fileType);
                    preparedStatement.setString(3, fileSize);
                    preparedStatement.executeQuery();

                } else if (!fileName.equals("null") && !fileType.equals("null") && fileSize.equals("null")) {
                    String query = "select * from filesinfo WHERE name = ? and type=?";
                    PreparedStatement preparedStatement = DBconnection.getConnection().prepareStatement(query);
                    preparedStatement.setString(1, fileName);
                    preparedStatement.setString(2, fileType);
                    preparedStatement.executeQuery();

                } else if (!fileName.equals("null") && !fileSize.equals("null") && fileType.equals("null")) {
                    String query = "select * from filesinfo WHERE name = ? and size=?";
                    PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(query);
                    pstmtdelete.setString(1, fileName);
                    pstmtdelete.setString(2, fileSize);
                    pstmtdelete.executeQuery();

                } else if (!fileType.equals("null") && !fileSize.equals("null") && fileName.equals("null")) {
                    String query = "select * from filesinfo WHERE type = ? and size=?";
                    PreparedStatement preparedStatement = DBconnection.getConnection().prepareStatement(query);
                    preparedStatement.setString(1, fileType);
                    preparedStatement.setString(2, fileSize);
                    preparedStatement.executeQuery();

                } else if (fileType.equals("null") && fileSize.equals("null") && !fileName.equals("null")) {
                    iapis.getByName(connection, fileName);

                } else if (fileName.equals("null") && fileSize.equals("null") && !fileType.equals("null")) {
                    iapis.getByType(connection, fileType);

                } else if (fileType.equals("null") && fileName.equals("null") && !fileSize.equals("null")) {
                    iapis.getBySize(connection, fileSize);
                }
            }
        } catch (SQLException e) {
            throw new SQLQueryException("Failed in getting files information by custom from DB ");
        } catch (NullObjectException e) {
            throw new NullObjectException("Failed on getting the connection ");
        }
    }
}