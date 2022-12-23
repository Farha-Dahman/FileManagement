package fileManagment.EncryptedDecrypted;
import fileManagment.ImportingFiles.filesReader;

import java.io.UnsupportedEncodingException;
import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DecryptedContentBonus {
    public static byte[] Dycrept(){
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

        //Generate the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();

        //Creating a Cipher object
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }

        //Initializing a Cipher object
        try {
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        //Add data to the cipher
        //File file = new File("C:\\FilesFromImporter\\tt.txt");
        byte[] input = filesReader.ReadingContentAsBytes("C:\\FilesFromImporter\\tt.txt");
        //byte[] input = r.getBytes();
        cipher.update(input);

        //encrypting the data
        byte[] cipherText;
        try {
            cipherText = cipher.doFinal();
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println( new String(cipherText, "UTF8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        //Initializing the same cipher for decryption
        try {
            cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        //Decrypting the text
        byte[] decipheredText;
        try {
            decipheredText = cipher.doFinal(cipherText);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(new String(decipheredText));
        return decipheredText;
    }
}