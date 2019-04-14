package me.xiaoyuu.datastructure.dto;

public class UploadExecution extends Execution {

    private String fileName;

    public UploadExecution(String fileName,int state, String stateInfo) {
        super(state, stateInfo);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}