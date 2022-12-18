package fileManagment;

public class File {
    private String fileName;
    private String fileType;
    private Float fileSize;

    public File(String name,String type,Float size) {
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

