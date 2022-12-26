package fileManagment.UsersType.impl;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.Database.IDBconnection;
import fileManagment.FileRepository.ExportingFiles.ExportFile;
import fileManagment.FileRepository.ExportingFiles.Intf.IExportFile;
import fileManagment.FileRepository.ImportingFiles.impl.FilesImporter;
import fileManagment.FileRepository.ImportingFiles.intf.IFileImporter;
import fileManagment.FileRepository.ImportingFiles.intf.ITableCreator;
import fileManagment.FileRepository.ImportingFiles.impl.TableCreator;
import fileManagment.Main;
import fileManagment.UsersType.intf.IStaff;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Staff implements IStaff {
    private final static Logger logger = Logger.getLogger(Main.class);
    public void displayMenu(){
        logger.info("Inside the displayMenu function");
        System.out.println();
        System.out.println(
                "1. Enter 1 to import Files \n"+
                        "2. Enter 2 to Export Files \n"+
                        "3.Enter -1 to end program"
        );
        System.out.println();
    }
    public static int version = 0;
    public void staffOperation() throws SQLException, NullObjectException, IOFileException {
        logger.info("Inside the staffOperation function");
        Scanner in = new Scanner(System.in);
        IDBconnection idBconnection = new DBconnection();
        Connection connection = idBconnection.getConnection();
        System.out.println("Welcome,Staff");
        while (true) {
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:{
                    logger.info("Inside the case 1");
                    IFileImporter iFileImporter = new FilesImporter();
                    iFileImporter.importFiles(connection, version);
                    break;
                }
                case 2 : {
                    logger.info("Inside the case 2");
                    IExportFile exportfile = new ExportFile();
                    exportfile.exportFile(connection);
                }
                case -1: {
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
