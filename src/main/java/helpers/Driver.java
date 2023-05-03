package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static Driver driverClass = null;


    private WebDriver driver;

    private Driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static Driver getDriver() {
        if (driverClass == null) {
            driverClass = new Driver();
        }
        return driverClass;
    }

    public WebDriver getDriverInstance() {
        return driver;
    }

}
