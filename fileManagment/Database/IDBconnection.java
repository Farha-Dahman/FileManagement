package fileManagment.Database;

import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface IDBconnection {
    Connection getConnection() throws NullObjectException, SQLQueryException;
    void Close() throws NullObjectException, SQLQueryException;
}
