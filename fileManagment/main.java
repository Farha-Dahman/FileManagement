package fileManagment;
import fileManagment.ImportingFiles.FilesImporter;
import java.io.*;
import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Connection connection = DBconnection.getConnection();
        int version =0;
        FilesImporter.importFiles(connection,version);
        FilesImporter.importFiles(connection,version);
        DBconnection.Close();
    }
}
