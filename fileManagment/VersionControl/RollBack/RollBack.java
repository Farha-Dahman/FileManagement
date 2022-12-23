package fileManagment.VersionControl.RollBack;

import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RollBack {

    public void rollBack(Connection connection) throws SQLException {
        InputInfo inputInfo = new InsertFileInfo();
        ResultSet resultSet = inputInfo.insertInfo(connection);


        Path pathOfFiles = Path.of("C:\\Users\\MASS\\FilesFromDB");

        replaceVersion.replaceContent(pathOfFiles,resultSet);

    }

}
