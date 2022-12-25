package fileManagment.UsersType.intf;

import Exceptions.NullObjectException;

import java.sql.SQLException;

public interface IReader {
    void ReadingFile() throws SQLException, NullObjectException;
}
