package fileManagment.VersionControl.RollBack;

import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;
import fileManagment.Main;
import fileManagment.VersionControl.RollBack.intf.IlastVersion;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RollBack {
    private static Logger logger = Logger.getLogger(Main.class);
    public void rollBack(Connection connection) throws SQLException {
        logger.info("Inside the rollBack function");
        InputInfo inputInfo = new InsertFileInfo();
        ResultSet resultSet = inputInfo.insertInfo(connection);
        IlastVersion ilastVersion = new LastVersion();
        logger.info("Inserted the file information");

        resultSet.next();
        String nameFile = resultSet.getString("name");
        String typeFile = resultSet.getString("type");
        int max_version = ilastVersion.lastVersion(connection,nameFile,typeFile);
        logger.info("Get the file name and type :" + nameFile + typeFile);

        String delete_query = "DELETE FROM filesinfo WHERE name = (?) and type = (?) and version = (?)";
        PreparedStatement prepareStatement = connection.prepareStatement(delete_query);
        prepareStatement.setString(1, nameFile);
        prepareStatement.setString(2, typeFile);
        prepareStatement.setInt(3, max_version);
        prepareStatement.execute();
        logger.info("create the query");
        System.out.println("You replaced the latest version with the previous one!");
    }
}


