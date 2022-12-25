package fileManagment.FileRepository.ImportingFiles.intf;

import Exceptions.IOFileException;

public interface IFileReader {
    byte[] ReadingContentAsBytes(String path) throws IOFileException;
    }
