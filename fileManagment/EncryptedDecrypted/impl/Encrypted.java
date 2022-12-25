package fileManagment.EncryptedDecrypted.impl;

import fileManagment.EncryptedDecrypted.intf.IEncrypted;

public class Encrypted implements IEncrypted {
    public void Encrypt(String name){
        name.replace(".","_");
    }
}
