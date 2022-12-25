package fileManagment.VersionControl.RollBack;

import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertFileInfo implements InputInfo {
    @Override
    public ResultSet insertInfo(Connection connection) throws SQLException {
        System.out.print("Input File Name: ");
        Scanner fileName = new Scanner(System.in);
        String nameFile = fileName.nextLine().trim();
        System.out.print("Input File Type: ");
        Scanner fileType = new Scanner(System.in);
        String typeFile = fileType.nextLine().trim();

        String query = "select * from filesinfo WHERE name = (?) and type = (?)";
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setString(1, nameFile);
        prepareStatement.setString(2, typeFile);
        ResultSet resultSet = prepareStatement.executeQuery();

        return resultSet;
    }
}
