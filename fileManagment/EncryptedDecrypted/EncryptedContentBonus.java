package fileManagment.EncryptedDecrypted;
import fileManagment.ImportingFiles.filesReader;

import java.io.UnsupportedEncodingException;
import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptedContentBonus {
    public static byte[] encrypted(){
        //Creating a Signature object
        try {
            Signature sign = Signature.getInstance("SHA256withRSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Creating a Cipher object
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }

        //Initializing a Cipher object
        try {
            cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        //Adding data to the cipher
        //byte[] input = "Welcome to Tutorialspoint".getBytes();
        byte[] input = filesReader.ReadingContentAsBytes("C:\\FilesFromImporter\\tt.txt");
        cipher.update(input);

        //encrypting the data
        byte[] cipherText = new byte[0];
        try {
            cipherText = cipher.doFinal();
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(new String(cipherText, "UTF8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return cipherText;
    }
}