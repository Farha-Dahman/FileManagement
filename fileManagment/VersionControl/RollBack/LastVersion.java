package fileManagment.VersionControl.RollBack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LastVersion implements IlastVersion{
    public int lastVersion(ResultSet resultSet) throws SQLException {
        int max_version = 0;
        while (resultSet.next()) {
            if (resultSet.getInt("version") > max_version) {
                max_version = resultSet.getInt("version");
            }
        }
        return max_version;
    }
}
