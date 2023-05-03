package tests;

import helpers.Driver;
import helpers.Reporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    SoftAssert softAssertion;


    @BeforeSuite
    public void initDriver() {
        Driver driverInstance = Driver.getDriver();
        WebDriver driver = driverInstance.getDriverInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @BeforeSuite
    public void initPropertyFiles() {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("src/main/resources/propertyFiles/jsonPaths.properties")));
            props.load(new FileInputStream(new File("src/main/resources/propertyFiles/testConfig.properties")));
            props.load(new FileInputStream(new File("src/main/resources/propertyFiles/filePaths.properties")));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @BeforeSuite
    public void attachReport() {
        Reporter.getInstance();
    }

    @BeforeMethod
    public void initSoftAssert() {
        softAssertion = new SoftAssert();
    }

    @AfterSuite
    public void destroyDriver() {
        Driver driverInstance = Driver.getDriver();
        driverInstance.getDriverInstance().close();
        Reporter.getInstance().getExtent().flush();
    }

}
