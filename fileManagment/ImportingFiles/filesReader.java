package fileManagment.ImportingFiles;

import Exceptions.IOFileException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class filesReader {
    public static byte[] ReadingContentAsBytes(String path) throws IOFileException {
        File inputFile = new File(path);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            throw new IOFileException("Failed on creating input file stream.");
        }
        byte[] contentAsBytes = new byte[(int)inputFile.length()];
        try {
            fileInputStream.read(contentAsBytes);
        } catch (IOException e) {
            throw new IOFileException("Failed on reading content");
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            throw new IOFileException("Failed in closing input file");
        }
        System.out.println(Arrays.toString(contentAsBytes));
        return contentAsBytes;
    }
}
