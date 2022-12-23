package fileManagment;

import fileManagment.Database.DBconnection;
import fileManagment.FileRepository.ExportingFiles.ExportFile;

import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBconnection.getConnection();

        ExportFile exportfile = new ExportFile();
        exportfile.exportFile(connection);
    }
}
