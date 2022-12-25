package fileManagment.FileRepository.ExportingFiles.Intf;

import Exceptions.NullObjectException;

import java.sql.Connection;
import java.sql.SQLException;

public interface IExportFile {
    void exportFile(Connection connection) throws SQLException, NullObjectException;
}
