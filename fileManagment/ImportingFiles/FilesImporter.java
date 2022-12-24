package fileManagment.ImportingFiles;
import Exceptions.IOFileException;
import Exceptions.SQLQueryException;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class FilesImporter {

    public static void importFiles(Connection connection, int version) throws SQLQueryException, IOFileException{

        Scanner sc= new Scanner(System.in);
        String path,fileType,fileSize,fileName;
        StringBuilder copyfileName ;
        boolean c;
            System.out.println("Please enter file path: ");
            path = sc.next();
            System.out.println("please enter file type : ");
            fileType = sc.next();
            System.out.println("please enter file size : ");
            fileSize = sc.next();
            File file = new File(path);
            fileName= file.getName();
            copyfileName = new StringBuilder(fileName);
            System.out.println(copyfileName);
            c = checkVersions.fileExists(copyfileName,fileType,version,connection);
            while (c){
                version++;
                c = checkVersions.fileExists(copyfileName,fileType,version,connection);
            }
            System.out.println(" name : " + file.getName() + " size : " + file.length() + " size : " + fileSize + " new name: " + copyfileName);
            importerToDB.importingInfoToDB(file,copyfileName, fileType, fileSize,version,connection);
            if(version !=0)copyfileName.replace(fileName.length(),fileName.length()+3,"(" + version + ")");
            fileSaver.savingFiles(copyfileName,connection);
    }
}