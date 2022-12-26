package fileManagment.FileRepository.ImportingFiles.intf;

import Exceptions.IOFileException;
import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface IimporterToDB {
    void importingInfoToDB(byte[] file , StringBuilder name, String type, String size, int version, Connection connection) throws SQLQueryException, IOFileException;
    void importCustomCategoryToDB(String nameClassification,String name, String type,String size, Connection connection) throws SQLQueryException ;

    }
