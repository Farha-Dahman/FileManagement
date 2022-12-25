package fileManagment.OverwriteFiles;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface IOverwrite {
    void overwitting(Connection connection) throws IOFileException, SQLQueryException, NullObjectException;
}
