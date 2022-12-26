package fileManagment;

import Exceptions.IOFileException;
import Exceptions.NullObjectException;
import fileManagment.UsersType.impl.Admin;
import fileManagment.UsersType.impl.Reader;
import fileManagment.UsersType.impl.Staff;
import java.sql.SQLException;
import java.util.Scanner;

import fileManagment.UsersType.intf.IAdmin;
import fileManagment.UsersType.intf.IReader;
import fileManagment.UsersType.intf.IStaff;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    private final static int ADMIN = 111;
    private final static int STAFF = 122;
    private final static int READER = 133;
    public static void main(String[] args) throws SQLException, NullObjectException, IOFileException {

        logger.info("Here you inside main");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Key to determine if you are an Admin, User or Reader : ");
        int key = in.nextInt();
        if(key == ADMIN){
            IAdmin admin = new Admin();
            admin.AdminOperation();
        }
        else if(key == STAFF){
            IStaff staff = new Staff();
            staff.staffOperation();
        }
        else if(key == READER){
            IReader reader = new Reader();
            reader.ReadingFile();
        }
        else{
            System.out.println("The entered Key is incorrect");
        }
    }
}
