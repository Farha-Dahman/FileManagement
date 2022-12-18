package fileManagment;

import fileManagment.ImportingFiles.InfoImporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc= new Scanner(System.in);
        Connection connection = DBconnection.getConnection();

        File file = new File("C:/Users/Hp/Downloads/tt.txt");
        FileInputStream fileData = new FileInputStream(file);

        System.out.println("please enter file type");
        String fileType = sc.nextLine();

        System.out.println(" name : " + file.getName() + " size : " + file.length() + " content : "+ fileData);
        InfoImporter.importinginfo(file,fileType, connection);

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
