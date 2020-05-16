package com.comp.autors.helper.assets.office365;

import WebDriver.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WebDriver.WebDriverHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class OneDriveHelperImpl  extends PageBase implements OneDriveHelper{
    WebDriverHelper webDriverHelper;
    WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();
    WebDriverWait wait = new WebDriverWait(webDriver,10);

    @Override
    public void login(String userName, String password) {
        Common common = new Common();
        common.login(userName,password);
        webDriver.get("https://automation365tests-my.sharepoint.com/personal/tester_automation365tests_onmicrosoft_com/_layouts/15/onedrive.aspx");
    }

    @Override
    public void logoff() {

    }

    @Override
    public void navigateTo(String path) {
        String[] pathNodes = path.split("/");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[contains(@class,'ItemContent-header')]")));
        webDriver.findElement(By.xpath("//*[text()='Files']")).click();
        try{
            for (String pathNode : pathNodes)
            {
                if (!pathNode.contains("root"))
                {
                    String xpathPathNode = "//button[text()='" + pathNode + "']";
                    wait.until(ExpectedConditions.visibilityOfElementLocated
                            (By.xpath(xpathPathNode)));
                    webDriver.findElement(By.xpath(xpathPathNode)).click();
                }
            }
        } catch (Exception e) {
            System.out.println("Error with Path, Path given is invalid. "+e.toString());
            e.printStackTrace();
            throw e;
        }
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
