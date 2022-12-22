package fileManagment.FileRepository.ExportingFiles;

import fileManagment.FileRepository.ExportingFiles.Intf.Iapis;
import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public class InputFileInfo implements InputInfo {
    @Override
    public ResultSet insertInfo(Connection connection) {
        String Choose;
        ResultSet resultSet = null;
        Iapis iapis = new apis();
        Scanner user = new Scanner(System.in);
        System.out.print("Insert your choose: ");
        Choose = user.nextLine().trim();
            if (Choose.equals("name")) {
                System.out.print("Input File Name: ");
                resultSet = iapis.getByName(connection, user.nextLine().trim());

            } else if (Choose.equals("type")) {
                System.out.print("Input File Type: ");
                resultSet = iapis.getByType(connection, user.nextLine().trim());

            } else if (Choose.equals("size")) {
                System.out.print("Input File Size: ");
                resultSet = iapis.getBySize(connection, user.nextLine().trim());
            }
        return resultSet;
    }
}