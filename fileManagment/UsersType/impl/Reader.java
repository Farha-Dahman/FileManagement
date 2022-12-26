package fileManagment.UsersType.impl;

import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.Database.IDBconnection;
import fileManagment.FileRepository.ImportingFiles.intf.IFileChecker;
import fileManagment.FileRepository.ReadFile.readFile;
import fileManagment.ImportingFiles.impl.FilesChecker;
import fileManagment.Main;
import fileManagment.UsersType.intf.IReader;
import fileManagment.VersionControl.RollBack.LastVersion;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class Reader implements IReader {
    private final static Logger logger = Logger.getLogger(Main.class);
    private static int version=0;
    public void ReadingFile() throws SQLException, NullObjectException {
        IDBconnection idBconnection = new DBconnection();
        Scanner in = new Scanner(System.in);
        LastVersion iLastVersion=new LastVersion();
        System.out.println("Enter name of file you wont to read");
        String fileName=in.next();
        StringBuilder copyfileName = new StringBuilder(fileName);
        System.out.println("Enter Type of file you wont to read");
        String fileType=in.next();
        IFileChecker fileChecker = new FilesChecker();
        int checkFileExist= fileChecker.fileExists(copyfileName,fileType,version,idBconnection.getConnection());
        if(checkFileExist !=0) {
            System.out.println("File exist\n");
            int lastversion=iLastVersion.lastVersion(idBconnection.getConnection(),fileName,fileType);
            System.out.println("Content of File Version : "+lastversion);
            System.out.println(readFile.ReadFile(fileName,lastversion));

        }else{
            System.out.println("File not exist");
        }
    }
}
