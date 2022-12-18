package fileManagment;

import fileManagment.ImportingFiles.InfoImporter;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        Connection connection = DBconnection.getConnection();
        InfoImporter.importinginfo("first","txt",20, connection);

        DBconnection.Close();
    }
}
