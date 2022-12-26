package fileManagment.EncryptedDecrypted.impl;

import fileManagment.EncryptedDecrypted.intf.IEncrypted;

public class Encrypted implements IEncrypted {
    public void Encrypt(StringBuilder name){
        for (int index = 0; index < name.length(); index++) {
            if (name.charAt(index) == '.') {
                name.setCharAt(index, '_');
            }
        }
    }
}
