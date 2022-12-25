package fileManagment.FileRepository.ImportingFiles.intf;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;

import java.sql.Connection;

public interface IStoreContentToFile {
    void storingContent(Connection connection, String OutputFilePath) throws SQLQueryException, IOFileException, NullObjectException ;
}
