package fileManagment.UsersType;

import fileManagment.Database.DBconnection;
import fileManagment.ImportingFiles.FilesImporter;
import fileManagment.ImportingFiles.TableCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Staff {
    public static void displayMenu(){
        System.out.println();
        System.out.println(
                "1. Enter 1 to import Files \n"+
                        "2. Enter 2 to Export Files \n"+
                        "3.Enter  -1 to end program"
        );
        System.out.println();
    }
    public static int version = 0;
    public static void staffOperation() throws SQLException {
        Scanner in = new Scanner(System.in);
        Connection connection = DBconnection.getConnection();
        System.out.println("Welcome,Staff");
        while (true) {
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:{
                    TableCreator.creatingTableForFilesInfo(connection);
                    FilesImporter.importFiles(connection, version);
                    break;
                }
                case 2 : {

                }
                case -1: {
                    DBconnection.Close();
                    System.out.println("end of program");
                    return;
                }
                default:
                    System.out.println("Please re_enter the number to a valid number:");
            }

        }
    }
}
