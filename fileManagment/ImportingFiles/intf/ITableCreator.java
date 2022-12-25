package fileManagment.ImportingFiles.intf;

import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface ITableCreator {
    void creatingTableForFilesInfo(Connection connection) throws SQLQueryException;
}
