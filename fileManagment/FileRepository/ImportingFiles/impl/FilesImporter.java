package fileManagment.FileRepository.ImportingFiles.impl;
import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;
import fileManagment.EncryptedDecrypted.impl.Encrypted;
import fileManagment.EncryptedDecrypted.impl.EncryptedContentBonus;
import fileManagment.EncryptedDecrypted.intf.IEncrypted;
import fileManagment.FileRepository.ImportingFiles.intf.IFileChecker;
import fileManagment.FileRepository.ImportingFiles.intf.IFileImporter;
import fileManagment.FileRepository.ImportingFiles.intf.IFileSaver;
import fileManagment.FileRepository.ImportingFiles.intf.IimporterToDB;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class FilesImporter implements IFileImporter {
    private final static Logger logger = Logger.getLogger(Main.class);
    public void importFiles(Connection connection, int version) throws SQLQueryException, IOFileException, NullObjectException {
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
            IFileChecker iFileChecker = new FilesChecker();
            c = iFileChecker.fileExists(copyfileName,fileType,version,connection);
            while (c!= 0){
                version++;
                c = iFileChecker.fileExists(copyfileName,fileType,version,connection);
            }

            IEncrypted iEncrypted =new Encrypted();
            iEncrypted.Encrypt(copyfileName.toString());
            System.out.println("enc  " + copyfileName);
            IEncrypted iEncryptedContent =new EncryptedContentBonus();
            iEncryptedContent.Encrypt(path);


            System.out.println(" name : " + file.getName() + " size : " + file.length() + " size : " + fileSize + " new name: " + copyfileName);
            IimporterToDB iimporterToDB = new importerToDB();
            iimporterToDB.importingInfoToDB(file,copyfileName, fileType, fileSize,version,connection);
            if(version != 0) {
                copyfileName.replace(fileName.length(), fileName.length() + 3, "(" + version + ")");
            }
            logger.info("Inter to the savingFiles function");
            IFileSaver iFileSaver = new fileSaver();
            iFileSaver.savingFiles(copyfileName,connection);
    }
}