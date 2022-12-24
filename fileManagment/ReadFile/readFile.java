package fileManagment.ReadFile;

import fileManagment.Database.DBconnection;

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
            pstmt = DBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,fileName);
            pstmt.setInt(2,Version);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
                content = rs.getString(1);
        }

        catch (SQLException e )
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
