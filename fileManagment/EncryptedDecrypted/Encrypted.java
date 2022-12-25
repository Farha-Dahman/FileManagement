package fileManagment.EncryptedDecrypted;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encrypted {
    public static void encrypted(StringBuilder name){
        for (int index = 0; index < name.length(); index++) {
            if (name.charAt(index) == '.') {
                name.setCharAt(index, '_');
            }
        }
    }
}
