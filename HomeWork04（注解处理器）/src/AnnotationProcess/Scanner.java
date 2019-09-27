package AnnotationProcess;

import java.io.File;
import java.util.*;

public class Scanner {
    static List<File> allClassFile  = new ArrayList<>();
    public static List<File> getClassFiles(String url){

        File file = new File(url);
        //如果是目录，则递归搜索该目录
        if (file.isDirectory()){
            fillClassFiles(file);
        }else{
            ///否则，如果是.class文件,将其加入到LIST中
            if (isClassFile(file)){
                allClassFile.add(file);
            }
        }
        return allClassFile;
    }

    /**
     * 递归函数：递归搜索目录
     * @param directory 目录
     */
    private static void fillClassFiles(File directory) {
        File[] list = directory.listFiles();
        for(File file: list){
            if (file.isDirectory()){
                fillClassFiles(file);
            }else{
                if (isClassFile(file)){
                    allClassFile.add(file);
                }
            }
        }
    }
    /**
     * 是否是class文件
     * @param file 目标文件
     * @return 是否匹配
     */
    private static boolean isClassFile(File file) {
        return getFileType(file).equals("class");
    }

    /**
     * 获取文件类型
     * @param file 目标文件（编译之后的.class文件）
     * @return 文件后缀名
     */
    private static String getFileType(File file) {
        String fileName=  file.getName();
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }


}

