package fileManagment.DeleteFile;

import fileManagment.Database.DBconnection;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.*;

public class deleteFile{
    private static Logger logger = Logger.getLogger(Main.class);
    public void deleteByClassefication(String sql,String classification){
        logger.info("Inside the delete By Classification function");
        try {
            PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,classification);
            pstmt.executeUpdate();
            System.out.println("File deleted..");
        }
        catch (SQLException e){
            logger.info("SQLException");
            System.out.println(e.getMessage());
        }
    }

    public void deleteFileByName(String FileName) {
        logger.info("Inside the delete By Name function");
        String sql= "DELETE FROM filesinfo WHERE name = ?";
        deleteByClassefication(sql, FileName);
        logger.info("deleted from database");
    }
    public void deleteFileByType(String FileType) {
        logger.info("Inside the delete By Type function");
        String sql = "DELETE FROM filesinfo WHERE type = ?";
        deleteByClassefication(sql,FileType);
        logger.info("deleted from database");
    }
    public void deleteFileBySize(String FileSize){
        logger.info("Inside the delete By Size function");
        String sql = "DELETE FROM filesinfo WHERE size = ?";
        deleteByClassefication(sql,FileSize);
        logger.info("deleted from database");
    }


}

