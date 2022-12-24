package fileManagment.FileRepository.DisplayFiles;

import fileManagment.VersionControl.RollBack.IlastVersion;
import fileManagment.VersionControl.RollBack.LastVersion;

import java.sql.*;
import java.util.ArrayList;

public class PrintAvailableFiles {
    private static final int CAPACITY_OF_LIST = 10000;
    public void printFiles(Connection connection) {
        ArrayList<String> listOfFilesName = new ArrayList<>(CAPACITY_OF_LIST);
        int index = 0;
        try {
            String query = "SELECT * FROM filesinfo";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            IlastVersion ilastVersion = new LastVersion();

            while (resultSet.next()) {
                String filename = resultSet.getString("name");
                String filetype = resultSet.getString("type");
                int max_version = ilastVersion.lastVersion(connection,filename,filetype);
                if(max_version > 0){
                    filename = filename + "(" + max_version + ")";
                }
                if(!IsExist(listOfFilesName,filename)) {
                    System.out.format("%s%s%s\n", filename, ".", filetype);
                }
                listOfFilesName.add(index,filename);
                index++;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean IsExist(ArrayList<String> listOfFilesName, String nameOfFile) {
        boolean isExists = listOfFilesName.stream().anyMatch(string -> string.equals(nameOfFile));
        return isExists;
    }
}




