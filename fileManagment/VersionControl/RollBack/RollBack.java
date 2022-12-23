package fileManagment.VersionControl.RollBack;

import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RollBack {

    public void rollBack(Connection connection) throws IOException {
        InputInfo inputInfo = new InsertFileInfo();
        ResultSet resultSet = inputInfo.insertInfo(connection);




//        replaceVersion.replaceContent(pathOfFiles,resultSet);

    }



}


