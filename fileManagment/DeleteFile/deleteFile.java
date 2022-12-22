package fileManagment.DeleteFile;

import fileManagment.DBconnection;

import java.sql.*;

public class deleteFile{
    public void deleteByClassefication(String sql,String classification){
        try {
            PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,classification);
            pstmt.executeUpdate();
            System.out.println("File deleted..");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteFileByName(String FileName) {
        String sql="DELETE FROM student WHERE name = ?";
        deleteByClassefication(sql, FileName);
    }
    public void deleteFileByType(String FileType) {
        String sql="DELETE FROM student WHERE type = ?";
        deleteByClassefication(sql,FileType);
    }
    public void deleteFileBySize(String FileSize){
        String sql="DELETE FROM student WHERE size = ?";
        deleteByClassefication(sql,FileSize);
    }


}

