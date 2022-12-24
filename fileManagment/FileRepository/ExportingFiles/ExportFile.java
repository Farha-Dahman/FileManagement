package fileManagment.FileRepository.ExportingFiles;

import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;
import fileManagment.VersionControl.RollBack.IlastVersion;
import fileManagment.VersionControl.RollBack.LastVersion;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExportFile {
    private static final int CAPACITY_OF_LIST = 10000;
    public void exportFile(Connection connection) throws SQLException {
        InputInfo inputInfo = new InputFileInfo();
        ResultSet resultSet = inputInfo.insertInfo(connection);
        IlastVersion ilastVersion = new LastVersion();

        while (resultSet.next()) {
            String nameOfFile = resultSet.getString("FileName");
            String typeOfFile = resultSet.getString("Type");
            int max_version = ilastVersion.lastVersion(connection,nameOfFile,typeOfFile);

            if(max_version > 0){
                nameOfFile = nameOfFile + "(" + max_version + ")";
            }

            try {
                File file = new File("C:\\Users\\MASS\\FilesFromDB\\" + nameOfFile + "." + typeOfFile);

                PrintWriter printWriter = new PrintWriter(file);
                printWriter.write(resultSet.getString("Content"));
                printWriter.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

}
    public boolean fileIsExist(ArrayList<String> listOfFilesName, String nameOfFile) {
        boolean isExists = listOfFilesName.stream().anyMatch(string -> string.equals(nameOfFile));
        return isExists;
    }
}
