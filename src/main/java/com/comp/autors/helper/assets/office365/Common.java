package com.comp.autors.helper.assets.office365;

import WebDriver.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

    WebDriverHelper webDriverHelper = new WebDriverHelper();
    public void login(String userName,String password){
        WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();
        webDriver.get("https://www.office.com/");
        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hero-banner-sign-in-to-office-365-link")));
        webDriver.findElement(By.id("hero-banner-sign-in-to-office-365-link")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
        webDriver.findElement(By.name("loginfmt")).sendKeys(userName);
        webDriver.findElement(By.id("idSIButton9")).click();
        CommonUtils.sleep(2000);
        webDriver.findElement(By.id("i0118")).sendKeys(password);
        webDriver.findElement(By.id("idSIButton9")).click();
        CommonUtils.sleep(2000);
        webDriver.findElement(By.id("idBtn_Back")).click();
    }


}
