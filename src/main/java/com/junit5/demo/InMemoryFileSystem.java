package com.junit5.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryFileSystem {

    private Map<String, Directory> nameToDirectory;

    public InMemoryFileSystem() {
        nameToDirectory = new HashMap<>();
    }

    public String[] getFileandDir(String filePath) {
        String[] tokens = filePath.split("/");
        int n = tokens.length;
        String directory = "";
        for (int i = 0; i < n - 1; i++) {
            directory += "/" + tokens[i];
        }
        String file = tokens[n - 1];
        return new String[]{directory, file};
    }

    public List<String> ls(String filePath) {
        if (nameToDirectory.containsKey(filePath)) {
            List<String> filesList = Stream.of(nameToDirectory.get(filePath).getFilesList())
                    .map(files -> files.toString()).collect(Collectors.toList());
            List<String> directoriesList = Stream.of(nameToDirectory.get(filePath).getDirectories())
                    .map(directories -> directories.toString()).collect(Collectors.toList());
            return directoriesList.addAll(filesList) ? directoriesList : new LinkedList<String>();
        }
        String[] fileAndDir = getFileandDir(filePath);
        String directory = fileAndDir[0];
        String file = fileAndDir[1];

        if (nameToDirectory.containsKey(directory)) {
            if (nameToDirectory.get(directory).getFileToFileObj().containsKey(file)) {
                List<String> result = new LinkedList<>();
                result.add(file);
                return result;
            }
        }
        return new LinkedList<>();
    }

    public void mkdir(String filePath) {

    }

    public void addContentToFile(String file, String content) {
        String[] fileAndDir = getFileandDir(file);
        if(nameToDirectory.containsKey(fileAndDir[0])){
            Directory directory = nameToDirectory.get(fileAndDir[0]);
            if(directory.getFileToFileObj().containsKey(fileAndDir[1])){

            }
            else{
                String fileName = fileAndDir[1];
                _File newFile = new _File();
                newFile.setFileName(fileName);
                newFile.setContent(content);
                directory.getFileToFileObj().put(fileName, newFile);
            }
        }
        else{

        }
    }

    public String readContentFromFile(String file) {
        String[] fileAndDir = getFileandDir(file);
        if(nameToDirectory.containsKey(fileAndDir[0])){
            Directory directory = nameToDirectory.get(fileAndDir[0]);
            if(directory.getFileToFileObj().containsKey(fileAndDir[1]))
                return directory.getFileToFileObj().get(fileAndDir[1]).getContent();
            else
                return "Desired File Found";
        }
        return "No Content Found";
    }
}
