package fileManagment.VersionControl.RollBack;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class replaceVersion {

    public static void replaceContent(Path pathOfFiles,ResultSet resultSet) throws SQLException {
        searchFile(pathOfFiles,resultSet);



    }

    private static void searchFile(Path pathOfFiles,ResultSet resultSet) throws SQLException {
        ArrayList<String> listOfFilesName = new ArrayList<>(1000);

        while (resultSet.next()) {
            String nameOfFile = resultSet.getString("FileName");
            String typeOfFile = resultSet.getString("Type");
            try {




            } catch (Exception e){

            }



        }



    }


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
}
