package WebDriver;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

//    private static final Logger log = LoggerFactory.getLogger(PageBase.class);

    WebDriverHelper webDriverHelper = new WebDriverHelper();


    public WebElement waitUntilClickableElement(By by, int timeoutInSeconds) {
//        log.info("waitUntilClickableElement on: {} with timeout: {}", by.toString(), timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(webDriverHelper.getBrowser().getWebDriver(), timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public WebElement waitAndFind(By by) {
//        log.info("waitAndFind on: {}", by.toString());
        WebDriverWait wait = new WebDriverWait(webDriverHelper.getBrowser().getWebDriver(), 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }


    public void clickElement(WebElement element) {
//        log.info("click on: {}", element);
        try {
            new WebDriverWait(webDriverHelper.getBrowser().getWebDriver(), 10).
                    until(ExpectedConditions.visibilityOf(element)).click();
        } catch (Exception e) {
            getJavaScriptExecutor().executeScript("arguments[0].click();", element);
        }
    }


    public void setText(WebElement element, String text) {
//        log.info("send keys: {}", text);
        try {
            getJavaScriptExecutor().executeScript("arguments[0].value='" + text + "'", element);
        } catch (Exception e) {
            element.sendKeys(text);
        }
    }


    public boolean verifyElementIsPresent(WebElement element) {
        try {
            String tagName = element.getTagName();
//            log.info("verify element: {} exist", tagName);
            return true;
        } catch (Exception e) {
//            log.warn("verify element failed, wait 3 seconds to get: {}", element);
            return waitForVisibility(element, 3);
        }
    }


    public boolean waitForVisibility(WebElement element, int timeInSeconds) {
        boolean foundElem = false;
        if (element == null) {
            return false;
        }
        try {
            WebElement webElement = new WebDriverWait(webDriverHelper.getBrowser().getWebDriver(), timeInSeconds)
                    .until(ExpectedConditions.visibilityOf(element));
            if (webElement != null) {
                foundElem = true;
            }

        } catch (Throwable throwable) {
//            log.error(printElementNotFoundTitle(throwable), throwable);
        }
        return foundElem;
    }


    public boolean waitForClickable(WebElement element, int timeInSeconds) {
        boolean foundElem = false;
        if (element == null) {
            return foundElem;
        }
        try {
//            log.info("going to wait {} [Sec] for element {} before click on it", timeInSeconds, element);
            WebElement webElement = new WebDriverWait(webDriverHelper.getBrowser().getWebDriver(), timeInSeconds)
                    .until(ExpectedConditions.elementToBeClickable(element));
            if (webElement != null) {
                foundElem = true;
//                log.info("found element {} before click on it", element);
            }
        } catch (Throwable throwable) {
//            log.error(printElementNotFoundTitle(throwable), throwable);
        }
        return foundElem;
    }





    private JavascriptExecutor js = null;
    private JavascriptExecutor getJavaScriptExecutor() {
        if (js == null) {
            WebDriver webDriver = webDriverHelper.getBrowser().getWebDriver();
            if (webDriver instanceof JavascriptExecutor) {
                return js = ((JavascriptExecutor) webDriver);
            } else {
                throw new IllegalStateException("This driver does not support JavaScript!");
            }
        }
        return js;
    }
}
