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

        File file = new File("C:/Users/Hp/Downloads/tt.txt");
        FileInputStream fileData = new FileInputStream(file);

        System.out.println("please enter file type");
        String fileType = sc.nextLine();

        String ff = "C:/Users/Hp/Downloads/tt.txt";
        BufferedReader reader = new BufferedReader(new FileReader(ff));
        String currentLine = reader.readLine();
        reader.close();
        System.out.println(currentLine);

        System.out.println(" name : " + file.getName() + " size : " + file.length() + " content : "+ currentLine);
        InfoImporter.importinginfo(file,fileType,currentLine ,connection);
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
