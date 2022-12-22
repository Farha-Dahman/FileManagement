package fileManagment.ImportingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filesReader {
    static File readingFiles(String path) {
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
}
