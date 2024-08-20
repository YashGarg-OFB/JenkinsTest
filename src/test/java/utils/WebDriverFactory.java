package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver createDriver() {

        //Setting Chrome Driver path
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver-linux64/chromedriver");

        //Setting Chrome Profile
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized"); // open Browser in maximized mode
//        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        //options.addArguments("--disable-gpu"); // applicable to windows os only
//        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//        options.addArguments("--no-sandbox"); // Bypass OS security model
        //options.addArguments("--headless");
        options.addArguments("start-maximized", "--disable-infobars", "--remote-allow-origins=*", "--disable-dev-shm-usage", "--no-sandbox");
        //options.addArguments("user-data-dir=src/test/java/resources/AutomationProfile9/Default");
        WebDriver driver = new ChromeDriver(options);

        //Adding Implicit wait that applies to all elements to avoid ElementNotFoundException
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }
}
