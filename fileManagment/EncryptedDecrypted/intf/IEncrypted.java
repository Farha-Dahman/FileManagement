package fileManagment.EncryptedDecrypted.intf;

import Exceptions.IOFileException;

public interface IEncrypted {
    void Encrypt(StringBuilder name) throws IOFileException;
}
