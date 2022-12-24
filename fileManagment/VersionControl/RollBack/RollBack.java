package fileManagment.VersionControl.RollBack;

import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RollBack {
    public void rollBack(Connection connection) throws SQLException {
        InputInfo inputInfo = new InsertFileInfo();
        ResultSet resultSet = inputInfo.insertInfo(connection);
        IlastVersion ilastVersion = new LastVersion();

        resultSet.next();
        String nameFile = resultSet.getString("FileName");
        String typeFile = resultSet.getString("Type");
        int max_version = ilastVersion.lastVersion(resultSet);

        String delete_query = "DELETE FROM files WHERE FileName = (?) and Type = (?) and version = (?)";
        PreparedStatement prepareStatement = connection.prepareStatement(delete_query);
        prepareStatement.setString(1, nameFile);
        prepareStatement.setString(2, typeFile);
        prepareStatement.setInt(3, max_version);
        prepareStatement.execute();
        System.out.println("You replaced the latest version with the previous one!");
    }
}


