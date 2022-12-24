package fileManagment.ImportingFiles;
import fileManagment.EncryptedDecrypted.Decrypted;
import fileManagment.EncryptedDecrypted.DecryptedContentBonus;
import fileManagment.EncryptedDecrypted.Encrypted;
import fileManagment.EncryptedDecrypted.EncryptedContentBonus;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class FilesImporter {

    public static void importFiles(Connection connection, int version){

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
            c = checkVersions.fileExists(copyfileName,fileType,connection);
            if(c){
                version++;
                copyfileName.append("(" + version + ")");
            }

            Encrypted.encrypted(copyfileName);
            System.out.println("enc  " + copyfileName);
            EncryptedContentBonus.encrypted(path);
            Decrypted.decrypted(copyfileName);
            System.out.println("dec  " + copyfileName);
            DecryptedContentBonus.Dycrept(path);


            System.out.println(" name : " + file.getName() + " size : " + file.length() + " size : " + fileSize + " new name: " + copyfileName);
            importerToDB.importingInfoToDB(copyfileName, fileType, fileSize,version,connection);
            fileSaver.savingFiles(copyfileName, path);
    }
}