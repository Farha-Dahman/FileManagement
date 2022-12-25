package fileManagment.DeleteFile;

import Exceptions.NullObjectException;
import Exceptions.SQLQueryException;

public interface IdeleteFile {
        public void deleteByClassefication(String sql,String classification)throws SQLQueryException;
        public void deleteFileByName(String FileName) throws NullObjectException, SQLQueryException;
        public void deleteBycustomCategory(String nameClassification)throws SQLQueryException;
    }

