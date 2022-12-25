package fileManagment.OverwriteFiles;
import fileManagment.ImportingFiles.StoreContentToFile;
import fileManagment.ImportingFiles.FilesChecker;
import fileManagment.ImportingFiles.filesReader;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class overwite {
    private static final String UPDATEQUERY = "update FILESINFO set content = ?";

    public static void overwitting(Connection connection){
        Scanner scanner = new Scanner(System.in);
        String fileType,path;
        StringBuilder fileName;
        int fileVersion,fileId;
        System.out.println("Please enter file name: ");
        fileName= new StringBuilder(scanner.next());
        System.out.println("Please enter file type: ");
        fileType= scanner.next();
        System.out.println("Please enter file version: ");
        fileVersion= scanner.nextInt();
        System.out.println("Please enter file path: ");
        path = scanner.next();

        fileId = FilesChecker.fileExists(fileName,fileType,fileVersion,connection);
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(UPDATEQUERY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(fileId!=0){
            byte[] content = filesReader.ReadingContentAsBytes(path);
            Blob blob;
            try {
                blob = new SerialBlob(content);
                preparedStmt.setBlob(1,blob);
                preparedStmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        String fileSeparator = System.getProperty("file.separator");
        String absoluteFilePath = fileSeparator+"C:"+fileSeparator+"FilesFromImporter"+fileSeparator + fileName + ".txt";
        StoreContentToFile.storingContent(connection,absoluteFilePath);

    }
}
