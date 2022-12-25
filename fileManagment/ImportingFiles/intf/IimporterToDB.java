package fileManagment.ImportingFiles.intf;

import Exceptions.IOFileException;
import Exceptions.SQLQueryException;

import java.io.File;
import java.sql.Connection;

public interface IimporterToDB {
    void importingInfoToDB(File file , StringBuilder name, String type, String size, int version, Connection connection) throws SQLQueryException, IOFileException;
    void importCustomCategoryToDB(String nameClassification,String name, String type,String size, Connection connection) throws SQLQueryException ;

    }
