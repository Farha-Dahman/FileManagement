package fileManagment.FileRepository.ExportingFiles.Intf;

import java.sql.Connection;
import java.sql.ResultSet;

public interface InputInfo {
    ResultSet insertInfo(Connection connection);
}
