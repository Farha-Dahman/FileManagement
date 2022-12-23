package fileManagment.VersionControl.RollBack;

import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertFileInfo implements InputInfo {
    @Override
    public ResultSet insertInfo(Connection connection) {
            ResultSet resultSet = null;
            System.out.print("Input File Name: ");
            Scanner fileName = new Scanner(System.in);
            String nameFile = fileName.nextLine().trim();
            System.out.print("Input File Type: ");
            Scanner fileType = new Scanner(System.in);
            String typeFile = fileType.nextLine().trim();

            return resultSet;
    }
}
