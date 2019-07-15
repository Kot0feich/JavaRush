package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize, maxSize;
    private List <Path> foundFiles = new ArrayList<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean isMinSize = false|(minSize==0);
        boolean isMaxSize = false|(maxSize==0);
        boolean isContent = false|(partOfContent==null);
        boolean isName = false|(partOfName==null);
        if ((minSize>0) && (minSize<=attrs.size())) isMinSize=true;
        if (maxSize>0 && attrs.size()<=maxSize) isMaxSize=true;

        if (partOfContent!=null) {
            String strOfContent = new String(content);
            isContent=strOfContent.contains(partOfContent);
        }
        if (partOfName!=null && file.getFileName().toString().contains(partOfName)) isName=true;
        if (isContent&&isName&&isMaxSize&&isMinSize) foundFiles.add(file);
        return super.visitFile(file, attrs);
    }
    public void setPartOfName(String name) {
        partOfName=name;
    }

    public void setPartOfContent (String content) {
        partOfContent=content;

    }
    public void setMinSize (int size) {
        minSize=size;
    }
    public void setMaxSize (int size) {
        maxSize=size;
    }

    public List<Path> getFoundFiles () {
        return foundFiles;
    }
}
