package fileManagment.Database;

import fileManagment.Database.DBconnection;
import fileManagment.FileRepository.ExportFile;

public class main {
    public static void main(String[] args) {
        DBconnection dBconnection = new DBconnection();
        dBconnection.DBConnection();

        ExportFile exportfile = new ExportFile();
        exportfile.exportFile(dBconnection.DBConnection());
    }
}
