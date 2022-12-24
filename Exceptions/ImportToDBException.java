package Exceptions;

import java.sql.SQLException;

public class ImportToDBException extends SQLException {

    public ImportToDBException(String message) {

        super(message);
    }
}
