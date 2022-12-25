package fileManagment.FileRepository.ExportingFiles.Intf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface InputInfo {
    ResultSet insertInfo(Connection connection) throws SQLException;
}
