package fileManagment.FileRepository.DeleteFile;
import Exceptions.SQLQueryException;
import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.Database.IDBconnection;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.*;

public class deleteFile implements IdeleteFile{
    private static Logger logger = Logger.getLogger(Main.class);
    IDBconnection idBconnection = new DBconnection();
    public void deleteByClassefication(String sql,String classification) throws SQLQueryException {
        logger.info("Inside the delete By Classification function");
        try {
            PreparedStatement pstmt = idBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,classification);
            pstmt.executeUpdate();
            System.out.println("File deleted..");
        }
        catch (SQLException | NullObjectException e){
            logger.info("SQLException");
            throw new SQLQueryException("Failed in deleteing files from DB");
        }
    }

    public void deleteFileByName(String FileName) throws SQLQueryException {
        logger.info("Inside the delete By Name function");
        String sql= "DELETE FROM filesinfo WHERE name = ?";
        deleteByClassefication(sql, FileName);
        logger.info("deleted from database");
    }
    public void deleteFileByType(String FileType) throws SQLQueryException {
        logger.info("Inside the delete By Type function");
        String sql = "DELETE FROM filesinfo WHERE type = ?";
        deleteByClassefication(sql,FileType);
        logger.info("deleted from database");
    }
    public void deleteFileBySize(String FileSize) throws SQLQueryException {
        logger.info("Inside the delete By Size function");
        String sql = "DELETE FROM filesinfo WHERE size = ?";
        deleteByClassefication(sql,FileSize);
        logger.info("deleted from database");
    }
    public void deleteBycustomCategory(String nameClassification) throws SQLQueryException{
        String sql = "SELECT name,type,size FROM customCategory WHERE nameClassification=?";
        PreparedStatement pstmt=null;
        try{
            pstmt = idBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,nameClassification);
            ResultSet resultSet = pstmt.executeQuery();
            DeleteByCustom.deleteByCustom(idBconnection.getConnection(),resultSet);
  
        }catch (SQLException | NullObjectException e){
            throw new SQLQueryException("Failed in deleting files from DB");
        }
    }

}

