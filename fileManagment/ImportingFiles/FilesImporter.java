package fileManagment.ImportingFiles;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class FilesImporter {

    public static void importFiles(Connection connection, int version){

        Scanner sc= new Scanner(System.in);
        String path,fileType,fileSize,fileName;
        StringBuilder copyfileName ;;
        boolean c;
            System.out.println("Please enter file path: ");
            path = sc.next();
            System.out.println("please enter file type : ");
            fileType = sc.next();
            System.out.println("please enter file size : ");
            fileSize = sc.next();
            File file = filesReader.readingFiles(path);
            fileName= file.getName();
            copyfileName = new StringBuilder(fileName);
;
            System.out.println(copyfileName);
            c = checkVersions.fileExists(copyfileName,fileType,connection);
            if(c){
                version++;
                copyfileName.append("(" + version + ")");
            }
            System.out.println(" name : " + file.getName() + " size : " + file.length() + " size : " + fileSize + " new name: " + copyfileName);
            importerToDB.importingInfoToDB(copyfileName, fileType, fileSize,version,connection);
            fileSaver.savingFiles(copyfileName, path);
    }
}