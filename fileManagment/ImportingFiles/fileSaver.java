package fileManagment.ImportingFiles;

import java.io.*;
import java.util.Arrays;

public class fileSaver {
    static void savingFiles(StringBuilder name, String path) {
        String fileSeparator = System.getProperty("file.separator");

        //absolute file name with path
        String absoluteFilePath = fileSeparator+"C:"+fileSeparator+"FilesFromImporter"+fileSeparator+name;
        File file = new File(absoluteFilePath);
        try {
            if(file.createNewFile()){
                System.out.println(absoluteFilePath+" File Created");
            }else System.out.println("File "+absoluteFilePath+" already exists");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//System.out.println("f1 : ");
        /*
        //file name only
        file = new File(path);
        try {
            if(file.createNewFile()){
                System.out.println(name + " File Created in Project root directory");
            }else System.out.println("File "+name+" already exists in the project root directory");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //relative path
        String relativePath = "C:"+fileSeparator+ name;
        file = new File(relativePath);
        try {
            if(file.createNewFile()){
                System.out.println(relativePath+" File Created in Project root directory (relative) ");
            }else System.out.println("File "+relativePath+" already exists in the project root directory(relative)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


*/
        /*
        File outputFile = new File("C:\\Users\\MASS\\FilesFromDB\\" + name);
        File inputFile = new File(path);
        PrintWriter printWriter = new PrintWriter(outputFile);
        printWriter.write(inputFile);
        printWriter.close();
        String userHomeFolder = System.getProperty("C:\\FilesFromImporter\\" + name);
        File textFile = new File(userHomeFolder, path);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(textFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

*/
        //////////
        /*
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
        }*/
    }

    //
}
