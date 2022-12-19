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
        File file;
        BufferedReader reader ;
        int exit =0;
        while(exit !=1) {
            System.out.println("Please enter file path: ");
            path = sc.nextLine();
            System.out.println("please enter file type");
            fileType = sc.nextLine();
            file = new File(path);
            try {
                reader = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String content = null;
            try {
                content = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" name : " + file.getName() + " size : " + file.length() + " content : " + content);
            FilesImporter.importingInfoToDB(file, fileType, content, connection);
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
            System.out.println("You need to exit program? (0,1) ");
            exit = sc.nextInt();
        }
    }
    public static void importingInfoToDB(File file, String type,String conent, Connection connection) {
            try {
                System.out.println("Inserting records into the table...");
                String query = " insert into FILESINFO (name, type, size,content)" + " values (?, ?, ?,?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, file.getName());
                preparedStmt.setString(2, type);
                preparedStmt.setFloat(3, file.length());
                preparedStmt.setString(4, conent);
                preparedStmt.execute();
                System.out.println("success");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }