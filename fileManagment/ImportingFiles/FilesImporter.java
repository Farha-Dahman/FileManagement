package fileManagment.ImportingFiles;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FilesImporter {

    public static void importFiles(Connection connection){

        Scanner sc= new Scanner(System.in);
        String path,fileType;
        int exit =0;
        while(exit != 1) {
            System.out.println("Please enter file path: ");
            path = sc.next();
            System.out.println("please enter file type : ");
            fileType = sc.next();
            File file = readingFiles(path);
            System.out.println(" name : " + file.getName() + " size : " + file.length());
            FilesImporter.importingInfoToDB(file, fileType, connection);
            savingFiles(file, path);
            System.out.println("You need to exit program? (0,1) ");
            exit = sc.nextInt();}
    }

    private static File readingFiles(String path) {
        File file = null;
        try {
            file = new File(path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return file;
    }

    private static void savingFiles(File file, String path) {
        FileOutputStream saveFile = null;
        try {
            saveFile = new FileOutputStream(file.getName());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream save = null;
        try {
            save = new ObjectOutputStream(saveFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            save.writeObject(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void importingInfoToDB(File file, String type, Connection connection) {
            try {
                System.out.println("Inserting records into the table...");
                String query = " insert into FILESINFO (name, type, size)" + " values (?, ?, ?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, file.getName());
                preparedStmt.setString(2, type);
                preparedStmt.setFloat(3, file.length());
                //preparedStmt.setString(4, conent);
                preparedStmt.execute();
                System.out.println("success");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }