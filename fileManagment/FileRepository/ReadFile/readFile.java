package fileManagment.FileRepository.ReadFile;

import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.Database.IDBconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class readFile {

    public static String ReadFile(String fileName,int Version) throws SQLException {
        String sql = "SELECT content FROM FILESINFO WHERE name=? and version=?";

        String content = null;
        PreparedStatement pstmt = null;
        try
        {
            IDBconnection idBconnection = new DBconnection();
            pstmt = idBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,fileName);
            pstmt.setInt(2,Version);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
                content = rs.getString(1);
        }

        catch (SQLException | NullObjectException e )
        {
            e.printStackTrace();
        }

        finally
        {
            if (pstmt !=
                    null) { pstmt.close(); }
        }

        return content;

    }
}
