package fileManagment;

public class FileInfo {
    private String fileName;
    private String fileType;
    private Float fileSize;

    public FileInfo(String name,String type,Float size) {
        this.fileName = name;
        this.fileType = type;
        this.fileSize = size;
    }

    public String getFileType() {
        return fileType;
    }
    public String getFileName() {
        return fileName;
    }
    public Float getSize() {
        return fileSize;
    }
}

