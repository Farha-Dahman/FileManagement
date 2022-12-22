package fileManagment.ImportingFiles;

import java.io.*;

public class fileSaver {
    static void savingFiles(File file, String path) {
        FileOutputStream saveFile;
        try {
            saveFile = new FileOutputStream(file.getName());
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
