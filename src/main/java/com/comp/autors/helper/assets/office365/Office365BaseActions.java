package com.comp.autors.helper.assets.office365;

import java.io.File;

public interface Office365BaseActions {

    public void login(String userName,String password);

    public void logoff();

    public void navigateTo(String path);

    public void shareFolder(String pathWithFolderName, String user);

    public void shareFile(String pathWithFileName, String user);

    public void unShareFolder(String pathWithFolderName);

    public void unShareFile(String pathWithFileName);

    public void createFolder(String pathWithFolderName);

    public void renameFolder(String pathWithFolderName,String newFolderName);

    public void renameFile(String pathWithFileName,String newFileName);

    public void deleteFile(String pathWithFileName);

    public void deleteFolder(String pathWithFolderName);

    public void uploadFile(String pathToFile, String pathToUploadFolder);

    public void downloadFile(String pathWithFileName);

    public void downloadFolder(String pathWithFolderName);

    public void viewFile(String pathWithFileName);

    public void modifyFile(String pathWithFileName, String textAdditionToExist);

    public void copyFileTo(String pathWithFileName,String pathCopyTo);

    public void moveFileTo(String pathWithFileName,String pathMoveTo);
}
