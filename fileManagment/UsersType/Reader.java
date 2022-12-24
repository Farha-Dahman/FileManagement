package fileManagment.UsersType;

import fileManagment.Database.DBconnection;
import fileManagment.ImportingFiles.checkVersions;
import fileManagment.ReadFile.readFile;
import fileManagment.VersionControl.RollBack.LastVersion;

import java.sql.SQLException;
import java.util.Scanner;

public class Reader {

    public static int version=0;
    public static void ReadingFile() throws SQLException {
        Scanner in = new Scanner(System.in);
        LastVersion iLastVersion=new LastVersion();
        System.out.println("Enter name of file you wont to read");
        String fileName=in.next();
        StringBuilder copyfileName = new StringBuilder(fileName);
        System.out.println("Enter Type of file you wont to read");
        String fileType=in.next();
        boolean checkFileExist= checkVersions.fileExists(copyfileName,fileType,version,DBconnection.getConnection());
        if(checkFileExist) {
            System.out.println("File exist\n");
            int lastversion=iLastVersion.lastVersion(DBconnection.getConnection(),fileName,fileType);
            System.out.println("Content of File Version : "+lastversion);
            System.out.println(readFile.ReadFile(fileName,lastversion));

        }else{
            System.out.println("File not exist");
        }
    }
}
