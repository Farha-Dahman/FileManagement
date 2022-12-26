package fileManagment.FileRepository.ImportingFiles.impl;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;
import fileManagment.FileRepository.ImportingFiles.intf.IFileSaver;
import fileManagment.FileRepository.ImportingFiles.intf.IStoreContentToFile;
import fileManagment.Main;
import org.apache.log4j.Logger;
import java.io.*;
import java.sql.*;

public class fileSaver implements IFileSaver {
    private final static Logger logger = Logger.getLogger(Main.class);
    public void savingFiles(StringBuilder name, Connection connection) throws IOFileException, SQLQueryException, NullObjectException {
        logger.debug("Enter to savingFiles function with 2 parameters name and connection");
        logger.info("Inside the savingFiles function");
        System.out.println("name is : " + name);
        logger.info("Name of file" + name);
        String fileSeparator = System.getProperty("file.separator");
        String absoluteFilePath = fileSeparator+"C:"+fileSeparator+"FilesFromImporter"+fileSeparator + name + ".txt";
        logger.info("Create the absoluteFilePath");
        File file = new File(absoluteFilePath);
        try {
            if(file.createNewFile()){
                System.out.println(absoluteFilePath+" File Created");
                logger.info("The File is Created");
            } else {
                System.out.println("File "+ absoluteFilePath +" already exists");
            }
        } catch (IOException e) {
            throw new IOFileException("Failed on create file at a specific path ");
        }
        logger.info("Go to StoreContentToFile class");
        IStoreContentToFile iStoreContentToFile = new StoreContentToFile();
        iStoreContentToFile.storingContent(connection,absoluteFilePath);
        System.out.println(absoluteFilePath);
        logger.info("The absoluteFilePath is: " + absoluteFilePath);
        System.out.println();
        logger.debug("Exit from savingFiles function");
    }
}
