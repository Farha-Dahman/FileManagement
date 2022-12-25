package fileManagment.FileRepository.ExportingFiles;

import Exceptions.SQLQueryException;
import fileManagment.FileRepository.ExportingFiles.Intf.Iapis;
import fileManagment.FileRepository.ExportingFiles.Intf.InputInfo;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public class InputFileInfo implements InputInfo {
    private static Logger logger = Logger.getLogger(Main.class);
    @Override
    public ResultSet insertInfo(Connection connection) throws SQLQueryException {
        logger.info("Inside the insertInfo function");
        String Choose;
        ResultSet resultSet = null;
        Iapis iapis = new apis();
        Scanner user = new Scanner(System.in);
        logger.info("Create the Scanner object");
        System.out.print("Insert your choose: ");
        Choose = user.nextLine().trim();
        logger.info("the Choose of the user is : " + Choose);
        if (Choose.equals("name")) {
            logger.info("user choose name");
            System.out.print("Input File Name: ");
            resultSet = iapis.getByName(connection, user.nextLine().trim());

        } else if (Choose.equals("type")) {
            logger.info("user choose type");
            System.out.print("Input File Type: ");
            resultSet = iapis.getByType(connection, user.nextLine().trim());

        } else if (Choose.equals("size")) {
            logger.info("user choose size");
            System.out.print("Input File Size: ");
            resultSet = iapis.getBySize(connection, user.nextLine().trim());
        } else if (Choose.equals("custom")) {
            logger.info("user choose custom");
            System.out.print("Input custom name: ");


        }
        logger.info("returned the resultSet");
        return resultSet;
    }
}