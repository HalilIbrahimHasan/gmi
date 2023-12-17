package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    private static int timeout = 5;
    //What?=>It is just to create, initialize the driver instance.(Singleton driver)
    //Why?=>We don't want to create and initialize the driver when we don't need
    //We will create and initialize the driver when it is null
    //We can use Driver class with different browser(chrome,firefox,headless)
    private Driver(){
        //we don't want to create another abject. Singleton pattern
    }

    //create a driver instance
    static WebDriver driver;




    //to initialize the driver we create a static method
    public static WebDriver getDriver() {
        //create the driver if and only if it is null
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            if ("chrome".equals(browser)) {

                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {

                driver = new FirefoxDriver();
            } else if ("ie".equals(browser)) {

                driver = new InternetExplorerDriver();
            } else if ("safari".equals(browser)) {

                driver = new SafariDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){//if the driver is pointing chrome
            driver.quit();//quit the driver
            driver=null;//set it back to null to make sure driver is null
            // so I can initialize it again
            //This is important especially you do cross browser testing(testing with
            // multiple browser like chrome, firefox, ie etc.)
        }
    }

    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndClick(WebElement element) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static void waitAndSendText(WebElement element,String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndSendTextWithDefaultTime(WebElement element,String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static String waitAndGetText(WebElement element, int timeout) {
        String text="";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }

    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
