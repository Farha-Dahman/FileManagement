package fileManagment.ImportingFiles.intf;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface IFileSaver {
    void savingFiles(StringBuilder name, Connection connection) throws IOFileException, SQLQueryException, NullObjectException;
    }
