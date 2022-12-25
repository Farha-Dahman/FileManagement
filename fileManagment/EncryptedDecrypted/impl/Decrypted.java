package fileManagment.EncryptedDecrypted.impl;

import fileManagment.EncryptedDecrypted.intf.IDecrypted;

public class Decrypted implements IDecrypted {
    public void Decrypt(String name){
        name.replace("_",".");
    }
}
