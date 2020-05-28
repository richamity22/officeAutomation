package com.comp.autors.helper.assets.office365;

import java.io.File;
import java.nio.file.Path;

public class CommonUtils {
    public static void sleep(int milliseconds) {
        //log.info("going to sleep for: {} [Sec]", (milliseconds / (double) 1000));
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            //log.error("InterruptedException - failed to sleep for: {} [Sec]", (milliseconds / (double) 1000));
        }
    }

    public static String getFileName(String fromPath){
        File fileFromPath = new File(fromPath);
        return fileFromPath.getName();
    }

    public static String getDirectoryName(String fromPath){
        File fileFromPath = new File(fromPath);
        Path a = fileFromPath.toPath();
        return fileFromPath.getName();
    }

    public static String getContainingPath(String absolutePath, String containingObject ){
        String[] newFolderPathNameNodes = absolutePath.split("/");
        String path="";
        for (String newFolderPathNameNode: newFolderPathNameNodes)
        {
            if (!newFolderPathNameNode.contains(containingObject)&&(!newFolderPathNameNode.isEmpty()||!newFolderPathNameNode.isBlank()))
            {
                path=path+newFolderPathNameNode+"/";
            }
        }
        return path;
    }

    public static String getContainingObject(String absolutePath){
        String[] absolutePathNodes = absolutePath.split("/");
        String containingObject = absolutePathNodes[absolutePathNodes.length - 1];
         if (containingObject.isBlank() || containingObject.isEmpty()){
             return absolutePathNodes[absolutePathNodes.length - 2];
         }
         else {
             return containingObject;
         }
    }


}
