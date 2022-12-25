package fileManagment.ImportingFiles;
import Exceptions.IOFileException;
import Exceptions.SQLQueryException;
import fileManagment.ImportingFiles.intf.IFileReader;
import fileManagment.ImportingFiles.intf.IimporterToDB;
import fileManagment.Main;
import org.apache.log4j.Logger;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class importerToDB implements IimporterToDB {
    private final static Logger logger = Logger.getLogger(Main.class);
    private static final String INSERTFILESINFOQUERY = " insert into FILESINFO (name, type, size, version,content)" + " values (?, ?, ?,?,?)";
    public void importingInfoToDB(File file ,StringBuilder name, String type,String size, int version,Connection connection) throws SQLQueryException, IOFileException {
        logger.info("Inside the importingInfoToDB function");
        try {
            System.out.println("Inserting records into the table...");
            logger.info("create the query");
            PreparedStatement preparedStmt = connection.prepareStatement(INSERTFILESINFOQUERY);
            String fileName = name.toString();
            preparedStmt.setString(1, fileName);
            preparedStmt.setString(2, type);
            preparedStmt.setString(3, size);
            preparedStmt.setInt(4, version);
            IFileReader iFileReader = new filesReader();
            byte[] content = iFileReader.ReadingContentAsBytes(file.getPath());

            Blob ContentBlob = new SerialBlob(content);
            preparedStmt.setBlob(5,ContentBlob);
            preparedStmt.execute();
            logger.info("execute the query");
            System.out.println("success");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void importCustomCategoryToDB(String nameClassification,String name, String type,String size, Connection connection) throws SQLQueryException {
        try {
            System.out.println("Inserting records into the table...");
            String query = " insert into customCategory(nameClassification,name, type, size)" + " values (?,?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nameClassification);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, type);
            preparedStmt.setString(4, size);
            preparedStmt.execute();
            System.out.println("success");

        } catch (SQLException e) {
            throw new SQLQueryException("Import file information to DB failed ");
        }
    }
}
