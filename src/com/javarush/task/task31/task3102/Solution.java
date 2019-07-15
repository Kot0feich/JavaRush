package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> arrayList = new ArrayList<>();
        Queue<File> que = new LinkedList<>();
        que.add(new File(root));
        while (que.peek() != null) {
            File directory = que.remove();
            for (File file : directory.listFiles()) {
                if (file.isDirectory())
                    que.add(file);
                else arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;

    }

    public static void main(String[] args) throws Exception{
        List<String> fileList = new ArrayList<>();
        Solution solution = new Solution();
        String root = "D:\\MyData\\Documents\\temp\\60";
        fileList = solution.getFileTree(root);


    }
}
