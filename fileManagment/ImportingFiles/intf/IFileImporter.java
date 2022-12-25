package fileManagment.ImportingFiles.intf;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface IFileImporter {
    void importFiles(Connection connection, int version) throws SQLQueryException, IOFileException, NullObjectException;
}
