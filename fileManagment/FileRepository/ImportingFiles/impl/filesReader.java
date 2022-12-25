package fileManagment.FileRepository.ImportingFiles.impl;

import Exceptions.IOFileException;
import fileManagment.FileRepository.ImportingFiles.intf.IFileReader;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class filesReader implements IFileReader {
    private final static Logger logger = Logger.getLogger(Main.class);
    public byte[] ReadingContentAsBytes(String path) throws IOFileException {
        logger.info("Inside the ReadingContentAsBytes function");
        File inputfile = new File(path);
        logger.info("create the File");
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(inputfile);
            logger.info("create the FileInputStream");

        } catch (FileNotFoundException e) {
            throw new IOFileException("Failed on creating input file stream.");
        }

        byte[] ContentsArrayAsBytes = new byte[(int)inputfile.length()];
        try {
            inputFile.read(ContentsArrayAsBytes);
            logger.info("read the array of byte");
        } catch (IOException e) {
            throw new IOFileException("Failed on reading content");
        }
        try {
            inputFile.close();
            logger.info("close the FileInputStream");
        } catch (IOException e) {
            throw new IOFileException("Failed in closing input file");
        }
        System.out.println(Arrays.toString(ContentsArrayAsBytes));
        return ContentsArrayAsBytes;
    }
}
