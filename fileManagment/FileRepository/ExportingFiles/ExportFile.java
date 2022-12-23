package fileManagment.FileRepository.ExportingFiles;

import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExportFile {
    private static final int CAPACITY_OF_LIST = 10000;
    public void exportFile(Connection connection) throws SQLException {
        InputInfo inputInfo = new InputFileInfo();
        ResultSet resultSet = inputInfo.insertInfo(connection);
        ArrayList<String> listOfFilesName = new ArrayList<>(CAPACITY_OF_LIST);
        int index = 0;
        int count =0;

        while(resultSet.next()) {
            String nameOfFile = resultSet.getString("FileName");
            String typeOfFile = resultSet.getString("Type");

            try {
                String nameFile = nameOfFile + "." + typeOfFile;
                if(fileIsExist(listOfFilesName,nameFile)){
                    count++;
                    nameOfFile = nameOfFile + "(" + count + ")";
                } else {
                    count =0;
                }
                File file = new File("C:\\Users\\MASS\\FilesFromDB\\" + nameOfFile + "." + typeOfFile);
                listOfFilesName.add(index, nameFile);
                index++;
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.write(resultSet.getString("Content"));
                printWriter.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
}
    private boolean fileIsExist(ArrayList<String> listOfFilesName, String nameOfFile) {
        boolean isExists = listOfFilesName.stream().anyMatch(string -> string.equals(nameOfFile));
        return isExists;
    }
}
