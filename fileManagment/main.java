package fileManagment;
import fileManagment.DeleteFile.deleteFile;
import fileManagment.ImportingFiles.FilesImporter;
import fileManagment.ImportingFiles.TableCreator;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class main {
    public static void displayMenu(){
        System.out.println();
        System.out.println(
                "1. Enter 1 to import Files \n"+
                        "2. Enter 2 to \n"+
                        "3. Enter 3 to delete file by name\n"+
                        "4. Enter 4 to delete by classify \n"+
                        "5.Enter  -1 to end program"
        );
        System.out.println();
    }
    public static void main(String[] args)throws IOException {
        Scanner in = new Scanner(System.in);
        deleteFile deleteFile=new deleteFile();
        Connection connection = DBconnection.getConnection();
        while (true) {
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:{
                    // TableCreator.creatingTableForFilesInfo(connection);
                    FilesImporter.importFiles(connection);
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

