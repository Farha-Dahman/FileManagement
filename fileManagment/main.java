package fileManagment;

import fileManagment.FileRepository.ExportingFiles.ExportFile;
import fileManagment.ImportingFiles.FilesImporter;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = fileManagment.DBconnection.getConnection();
        int version = 0;
        FilesImporter.importFiles(connection, version);
        FilesImporter.importFiles(connection, version);
        fileManagment.DBconnection.Close();

        ExportFile exportfile = new ExportFile();
        exportfile.exportFile(connection);
    }
}