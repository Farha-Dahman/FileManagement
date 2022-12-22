package fileManagment.ImportingFiles;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FilesImporter {

    public static void importFiles(Connection connection){

        Scanner sc= new Scanner(System.in);
        String path,fileType;
        int exit =0;
        while(exit != 1) {
            System.out.println("Please enter file path: ");
            path = sc.next();
            System.out.println("please enter file type : ");
            fileType = sc.next();
            File file = filesReader.readingFiles(path);
            System.out.println(" name : " + file.getName() + " size : " + file.length());
            importerToDB.importingInfoToDB(file, fileType, connection);
            fileSaver.savingFiles(file, path);
            System.out.println("You need to exit program? (0,1) ");
            exit = sc.nextInt();}
    }
    }