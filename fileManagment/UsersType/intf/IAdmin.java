package fileManagment.UsersType.intf;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;

import java.sql.SQLException;

public interface IAdmin {
    void displayMenu();
    void AdminOperation() throws SQLException, NullObjectException, IOFileException;
}
