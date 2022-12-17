package fileManagment;

public class main {
    public static void main(String[] args) {
       DBconnection.getConnection();
       DBconnection.Close();
    }
}
