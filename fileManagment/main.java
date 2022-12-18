package fileManagment;

import fileManagment.ImportingFiles.InfoImporter;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        Connection connection = DBconnection.getConnection();
        File file = new File("first","txt", 24.0F);
        InfoImporter.importinginfo(file, connection);

        DBconnection.Close();
    }
}
