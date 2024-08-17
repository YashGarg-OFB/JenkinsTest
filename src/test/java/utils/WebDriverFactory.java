package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver createDriver() {

        //Setting Chrome Driver path
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        //Setting Chrome Profile
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--disable-infobars", "--remote-allow-origins=*", "--disable-dev-shm-usage", "--no-sandbox");
        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile9");
        WebDriver driver = new ChromeDriver(options);

        //Adding Implicit wait that applies to all elements to avoid ElementNotFoundException
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }
}
