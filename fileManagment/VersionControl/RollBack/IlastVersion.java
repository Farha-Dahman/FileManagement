package fileManagment.VersionControl.RollBack;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IlastVersion {
    int lastVersion(ResultSet resultSet) throws SQLException;
}
