package fileManagment.UsersType.impl;
import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.Database.IDBconnection;
import fileManagment.FileRepository.DeleteFile.IdeleteFile;
import fileManagment.FileRepository.DeleteFile.deleteFile;
import fileManagment.FileClassification.printTableCustomCategory;
import fileManagment.FileRepository.ExportingFiles.ExportFile;
import fileManagment.FileRepository.ExportingFiles.Intf.IExportFile;


import fileManagment.FileRepository.ImportingFiles.impl.FilesImporter;
import fileManagment.FileRepository.ImportingFiles.impl.TableCreator;
import fileManagment.FileRepository.ImportingFiles.impl.importerToDB;
import fileManagment.FileRepository.ImportingFiles.intf.IFileImporter;
import fileManagment.FileRepository.ImportingFiles.intf.ITableCreator;
import fileManagment.FileRepository.ImportingFiles.intf.IimporterToDB;
import fileManagment.Main;
import fileManagment.UsersType.intf.IAdmin;
import fileManagment.VersionControl.OverwriteFiles.IOverwrite;
import fileManagment.VersionControl.OverwriteFiles.overwite;
import fileManagment.VersionControl.RollBack.RollBack;
import fileManagment.VersionControl.RollBack.intf.IRollBack;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin implements IAdmin {
    private final static Logger logger = Logger.getLogger(Main.class);
    public void displayMenu(){
        logger.info("Inside the displayMenu function");
        System.out.println();
        System.out.println(
                "1. Enter 1 to import Files \n"+
                        "2. Enter 2 to export files\n"+
                        "3. Enter 3 to delete file by name\n"+
                        "4. Enter 4 to delete by classify \n"+
                        "5. Enter 5 to create custom category classification\n"+
                        "6. Enter 6 to show all available classification\n"+
                        "7. Enter 7 to make RollBack\n"+
                        "8. Enter 8 to make overWrite\n"+
                        "9. Enter -1 to end program"
        );
        System.out.println();
    }
    private static int version = 0;
    public void AdminOperation() throws SQLException, NullObjectException, IOFileException {
        logger.info("Inside the AdminOperation function");
        Scanner in = new Scanner(System.in);
        IdeleteFile ideleteFile=new deleteFile();
        IDBconnection idBconnection = new DBconnection();
        Connection connection = idBconnection.getConnection();
        System.out.println("Welcome,Admin");
        while (true) {
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:{
                    logger.info("Inside the case 1");
                    //ITableCreator iTableCreator = new TableCreator();
                    //iTableCreator.creatingTableForFilesInfo(connection);
                    IFileImporter iFileImporter = new FilesImporter();
                    iFileImporter.importFiles(connection,version);
                    break;
                } case 2:{
                    logger.info("Inside the case 1");
                    IExportFile exportfile = new ExportFile();
                    exportfile.exportFile(connection);
                    break;
                } case 3: {
                    logger.info("Inside the case 3");
                    System.out.println("Enter the name of the file you wont to delete:");
                    String FileName = in.next();
                    ideleteFile.deleteFileByName(FileName);
                    break;
                } case 4:{
                    System.out.println("Enter the number 1 if you want to delete by type or enter the number 2 if you want to delete by size Enter number 3 if you want to delete by customCategory :");
                    int classifyChoice=in.nextInt();
                    if(classifyChoice==1){
                    System.out.println("Enter the Type of the file you wont to delete:");
                    String FileType = in.next();
                    ideleteFile.deleteFileByType(FileType);
                    }
                    else if(classifyChoice==2){
                    System.out.println("Enter the size(large,medium,small) of the file you wont to delete:");
                    String FileSize = in.next();
                    ideleteFile.deleteFileBySize(FileSize);
                    }
                    else if(classifyChoice==3){
                    printTableCustomCategory.printTableClassification(connection);
                    System.out.println("Enter the name of customClassification:");
                    String nameClassification=in.next();
                    ideleteFile.deleteBycustomCategory(nameClassification);
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
                } case 6:{
                    printTableCustomCategory.printTableClassification(connection);
                    break;
                } case 7: {
                    logger.info("Inside the case 7");
                    IRollBack iRollBack = new RollBack();
                    iRollBack.rollBack(connection);
                    break;
                } case 8: {
                    logger.info("Inside the case 8");
                    IOverwrite iOverwrite = new overwite();
                    iOverwrite.overwitting(connection);
                    break;
                } case -1: {
                    logger.info("Inside the case -1");
                    idBconnection.Close();
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
