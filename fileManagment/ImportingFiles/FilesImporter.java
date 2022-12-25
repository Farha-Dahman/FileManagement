package fileManagment.ImportingFiles;
import fileManagment.EncryptedDecrypted.Decrypted;
import fileManagment.EncryptedDecrypted.DecryptedContentBonus;
import fileManagment.EncryptedDecrypted.Encrypted;
import fileManagment.EncryptedDecrypted.EncryptedContentBonus;

import fileManagment.Main;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class FilesImporter {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void importFiles(Connection connection, int version){
        logger.info("Inside the importFiles function");
        Scanner sc= new Scanner(System.in);
        String path,fileType,fileSize,fileName;
        StringBuilder copyfileName ;
        int c;
            System.out.println("Please enter file path: ");
            path = sc.next();
            logger.info("Enter the file path : " + path);
            System.out.println("please enter file type : ");
            fileType = sc.next();
            logger.info("Enter the file type : " + fileType);
            System.out.println("please enter file size : ");
            fileSize = sc.next();
            logger.info("Enter the file type : " + fileSize);
            File file = new File(path);
            logger.info("created the file");
            fileName= file.getName();
            copyfileName = new StringBuilder(fileName);
            logger.info("created the StringBuilder");
            System.out.println(copyfileName);
            c = FilesChecker.fileExists(copyfileName,fileType,version,connection);
            while (c!= 0){
                version++;
                c = FilesChecker.fileExists(copyfileName,fileType,version,connection);
            }

            Encrypted.encrypted(copyfileName);
            System.out.println("enc  " + copyfileName);
            EncryptedContentBonus.encrypted(path);
            Decrypted.decrypted(copyfileName);
            System.out.println("dec  " + copyfileName);
            DecryptedContentBonus.Dycrept(path);


            System.out.println(" name : " + file.getName() + " size : " + file.length() + " size : " + fileSize + " new name: " + copyfileName);
            importerToDB.importingInfoToDB(file,copyfileName, fileType, fileSize,version,connection);
            if(version != 0) {
                copyfileName.replace(fileName.length(), fileName.length() + 3, "(" + version + ")");
            }
            logger.info("Inter to the savingFiles function");
            fileSaver.savingFiles(copyfileName,connection);
    }
}