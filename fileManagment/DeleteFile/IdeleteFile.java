package fileManagment.DeleteFile;

public interface IdeleteFile {
        public void deleteByClassefication(String sql,String classification);
        public void deleteFileByName(String FileName);
        public void deleteBycustomCategory(String nameClassification);
    }

