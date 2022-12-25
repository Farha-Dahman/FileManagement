package fileManagment.ImportingFiles.intf;

import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface IFileChecker {
    int fileExists(StringBuilder name, String type, int version, Connection connection) throws SQLQueryException;
    }
