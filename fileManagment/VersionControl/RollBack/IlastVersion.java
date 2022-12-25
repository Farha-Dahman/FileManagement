package fileManagment.VersionControl.RollBack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IlastVersion {
    int lastVersion(Connection connection,String fileName, String type) throws SQLException;
}
