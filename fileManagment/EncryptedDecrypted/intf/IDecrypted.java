package fileManagment.EncryptedDecrypted.intf;

import Exceptions.IOFileException;

public interface IDecrypted {
    public void Decrypt(String name)throws IOFileException;
}
