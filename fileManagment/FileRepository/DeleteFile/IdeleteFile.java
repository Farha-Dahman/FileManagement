package fileManagment.FileRepository.DeleteFile;

import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;

public interface IdeleteFile {
    public void deleteFileByName(String FileName) throws NullObjectException, SQLQueryException;
    public void deleteFileByType(String FileType) throws NullObjectException, SQLQueryException;
    public void deleteFileBySize(String FileSize) throws NullObjectException, SQLQueryException;
    public void deleteBycustomCategory(String nameClassification)throws SQLQueryException;
    }

