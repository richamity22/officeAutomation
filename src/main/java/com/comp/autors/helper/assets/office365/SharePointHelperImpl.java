package com.comp.autors.helper.assets.office365;

import WebDriver.PageBase;
import WebDriver.WebDriverHelper;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;

public class SharePointHelperImpl extends PageBase implements SharePointHelper {

    WebDriverHelper webDriverHelper;

    @Override
    public void login(String userName, String password) {
        Common common = new Common();
        common.login(userName,password);

        //continue the login to the service

        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();
        webDriver.get("https://automation365tests.sharepoint.com/sites/sharefiles/Shared%20Documents/Forms/AllItems.aspx");


    }

    @Override
    public void logoff() {

    }

    @Override
    public void navigateTo(String path) {
//        if(path.isEmpty() || !path.contains("root"))
//            throw new Exception("path not good");
        File fileFromPath = new File(path);
        String[] splitedPath = path.substring(0,path.length() - fileFromPath.getName().length()).split("/");
    }

    @Override
    public void shareFolder(String pathWithFolderName) {
        navigateTo(pathWithFolderName);
        String name = CommonUtils.getDirectoryName(pathWithFolderName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void shareFile(String pathWithFileName) {
        navigateTo(pathWithFileName);
        String name = CommonUtils.getDirectoryName(pathWithFileName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void unShareFolder(String pathWithFolderName) {
        navigateTo(pathWithFolderName);
        String name = CommonUtils.getDirectoryName(pathWithFolderName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void unShareFile(String pathWithFileName) {
        navigateTo(pathWithFileName);
        String name = CommonUtils.getDirectoryName(pathWithFileName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void createFolder(String pathWithFolderName) {
        navigateTo(pathWithFolderName);
        String name = CommonUtils.getDirectoryName(pathWithFolderName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void renameFolder(String pathWithFolderName, String newFolderName) {
        navigateTo(pathWithFolderName);
        String name = CommonUtils.getDirectoryName(pathWithFolderName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void renameFile(String pathWithFileName, String newFileName) {
        navigateTo(pathWithFileName);
        String name = CommonUtils.getDirectoryName(pathWithFileName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void deleteFile(String pathWithFileName) {
        navigateTo(pathWithFileName);
        String name = CommonUtils.getDirectoryName(pathWithFileName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void deleteFolder(String pathWithFolderName) {
        navigateTo(pathWithFolderName);
        String name = CommonUtils.getDirectoryName(pathWithFolderName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void uploadFile(String pathToFile, String pathToUploadFolder) {
        //implement this the last
    }

    @Override
    public void downloadFile(String pathWithFileName) {
        navigateTo(pathWithFileName);
        String name = CommonUtils.getDirectoryName(pathWithFileName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }

    @Override
    public void downloadFolder(String pathWithFolderName) {
        navigateTo(pathWithFolderName);
        String name = CommonUtils.getDirectoryName(pathWithFolderName);
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();

        //implemtation here
    }
}
