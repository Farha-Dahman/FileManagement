package fileManagment.FileRepository.ExportingFiles;

import Exceptions.NullObjectException;
import fileManagment.FileRepository.ExportingFiles.Intf.IExportFile;
import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;
import fileManagment.Main;
import fileManagment.VersionControl.RollBack.IlastVersion;
import fileManagment.VersionControl.RollBack.LastVersion;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExportFile implements IExportFile {
    private static Logger logger = Logger.getLogger(Main.class);
    public void exportFile(Connection connection) throws SQLException, NullObjectException {
        logger.info("Inside the exportFile function");
        InputInfo inputInfo = new InputFileInfo();
        ResultSet resultSet = inputInfo.insertInfo(connection);
        logger.info("ResultSet created");
        IlastVersion ilastVersion = new LastVersion();

        while (resultSet.next()) {
            String nameOfFile = resultSet.getString("name");
            String typeOfFile = resultSet.getString("type");
            logger.info("the name of file is :" + nameOfFile + " the type is: " + typeOfFile);
            int max_version = ilastVersion.lastVersion(connection,nameOfFile,typeOfFile);
            logger.info("the max version of file is :" + max_version);
            if(max_version > 0){
                nameOfFile = nameOfFile + "(" + max_version + ")";
            }
            try {
                File file = new File("C:\\Users\\MASS\\FilesFromDB\\" + nameOfFile + "." + typeOfFile);
                logger.info("Created new file in the desktop");
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.write(resultSet.getString("content"));
                printWriter.close();
                logger.info("Closed the printWriter");
            } catch (FileNotFoundException e) {
                throw new NullObjectException("Failed on writing file to another (maybe it's empty)");
            }
        }
}
}
