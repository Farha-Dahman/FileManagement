package fileManagment.VersionControl.RollBack;

import fileManagment.Main;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LastVersion implements IlastVersion{
    private static Logger logger = Logger.getLogger(Main.class);
    public int lastVersion(Connection connection, String fileName, String type) throws SQLException {
        logger.info("Inside the lastVersion function");
        String query = "select * from filesinfo WHERE name = (?) and type = (?)";
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setString(1, fileName);
        prepareStatement.setString(2, type);
        ResultSet resultSet = prepareStatement.executeQuery();
        logger.info("create the query");

        int max_version = 0;
        while (resultSet.next()) {
            if (resultSet.getInt("version") > max_version) {
                max_version = resultSet.getInt("version");
            }
        }
        logger.info("find the max version: " + max_version);
        return max_version;
    }

}
