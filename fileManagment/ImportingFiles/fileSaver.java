package fileManagment.ImportingFiles;

import java.io.*;

public class fileSaver {
    static void savingFiles(StringBuilder name, String path) {
        FileOutputStream saveFile;
        String fileName = name.toString();
        try {
            saveFile = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream save;
        try {
            save = new ObjectOutputStream(saveFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            save.writeObject(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
