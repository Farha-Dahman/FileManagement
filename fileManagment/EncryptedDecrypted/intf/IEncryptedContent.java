package fileManagment.EncryptedDecrypted.intf;

import Exceptions.IOFileException;

public interface IEncryptedContent {
    byte[] Encrypt(String path) throws IOFileException;
}
