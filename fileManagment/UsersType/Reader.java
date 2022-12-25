package fileManagment.UsersType;

import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.ImportingFiles.intf.IcheckerVersions;
import fileManagment.ImportingFiles.checkVersions;
import fileManagment.Main;
import fileManagment.ReadFile.readFile;
import fileManagment.VersionControl.RollBack.LastVersion;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class Reader {
    private final static Logger logger = Logger.getLogger(Main.class);
    private static int version=0;
    public static void ReadingFile() throws SQLException, NullObjectException {
        Scanner in = new Scanner(System.in);
        LastVersion iLastVersion=new LastVersion();
        System.out.println("Enter name of file you wont to read");
        String fileName=in.next();
        StringBuilder copyfileName = new StringBuilder(fileName);
        System.out.println("Enter Type of file you wont to read");
        String fileType=in.next();
        IcheckerVersions icheckerVersions = new checkVersions();
        int checkFileExist= icheckerVersions.fileExists(copyfileName,fileType,version,DBconnection.getConnection());
        if(checkFileExist !=0) {
            System.out.println("File exist\n");
            int lastversion=iLastVersion.lastVersion(DBconnection.getConnection(),fileName,fileType);
            System.out.println("Content of File Version : "+lastversion);
            System.out.println(readFile.ReadFile(fileName,lastversion));

        }else{
            System.out.println("File not exist");
        }
    }
}
