package fileManagment.FileRepository.ImportingFiles.intf;

import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface IcheckerVersions {
    int fileExists(StringBuilder name, String type, int version, Connection connection) throws SQLQueryException;
    }
