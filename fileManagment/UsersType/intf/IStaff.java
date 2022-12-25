package fileManagment.UsersType.intf;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;

import java.sql.SQLException;

public interface IStaff {
    void displayMenu();
    void staffOperation() throws SQLException, NullObjectException, IOFileException;
}
