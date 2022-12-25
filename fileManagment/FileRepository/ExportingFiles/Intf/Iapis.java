package fileManagment.FileRepository.ExportingFiles.Intf;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Iapis {
    ResultSet getByName(Connection connection, String fileName);
    ResultSet getByType(Connection connection, String fileType);
    ResultSet getBySize(Connection connection, String fileSize);

}
