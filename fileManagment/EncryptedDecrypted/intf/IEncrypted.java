package fileManagment.EncryptedDecrypted.intf;

import Exceptions.IOFileException;

public interface IEncrypted {
    void Encrypt(String name) throws IOFileException;
}
