package com.comp.autors.helper.assets.office365;

import java.io.File;

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
        return fileFromPath.getName();
    }
}
