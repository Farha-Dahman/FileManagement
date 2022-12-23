package fileManagment.VersionControl.RollBack;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class replaceVersion {

    private static final int CAPACITY_OF_LIST = 1000;

    public static void replaceContent(ResultSet resultSet) throws SQLException, IOException {
        searchFile(resultSet);


    }

    private static void searchFile(ResultSet resultSet) throws IOException, SQLException {
        ArrayList<String> listOfFilesName = new ArrayList<>(CAPACITY_OF_LIST);

        File directory = new File("C:\\Users\\MASS\\FilesFromDB");
        Desktop.getDesktop().open(directory);

        while (resultSet.next()) {
            String nameOfFile = resultSet.getString("FileName");
            String typeOfFile = resultSet.getString("Type");
//            try {
//                if(fileIsExist(listOfFilesName,nameOfFile)){
//                    count++;
//                    nameOfFile = nameOfFile + "(" + count + ")";
//                }
//
//        }

        }
    }
}

//        String listOfFilesName[] = directory.list();
//        System.out.println("List of files and directories in the specified directory:");
//        for (int i = 0; i < listOfFilesName.length; i++) {
//            System.out.println(listOfFilesName[i]);
//        }

//    public ResultSet getFile(Connection connection, String nameFile, String typeFile){
//        ResultSet resultSet = null;
//        try {
//            String query = "select * from files WHERE FileName = (?) and Type = (?)";
//            PreparedStatement prepareStatement = connection.prepareStatement(query);
//            prepareStatement.setString(1, nameFile);
//            prepareStatement.setString(2, typeFile);
//            resultSet = prepareStatement.executeQuery();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return resultSet;
//    }
//*****

//        while (resultSet.next()) {
//            String nameOfFile = resultSet.getString("FileName");
//            String typeOfFile = resultSet.getString("Type");
//            try {
//                String nameFile = nameOfFile + "." + typeOfFile;
//
//            } catch (Exception e){
//
//            }