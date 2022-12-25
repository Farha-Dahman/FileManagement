package Exceptions;

import java.sql.SQLException;

public class SQLQueryException extends SQLException {

    public SQLQueryException(String message) {

        super(message);
    }
}
