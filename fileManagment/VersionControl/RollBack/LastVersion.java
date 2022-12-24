package fileManagment.VersionControl.RollBack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LastVersion implements IlastVersion{
    public int lastVersion(Connection connection, String fileName, String type) throws SQLException {

        String query = "select * from files WHERE FileName = (?) and Type = (?)";
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setString(1, fileName);
        prepareStatement.setString(2, type);
        ResultSet resultSet = prepareStatement.executeQuery();

        int max_version = 0;
        while (resultSet.next()) {
            if (resultSet.getInt("version") > max_version) {
                max_version = resultSet.getInt("version");
            }
        }
        return max_version;
    }

}
