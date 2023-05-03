package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import helpers.DriverAction;
import helpers.JsonReader;
import helpers.Localization;
import helpers.Reporter;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SubscriptionPage;

public class SubscriptionPageTests extends BaseTest {

    DriverAction action;
    SubscriptionPage subscriptionPage;

    JsonReader jsonReader;

    @BeforeClass
    @Parameters({"country", "language"})
    public void initTests(String country, String language) {
        action = DriverAction.getInstance();
        subscriptionPage = new SubscriptionPage();
        jsonReader = JsonReader.getInstance();
        jsonReader.readData(System.getProperty("subscription.strings"));
        Localization localization = Localization.getInstance();
        localization.setLocale(language);
        localization.setCountry(country);

    }

    @BeforeClass
    public void navigationToTestPage() {
        if (!action.getCurrentUrl().equals(System.getProperty("url")))
            action.navigate(System.getProperty("url"));
        subscriptionPage.selectCountry();
        subscriptionPage.selectLanguage();
    }

    @BeforeMethod
    @Parameters({"country", "language"})
    public void startTestCaseReport(String country, String language, ITestResult result) {
        Reporter.getInstance().getExtent().createTest(result.getMethod().getMethodName() + "[ country : " + country + " ] [ language : " + language + " ]");
    }

    @Test
    public void validateLitePlanValuesAreCorrect() {
        softAssertion.assertEquals(subscriptionPage.getLiteTitleName(), jsonReader.getExpectedValueAsString(System.getProperty("lite.title")));
        softAssertion.assertEquals(subscriptionPage.getLiteTitleSelectionButton(), jsonReader.getExpectedValueAsString(System.getProperty("lite.selectionButton")));
        softAssertion.assertEquals(subscriptionPage.getLitePrice(), jsonReader.getExpectedValueAsString(System.getProperty("lite.price")));
        softAssertion.assertAll();
    }


    @Test
    public void validateClassicPlanValuesAreCorrect() {
        softAssertion.assertEquals(subscriptionPage.getClassicTitleName(), jsonReader.getExpectedValueAsString(System.getProperty("classic.title")));
        softAssertion.assertEquals(subscriptionPage.getClassicTitleSelectionButton(), jsonReader.getExpectedValueAsString(System.getProperty("classic.selectionButton")));
        softAssertion.assertEquals(subscriptionPage.getClassicPrice(), jsonReader.getExpectedValueAsString(System.getProperty("classic.price")));
        softAssertion.assertAll();
    }

    @Test
    public void validatePremiumPlanValuesAreCorrect() {
        softAssertion.assertEquals(subscriptionPage.getPremiumTitleName(), jsonReader.getExpectedValueAsString(System.getProperty("premium.title")));
        softAssertion.assertEquals(subscriptionPage.getPremiumTitleSelectionButton(), jsonReader.getExpectedValueAsString(System.getProperty("premium.selectionButton")));
        softAssertion.assertEquals(subscriptionPage.getPremiumPrice(), jsonReader.getExpectedValueAsString(System.getProperty("premium.price")));
        softAssertion.assertAll();
    }

}
