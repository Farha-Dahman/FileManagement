package fileManagment.EncryptedDecrypted;
public class Encrypted {
    public static void encrypted(StringBuilder name){
        for (int index = 0; index < name.length(); index++) {
            if (name.charAt(index) == '.') {
                name.setCharAt(index, '_');
            }
        }
    }
}
