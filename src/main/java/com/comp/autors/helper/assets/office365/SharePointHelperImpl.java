package com.comp.autors.helper.assets.office365;

import WebDriver.PageBase;
import WebDriver.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SharePointHelperImpl extends PageBase implements SharePointHelper {

    WebDriverHelper webDriverHelper;
    WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();
    WebDriverWait wait = new WebDriverWait(webDriver,60);
    Actions act = new Actions(webDriver);

    @Override
    public void login(String userName, String password) {
        Common common = new Common();
        common.login(userName,password);

        //continue the login to the service

        webDriver.get("https://automation365tests.sharepoint.com/sites/sharefiles/Shared%20Documents/Forms/AllItems.aspx");
        webDriver.manage().window().maximize();
    }

    @Override
    public void logoff() {

    }

    @Override
    public void navigateTo(String path) {
        System.out.println("navigateTo:"+path);
        String[] pathNodes = path.split("/");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[contains(@class,'ItemContent-header')]")));
        //webDriver.findElement(By.xpath("//*[text()='Documents']")).click();
        try{
            for (String pathNode : pathNodes)
            {
                System.out.println("Inside Path Navigation "+pathNode+" "+!pathNode.equals("root"));
                if ((!pathNode.equals("root"))&&!((pathNode.isBlank())||(pathNode.isEmpty())))
                {
                    String xpathPathNode = "//button[text()='" + pathNode + "']";
                    wait.until(ExpectedConditions.visibilityOfElementLocated
                            (By.xpath(xpathPathNode)));
                    webDriver.findElement(By.xpath(xpathPathNode)).click();
                    System.out.println("Navigated");
                }
            }
        } catch (Exception e) {
            System.out.println("Error with Path, Path given is invalid. "+e.toString());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void shareFolder(String pathWithFolderName, String user) {
        popShareOptions(pathWithFolderName);
        String xpathShareWithField = "//input[@placeholder='Enter a name or email address']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathShareWithField)));
        WebElement weShareWithField = webDriver.findElement(By.xpath(xpathShareWithField));
        act.moveToElement(weShareWithField).click().build().perform();
        weShareWithField.sendKeys(user);
        String xpathSuggestions = "//button[contains(@class,'Suggestions')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSuggestions)));
        WebElement weSuggestions = webDriver.findElement(By.xpath(xpathSuggestions));
        act.moveToElement(weSuggestions).click().build().perform();
        String xpathSendEmail = "//div[contains(@class,'emailButton')]//button";
        WebElement weSendEmail = webDriver.findElement(By.xpath(xpathSendEmail));
        act.moveToElement(weSendEmail).click().build().perform();
        webDriver.switchTo().defaultContent();
    }

    public void popShareOptions(String fullPath) {
        selectFileOrFolder(fullPath);
        String xpathShare = "//button[@role='menuitem'][@name='Share']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathShare)));
        webDriver.findElement(By.xpath(xpathShare)).click();
        String xpathShareWithField = "//input[@placeholder='Enter a name or email address']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='shareFrame']")));
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@id='shareFrame']")));
    }

    public void selectFileOrFolder (String pathWithObjectName) {
        String folderName = CommonUtils.getContainingObject(pathWithObjectName);
        String path=CommonUtils.getContainingPath(pathWithObjectName,folderName);
        navigateTo(path);
        selectObject(folderName);
    }

    public void selectObject(String object) {
        String xpathSelectObject = "//button[text()='"+object+"']/../../../../../../preceding-sibling::div";
        String xpathObject = "//button[text()='"+object+"']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathObject)));
        WebElement weObject = webDriver.findElement(By.xpath(xpathObject));
        WebElement weSelectObject = webDriver.findElement(By.xpath(xpathSelectObject));
        waitForVisibility(weObject,10);
        act.moveToElement(weObject).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelectObject)));
        act.moveToElement(weSelectObject).perform();
        weSelectObject.click();
    }

    @Override
    public void shareFile(String pathWithFileName, String user) {
        shareFolder(pathWithFileName,user);
    }

    @Override
    public void unShareFolder(String pathWithFolderName) {
        popShareOptions(pathWithFolderName);
        String xPathShareHeader = "//button[contains(@class,'ShareHeader')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathShareHeader)));
        WebElement weShareHeader = webDriver.findElement(By.xpath(xPathShareHeader));
        act.moveToElement(weShareHeader).click().build().perform();
        try {
            String xpathManageAccess = "//button[contains(@name,'Access')]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathManageAccess)));
            webDriver.findElement(By.xpath(xpathManageAccess)).click();
            String xpathPermOpts = "//ul[contains(@class,'od-PermissionsList-links')]//i[@role='presentation']";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathPermOpts)));
            WebElement wePermOpts = webDriver.findElement(By.xpath(xpathPermOpts));
            act.moveToElement(wePermOpts).click().build().perform();
            String xpathRemoveLink = "//button[@aria-label='Remove link']//i";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathRemoveLink)));
            WebElement weRemoveLink = webDriver.findElement(By.xpath(xpathRemoveLink));
            act.moveToElement(weRemoveLink).click().build().perform();
            String xpathDeleteLink = "//span[text()='Delete link']";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDeleteLink)));
            WebElement weDeleteLink = webDriver.findElement(By.xpath(xpathDeleteLink));
            act.moveToElement(weDeleteLink).click().build().perform();
            webDriver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("It is already unshared " + e.toString());
            webDriver.switchTo().defaultContent();
        }
    }

    @Override
    public void unShareFile(String pathWithFileName) {
        unShareFolder(pathWithFileName);
    }

    @Override
    public void createFolder(String pathWithFolderName) {
        String folderName = CommonUtils.getContainingObject(pathWithFolderName);
        String path=CommonUtils.getContainingPath(pathWithFolderName,folderName);
        navigateTo(path);
        System.out.println(path+"::"+folderName);
        CommonUtils.sleep(5000);
        createNew(folderName, "Folder");
    }

    public void createNew(String name, String type){
        String xpathCheckName = "//button[text()='" + name + "']";
        List<WebElement> existingNames = webDriver.findElements(By.xpath(xpathCheckName));
        if ( existingNames.size() == 1 ){
            System.out.println("Specified "+type+" with Name "+name+" already exists");
        }
        else {
            WebElement weNewButton = webDriver.findElement(By.xpath("//button[@name='New']"));
            act.moveToElement(weNewButton).perform();
            act.click().perform();
            String xpathNewType="//button[@name='"+type+"']";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathNewType)));
            WebElement weNewType = webDriver.findElement(By.xpath(xpathNewType));
            act.moveToElement(weNewType).perform();
            act.click().perform();
            if (type.equals("Folder")){
                String xpathInputName="//div[contains(text(),'Create')]/../..//input";
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathInputName)));
                webDriver.findElement(By.xpath(xpathInputName)).sendKeys(name);
                String xpathCreateButton="//div[contains(text(),'Create a')]/../..//button//*[text()='Create']";
                webDriver.findElement(By.xpath(xpathCreateButton)).click();
            }
        }
    }

    @Override
    public void renameFolder(String pathWithFolderName, String newFolderName) {
        selectFileOrFolder(pathWithFolderName);
        String xpathRename = "//button[@role='menuitem'][@name='Rename']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathRename)));
        WebElement weRename = webDriver.findElement(By.xpath(xpathRename));
        act.moveToElement(weRename).click().build().perform();
        String xpathNewName = "//input[@placeholder='Enter your new name']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathNewName)));
        WebElement weNewName = webDriver.findElement(By.xpath(xpathNewName));
        act.moveToElement(weNewName).sendKeys(Keys.CLEAR).
                sendKeys(newFolderName).build().perform();
        webDriver.findElement(By.xpath("//span[text()='Save']")).click();
    }

    @Override
    public void renameFile(String pathWithFileName, String newFileName) {
        newFileName = newFileName.split("\\.")[0];
        renameFolder(pathWithFileName,newFileName);
    }

    @Override
    public void deleteFile(String pathWithFileName) {
        selectFileOrFolder(pathWithFileName);
        String xpathDelete = "//button[@role='menuitem'][@name='Delete']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDelete)));
        WebElement weRename = webDriver.findElement(By.xpath(xpathDelete));
        act.moveToElement(weRename).click().build().perform();
        String xpathConfirmDelete = "//div[contains(@class,'Modal')]//span[text()='Delete']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathConfirmDelete)));
        webDriver.findElement(By.xpath(xpathConfirmDelete)).click();
    }

    @Override
    public void deleteFolder(String pathWithFolderName) {
        deleteFile(pathWithFolderName);
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

    @Override
    public void viewFile(String pathWithFileName) {
        selectFileOrFolder(pathWithFileName);
        String xpathViewFile = "//div[@role='menubar']//span[text()='Open']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathViewFile)));
        webDriver.findElement(By.xpath(xpathViewFile)).click();
        String xpathOpenInBrowser = "//span[text()='Open in browser']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOpenInBrowser)));
        WebElement weOpenInBrowser = webDriver.findElement(By.xpath(xpathOpenInBrowser));
        act.moveToElement(weOpenInBrowser).click().build().perform();
    }

    @Override
    public void modifyFile(String pathWithFileName, String textAdditionToExist) {
        String currentWindow = webDriver.getWindowHandle();
        viewFile(pathWithFileName);
        System.out.println("Title is "+webDriver.getTitle());
        Set<String> allWindows = webDriver.getWindowHandles();
        allWindows.remove(currentWindow);
        for (String windowHandle: allWindows) {
            webDriver.switchTo().window(windowHandle);
        }
        System.out.println("Title is "+webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        webDriver.switchTo().frame("WebApplicationFrame");
        String xpathEdit = "//div[@class='Outline']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathEdit)));
        WebElement weEdit = webDriver.findElement(By.xpath(xpathEdit));
        act.click(weEdit).click().sendKeys(textAdditionToExist).build().perform();
        webDriver.switchTo().window(currentWindow);
    }

    @Override
    public void copyFileTo(String pathWithFileName,String pathCopyTo) {
        selectFileOrFolder(pathWithFileName);
        String xpathCopyTo = "//div[@role='menubar']//span[text()='Copy to']";
        copyOrMove(pathCopyTo, xpathCopyTo);
    }

    private void copyOrMove(String pathTo, String xpathTo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTo)));
        WebElement weCopyTo = webDriver.findElement(By.xpath(xpathTo));
        act.moveToElement(weCopyTo).click().build().perform();
        String[] destNodes = pathTo.split("/");
        String xpathOneDrive = "//span[text()='Your OneDrive']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOneDrive)));
        WebElement weOneDrive = webDriver.findElement(By.xpath(xpathOneDrive));
        act.moveToElement(weOneDrive).click().build().perform();
        try {
            for (String pathNode : destNodes) {
                System.out.println("Inside Path Navigation " + pathNode + " " + !pathNode.equals("root"));
                if ((!pathNode.equals("root")) && !((pathNode.isBlank()) || (pathNode.isEmpty()))) {
                    String xpathPathNode = "//div[contains(@class,'FolderSelect')]//span[text()='" + pathNode + "']";
                    wait.until(ExpectedConditions.visibilityOfElementLocated
                            (By.xpath(xpathPathNode)));
                    webDriver.findElement(By.xpath(xpathPathNode)).click();
                    System.out.println("Navigated");
                }
            }
        } catch (Exception e) {
            System.out.println("Path is incorrect, please check");
            throw e;
        }
        String xpathSelectButton = "//div[contains(@class,'FolderSelect')]//button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelectButton)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelectButton)));
        System.out.println("Selecting this folder now");
        WebElement weSelectButton = webDriver.findElement(By.xpath(xpathSelectButton));
        act.moveToElement(weSelectButton).click().build().perform();
    }

    @Override
    public void moveFileTo(String pathWithFileName,String pathMoveTo) {
        selectFileOrFolder(pathWithFileName);
        String xpathMoveTo = "//div[@role='menubar']//span[text()='Move to']";
        copyOrMove(pathMoveTo, xpathMoveTo);
    }

}
