package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootType;

public class DriverAction {
    private static DriverAction driverAction = null;
    private WebDriver driver;

    private DriverAction() {
        Driver driverInstance = Driver.getDriver();
        this.driver = driverInstance.getDriverInstance();
    }

    public static DriverAction getInstance() {
        if (driverAction == null) {
            driverAction = new DriverAction();
        }
        return driverAction;

    }


    public void navigate(String url) {
        driver.get(url);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public String getText (By locator){

        return driver.findElement(locator).getText();

    }
    public String getHref (By locator){

        return driver.findElement(locator).getAttribute("href");

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
