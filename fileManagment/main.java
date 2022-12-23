package fileManagment;

import fileManagment.Database.DBconnection;
import fileManagment.FileRepository.ExportingFiles.ExportFile;
import fileManagment.VersionControl.RollBack.InsertFileInfo;
import fileManagment.VersionControl.RollBack.RollBack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = DBconnection.getConnection();

//        ExportFile exportfile = new ExportFile();
//        exportfile.exportFile(connection);

        RollBack rollBack = new RollBack();
        rollBack.rollBack(connection);
    }
}
