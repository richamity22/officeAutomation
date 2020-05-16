package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    static WebDriver webDriver;
    public static WebDriver getWebDriver(){
        if(webDriver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
            webDriver=new ChromeDriver();
        }
        return webDriver;
    }
}
