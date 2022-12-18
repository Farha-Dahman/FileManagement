package fileManagment;

import fileManagment.ImportingFiles.InfoImporter;

import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Connection connection = DBconnection.getConnection();

        System.out.println("please enter file name");
        String fileName = sc.nextLine();
        System.out.println("please enter file type");
        String fileType = sc.nextLine();
        System.out.println("please enter file size");
        Float fileSize = sc.nextFloat();
        FileInfo file = new FileInfo(fileName,fileType, fileSize);

        InfoImporter.importinginfo(file, connection);

        DBconnection.Close();
    }
}
