package fileManagment.ImportingFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class filesReader {
    static byte[] readingFiles(String path) {
        /*
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

*/
        byte[] array = ReadingContentAsBytes(path);
        System.out.print(Arrays.toString(array));
        return array;
    }
    public static byte[] ReadingContentAsBytes(String path){
        File inputfile = new File(path);
        FileInputStream fl = null;
        try {
            fl = new FileInputStream(inputfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        byte[] arr = new byte[(int)inputfile.length()];
        try {
            fl.read(arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fl.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(arr);
        return arr;
    }
}
