package fileManagment.ImportingFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class filesReader {
    public static byte[] ReadingContentAsBytes(String path){
        File inputfile = new File(path);
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(inputfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        byte[] arr = new byte[(int)inputfile.length()];
        try {
            inputFile.read(arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            inputFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(arr);
        return arr;
    }
}
