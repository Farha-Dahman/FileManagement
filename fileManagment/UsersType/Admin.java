package fileManagment.UsersType;
import fileManagment.Database.DBconnection;
import fileManagment.DeleteFile.deleteFile;
import fileManagment.ImportingFiles.FilesImporter;
import fileManagment.ImportingFiles.importerToDB;
import fileManagment.ImportingFiles.TableCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    public static void displayMenu(){
        System.out.println();
        System.out.println(
                "1. Enter 1 to import Files \n"+
                        "2. Enter 2 to \n"+
                        "3. Enter 3 to delete file by name\n"+
                        "4. Enter 4 to delete by classify \n"+
                        "5. Enter 5 to create custom category classification\n"+
                        "6. Enter  -1 to end program"
        );
        System.out.println();
    }
    public static int version = 0;
    public static void AdminOperation() throws SQLException {
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
                    TableCreator.creatingTableForFilesInfo(connection);
                    FilesImporter.importFiles(connection,version);
                    break;
                }
                case 3: {
                    System.out.println("Enter the name of the file you wont to delete:");
                    String FileName = in.next();
                    deleteFile.deleteFileByName(FileName);
                    break;
                }
                case 4:{

                    System.out.println("Enter the number 1 if you want to delete by type or enter the number 2 if you want to delete by size :");
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
                    else{
                        System.out.println("The entered number is incorrect,please reenter 1 or 2.");
                    }
                    break;
                }
                case 5:{
                    //   FileClassification.CreateTableClassification(connection);
                    System.out.println("Enter null for the one you do not want to create a classify on :\n");
                    System.out.println("Enter File Name :");
                    String FileName=in.next();
                    System.out.println("Enter Type of File :");
                    String FileType=in.next();
                    System.out.println("Enter Size(large,medium,small) of File :");
                    String FileSize=in.next();
                    System.out.println("Enter name of classification:");
                    String classificationName=in.next();
                    importerToDB.importCustomCategoryToDB(classificationName,FileName,FileType,FileSize,connection);
                    break;
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