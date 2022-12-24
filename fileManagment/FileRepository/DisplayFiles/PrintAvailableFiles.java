package fileManagment.FileRepository.DisplayFiles;

import fileManagment.Main;
import fileManagment.VersionControl.RollBack.IlastVersion;
import fileManagment.VersionControl.RollBack.LastVersion;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;

public class PrintAvailableFiles {
    private static Logger logger = Logger.getLogger(Main.class);
    private static final int CAPACITY_OF_LIST = 10000;
    public void printFiles(Connection connection) {
        logger.info("Inside the printFiles function");
        ArrayList<String> listOfFilesName = new ArrayList<>(CAPACITY_OF_LIST);
        int index = 0;
        try {
            String query = "SELECT * FROM filesinfo";
            logger.info("Created the query");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            logger.info("Created the resultSet");
            IlastVersion ilastVersion = new LastVersion();

            System.out.println("This all available files in your system: ");
            while (resultSet.next()) {
                String filename = resultSet.getString("name");
                String filetype = resultSet.getString("type");
                logger.info("The name file: " + filetype+ " the type : " +filetype);
                int max_version = ilastVersion.lastVersion(connection,filename,filetype);
                if(max_version > 0){
                    filename = filename + "(" + max_version + ")";
                }
                logger.info("Check if the file is exist in the list");
                if(!IsExist(listOfFilesName,filename)) {
                    System.out.format("%s\n", filename);
                }
                logger.info("added the " + filename + " to list");
                listOfFilesName.add(index,filename);
                index++;
            }
            logger.info("closed statement");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean IsExist(ArrayList<String> listOfFilesName, String nameOfFile) {
        logger.info("Into the isExist function");
        boolean isExists = listOfFilesName.stream().anyMatch(string -> string.equals(nameOfFile));
        return isExists;
    }
}




