package fileManagment.ImportingFiles;

import fileManagment.Main;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class filesReader {
    private static Logger logger = Logger.getLogger(Main.class);
    public static byte[] ReadingContentAsBytes(String path){
        logger.info("Inside the ReadingContentAsBytes function");
        File inputfile = new File(path);
        logger.info("create the File");
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(inputfile);
            logger.info("create the FileInputStream");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        byte[] arr = new byte[(int)inputfile.length()];
        try {
            inputFile.read(arr);
            logger.info("read the array of byte");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            inputFile.close();
            logger.info("close the FileInputStream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(arr);
        return arr;
    }
}
