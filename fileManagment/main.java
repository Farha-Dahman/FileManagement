package fileManagment;

import fileManagment.ImportingFiles.InfoImporter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        Connection connection = DBconnection.getConnection();

        String path,fileType;
        File file;
        BufferedReader reader;
        int exit =0;
        while(exit !=1) {
            System.out.println("Please enter file path: ");
            path = sc.nextLine();
            System.out.println("please enter file type");
            fileType = sc.nextLine();
            file = new File(path);
            reader = new BufferedReader(new FileReader(path));
            String content = reader.readLine();
            //reader.close();
            System.out.println(" name : " + file.getName() + " size : " + file.length() + " content : " + content);
            InfoImporter.importinginfo(file, fileType, content, connection);
            System.out.println("You need to exit program? (0,1) ");
            exit = sc.nextInt();
        }

/*
        try {
            File userFile = new File("C:/Users/Hp/Downloads/tt.txt");
            if (userFile.createNewFile()) {
                System.out.println("File created: " + userFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            /*
            Scanner myReader = new Scanner(userFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
*/

        DBconnection.Close();
    }
}
