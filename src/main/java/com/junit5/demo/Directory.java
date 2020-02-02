package com.junit5.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Directory {
    private String directoryName;

    private Map<String, _File> fileToFileObj;

    private List<Directory> directories;

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public Map<String, _File> getFileToFileObj() {
        return fileToFileObj;
    }

    public void setFileToFileObj(Map<String, _File> fileToFileObj) {
        this.fileToFileObj = fileToFileObj;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }

    public List<String> getFilesList() {
        List<String> filesList = new LinkedList<>();
        for (Map.Entry<String, _File> entry : fileToFileObj.entrySet()) {
            filesList.add(entry.getKey());
        }
        return getFilesList();
    }
}
