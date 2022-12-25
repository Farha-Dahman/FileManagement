package fileManagment.EncryptedDecrypted.impl;

import fileManagment.EncryptedDecrypted.intf.IDecrypted;

public class Decrypted implements IDecrypted {
    public void decrypted(StringBuilder name){
        for (int index = 0; index < name.length(); index++) {
            if (name.charAt(index) == '_') {
                name.setCharAt(index, '.');
            }
        }
    }
}
