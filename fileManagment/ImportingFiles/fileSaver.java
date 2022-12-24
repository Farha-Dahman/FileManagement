package fileManagment.ImportingFiles;

import Exceptions.IOFileException;
import Exceptions.SQLQueryException;

import java.io.*;
import java.sql.*;

public class fileSaver {
    static void savingFiles(StringBuilder name, Connection connection) throws IOFileException, SQLQueryException {

        System.out.println("name is : " + name);
        String fileSeparator = System.getProperty("file.separator");
        String absoluteFilePath = fileSeparator+"C:"+fileSeparator+"FilesFromImporter"+fileSeparator + name + ".txt";
        File file = new File(absoluteFilePath);
        try {
            if(file.createNewFile()){
                System.out.println(absoluteFilePath+" File Created");
            }else System.out.println("File "+absoluteFilePath+" already exists");
        } catch (IOException e) {
            throw new IOFileException("Failed on create file at a specific path ");
        }

        StoreContentToFile.storingContent(connection,absoluteFilePath);
        System.out.println(absoluteFilePath);
        System.out.println();
    }
}
