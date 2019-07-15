package com.javarush.task.task31.task3113;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
Что внутри папки?
*/
public class Solution {
    public static class PrintFiles
            extends SimpleFileVisitor<Path> {
        private int folderCount=0, fileCount=0, fullSize=0;

        public void setFullSize(int fullSize) {
            this.fullSize = fullSize;
        }

        public int getFullSize() {
            return fullSize;
        }


        public int getFileCount() {
            return fileCount;
        }

        public void setFolderCount(int folderCount) {
            this.folderCount = folderCount;
        }

        public void setFileCount(int fileCount) {
            this.fileCount = fileCount;
        }

        public int getFolderCount() {
            return folderCount;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            fileCount++;
            fullSize+=attrs.size();
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            folderCount++;
            return super.postVisitDirectory(dir, exc);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String folderPath = reader.readLine();
        Path path = Paths.get(folderPath);
        if (!Files.isDirectory(path)) {
            System.out.println(path.toString()+" - не папка");
        }
        else
        {
            PrintFiles pf = new PrintFiles();
            Files.walkFileTree(path, pf);
            System.out.println("Всего папок - " + (pf.getFolderCount()-1));
            System.out.println("Всего файлов - "+ pf.getFileCount());
            System.out.println("Общий размер - "+ pf.getFullSize());
        }
    }
}
