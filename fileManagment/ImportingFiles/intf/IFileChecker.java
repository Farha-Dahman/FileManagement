package fileManagment.ImportingFiles.intf;

import java.sql.Connection;

public interface IFileChecker {
    int fileExists(StringBuilder name, String type, int version, Connection connection);
    }
