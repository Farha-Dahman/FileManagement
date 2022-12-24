package Exceptions;

import java.io.IOException;

public class IOFileException extends IOException {
    public IOFileException(String message){
        super(message);
    }
}
