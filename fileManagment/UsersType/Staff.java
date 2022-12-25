package fileManagment.UsersType;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.FileRepository.ExportingFiles.ExportFile;
import fileManagment.ImportingFiles.FilesImporter;
import fileManagment.ImportingFiles.TableCreator;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Staff {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void displayMenu(){
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
    public static void staffOperation() throws SQLException, NullObjectException, IOFileException {
        logger.info("Inside the staffOperation function");
        Scanner in = new Scanner(System.in);
        Connection connection = DBconnection.getConnection();
        System.out.println("Welcome,Staff");
        while (true) {
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:{
                    logger.info("Inside the case 1");
                    TableCreator.creatingTableForFilesInfo(connection);
                    FilesImporter.importFiles(connection, version);
                    break;
                }
                case 2 : {
                    logger.info("Inside the case 2");
                    ExportFile exportfile = new ExportFile();
                    exportfile.exportFile(connection);
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
