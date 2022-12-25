package fileManagment.UsersType;
import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.DeleteFile.deleteFile;
import fileManagment.FileClassification.printTableCustomCategory;
import fileManagment.FileRepository.ExportingFiles.ExportFile;
import fileManagment.ImportingFiles.*;


import fileManagment.ImportingFiles.intf.IFileImporter;
import fileManagment.ImportingFiles.intf.ITableCreator;
import fileManagment.ImportingFiles.intf.IimporterToDB;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    private final static Logger logger = Logger.getLogger(Main.class);
    public static void displayMenu(){
        logger.info("Inside the displayMenu function");
        System.out.println();
        System.out.println(
                "1. Enter 1 to import Files \n"+
                        "2. Enter 2 to export files\n"+
                        "3. Enter 3 to delete file by name\n"+
                        "4. Enter 4 to delete by classify \n"+
                        "5. Enter 5 to create custom category classification\n"+
                        "6. Enter 6 to show all available classification\n"+
                        "7. Enter  -1 to end program"
        );
        System.out.println();
    }
    private static int version = 0;
    public static void AdminOperation() throws SQLException, NullObjectException, IOFileException {
        logger.info("Inside the AdminOperation function");
        Scanner in = new Scanner(System.in);
        deleteFile deleteFile=new deleteFile();
        Connection connection = DBconnection.getConnection();
        System.out.println("Welcome,Admin");
        while (true) {
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:{
                    logger.info("Inside the case 1");
                    ITableCreator iTableCreator = new TableCreator();
                    iTableCreator.creatingTableForFilesInfo(connection);
                    IFileImporter iFileImporter = new FilesImporter();
                    iFileImporter.importFiles(connection,version);
                    break;
                }
                case 2:{
                    logger.info("Inside the case 1");
                    ExportFile exportfile = new ExportFile();
                    exportfile.exportFile(connection);
                    break;
                }
                case 3: {
                    logger.info("Inside the case 3");
                    System.out.println("Enter the name of the file you wont to delete:");
                    String FileName = in.next();
                    deleteFile.deleteFileByName(FileName);
                    break;
                }
                case 4:{

        System.out.println("Enter the number 1 if you want to delete by type or enter the number 2 if you want to delete by size Enter number 3 if you want to delete by customCategory :");
        int classifyChoice=in.nextInt();
        if(classifyChoice==1){
        System.out.println("Enter the Type of the file you wont to delete:");
        String FileType = in.next();
        deleteFile.deleteFileByType(FileType);
        }
        else if(classifyChoice==2){
        System.out.println("Enter the size(large,medium,small) of the file you wont to delete:");
        String FileSize = in.next();
        deleteFile.deleteFileByType(FileSize);
        }
        else if(classifyChoice==3){
        printTableCustomCategory.printTableClassification(connection);
        System.out.println("Enter the name of customClassification:");
        String nameClassification=in.next();
        deleteFile.deleteBycustomCategory(nameClassification);
        }
        else{
        System.out.println("The entered number is incorrect,please reenter 1 or 2 or 3.");
        }
        break;
                }
                case 5:{
                    //FileClassification.CreateTableClassification(connection);
                    logger.info("Inside the case 5");
                    System.out.println("Enter null for the one you do not want to create a classify on :\n");
                    System.out.println("Enter File Name :");
                    String FileName=in.next();
                    System.out.println("Enter Type of File :");
                    String FileType=in.next();
                    System.out.println("Enter Size(large,medium,small) of File :");
                    String FileSize=in.next();
                    System.out.println("Enter name of classification:");
                    String classificationName=in.next();
                    IimporterToDB iimporterToDB = new importerToDB();
                    iimporterToDB.importCustomCategoryToDB(classificationName,FileName,FileType,FileSize,connection);
                    break;
                }
                case 6:{
                    printTableCustomCategory.printTableClassification(connection);
                    break;
                }
                case -1: {
                    logger.info("Inside the case -1");
                    DBconnection.Close();
                    System.out.println("end of program");
                    return;
                }
                default:
                    logger.info("Inside the default case");
                    System.out.println("Please re_enter the number to a valid number:");
            }

        }
    }
}
