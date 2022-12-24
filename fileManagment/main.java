package fileManagment;

import fileManagment.FileRepository.ExportingFiles.ExportFile;
import fileManagment.ImportingFiles.FilesImporter;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import fileManagment.Database.DBconnection;
import fileManagment.FileRepository.ExportingFiles.ExportFile;
import fileManagment.VersionControl.RollBack.InsertFileInfo;
import fileManagment.VersionControl.RollBack.RollBack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import fileManagment.Database.DBconnection;
import fileManagment.FileRepository.DisplayFiles.PrintAvailableFiles;
import fileManagment.FileRepository.ExportingFiles.ExportFile;

import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = DBconnection.getConnection();
        int version = 0;
        FilesImporter.importFiles(connection, version);
        FilesImporter.importFiles(connection, version);


        RollBack rollBack = new RollBack();
        rollBack.rollBack(connection);

//        ExportFile exportfile = new ExportFile();
//        exportfile.exportFile(connection);
        PrintAvailableFiles printAvailableFiles = new PrintAvailableFiles();
        printAvailableFiles.printFiles(connection);
    }
}
