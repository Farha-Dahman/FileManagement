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
        String sql="DELETE FROM filesinfo WHERE name = ?";
        deleteByClassefication(sql, FileName);
    }
    public void deleteFileByType(String FileType) {
        String sql="DELETE FROM filesinfo WHERE type = ?";
        deleteByClassefication(sql,FileType);
    }
    public void deleteFileBySize(String FileSize){
        String sql="DELETE FROM filesinfo WHERE size = ?";
        deleteByClassefication(sql,FileSize);
    }
    public void deleteBycustomCategory(String nameClassification){
        String sql = "SELECT name,type,size FROM customCategory WHERE nameClassification=?";
        PreparedStatement pstmt=null;
        String fileName=null;
        String fileType=null;
        String fileSize=null;
        try{
            pstmt = DBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,nameClassification);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                fileName = rs.getString(1);
                fileType= rs.getString(2);
                fileSize= rs.getString(3);
            }
            if(!fileName.equals("null")&&!fileType.equals("null")&&!fileSize.equals("null")) {
                String deleteSql = "DELETE FROM filesinfo WHERE name = ? and type=? and size=?";
                PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(deleteSql);
                pstmtdelete.setString(1, fileName);
                pstmtdelete.setString(2, fileType);
                pstmtdelete.setString(3, fileSize);
                pstmtdelete.executeUpdate();
            }else if(!fileName.equals("null")&&!fileType.equals("null")&&fileSize.equals("null")){
                String deleteSql = "DELETE FROM filesinfo WHERE name = ? and type=?";
                PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(deleteSql);
                pstmtdelete.setString(1, fileName);
                pstmtdelete.setString(2, fileType);
                pstmtdelete.executeUpdate();
            }else if(!fileName.equals("null")&&!fileSize.equals("null")&&fileType.equals("null")){
                String deleteSql = "DELETE FROM filesinfo WHERE name = ? and size=?";
                PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(deleteSql);
                pstmtdelete.setString(1, fileName);
                pstmtdelete.setString(2, fileSize);
                pstmtdelete.executeUpdate();
            }else if(!fileType.equals("null")&&!fileSize.equals("null")&&fileName.equals("null")){
                String deleteSql = "DELETE FROM filesinfo WHERE type = ? and size=?";
                PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(deleteSql);
                pstmtdelete.setString(1, fileType);
                pstmtdelete.setString(2, fileSize);
                pstmtdelete.executeUpdate();
            }else if(fileType.equals("null")&&fileSize.equals("null")&&!fileName.equals("null")){
                deleteFileByName(fileName);
            }else if(fileName.equals("null")&&fileSize.equals("null")&&!fileType.equals("null")){
                deleteFileByType(fileType);
            }else if(fileType.equals("null")&&fileName.equals("null")&&!fileSize.equals("null")){
                deleteFileBySize(fileSize);
            }
            System.out.println("File deleted..");
        }catch (Exception e){
            e.getMessage();
        }
    }

}

