package fileManagment.EncryptedDecrypted;

public class Decrypted {
    public static void decrypted(StringBuilder name){
        for (int index = 0; index < name.length(); index++) {
            if (name.charAt(index) == '_') {
                name.setCharAt(index, '.');
            }
        }
    }
}
