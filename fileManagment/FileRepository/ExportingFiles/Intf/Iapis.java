package fileManagment.FileRepository.ExportingFiles.Intf;

import Exceptions.SQLQueryException;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Iapis {
    ResultSet getByName(Connection connection, String fileName) throws SQLQueryException;
    ResultSet getByType(Connection connection, String fileType) throws SQLQueryException;
    ResultSet getBySize(Connection connection, String fileSize) throws SQLQueryException;

}
