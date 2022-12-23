package fileManagment.CheckFileContent;

import java.util.ArrayList;

public class IsExist implements ICheckContent{

    public boolean fileIsExist(ArrayList<String> listOfFilesName, String nameOfFile) {
        boolean isExists = listOfFilesName.stream().anyMatch(string -> string.equals(nameOfFile));
        return isExists;
    }
}
