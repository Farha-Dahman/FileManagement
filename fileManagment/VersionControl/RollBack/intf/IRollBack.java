package fileManagment.VersionControl.RollBack.intf;

import java.sql.Connection;
import java.sql.SQLException;

public interface IRollBack {

    void rollBack(Connection connection) throws SQLException;
}
