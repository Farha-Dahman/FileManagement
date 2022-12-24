package fileManagment;
import fileManagment.ImportingFiles.FilesImporter;
import java.sql.Connection;
import java.util.Scanner;
import fileManagment.OverwriteFiles.overwite;
public class main {
    public static void main(String[] args){
        Connection connection = DBconnection.getConnection();
        int version =0;
        FilesImporter.importFiles(connection,version);
        overwite.overwitting(connection);
        DBconnection.Close();
    }
}
